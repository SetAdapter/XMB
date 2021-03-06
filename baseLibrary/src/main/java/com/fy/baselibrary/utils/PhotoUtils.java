package com.fy.baselibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.fy.baselibrary.application.BaseApp;
import com.fy.baselibrary.utils.media.MediaScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Android 调用系统相机 相册 裁剪 相关方法 工具类
 * Created by fangs on 2018/1/12.
 */
public class PhotoUtils {

    private PhotoUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 调用系统相机 拍照
     *
     * @param activity      当前activity
     * @param takeImageFile 拍照成功后的图片文件
     * @param requestCode   调用系统相机请求码
     */
    public static void takePicture(Activity activity, File takeImageFile, int requestCode) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {

            if (null != takeImageFile) {
                // 默认情况下，即不需要指定intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                // 照相机有自己默认的存储路径，拍摄的照片将返回一个缩略图。如果想访问原始图片，
                // 可以通过dat extra能够得到原始图片位置。即，如果指定了目标uri，data就没有数据，
                // 如果没有指定uri，则data就返回有数据！

                Uri uri;
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
                    uri = Uri.fromFile(takeImageFile);
                } else {

                    /**
                     * 7.0 调用系统相机拍照不再允许使用Uri方式，应该替换为FileProvider
                     * 并且这样可以解决MIUI系统上拍照返回size为0的情况
                     */
                    uri = FileProvider.getUriForFile(activity, ProviderUtil.getFileProviderName(activity), takeImageFile);
                    //加入uri权限 要不三星手机不能拍照
                    List<ResolveInfo> resInfoList = activity.getPackageManager()
                            .queryIntentActivities(takePictureIntent, PackageManager.MATCH_DEFAULT_ONLY);
                    for (ResolveInfo resolveInfo : resInfoList) {
                        String packageName = resolveInfo.activityInfo.packageName;
                        activity.grantUriPermission(packageName, uri,
                                Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    }
                }

                Log.e("nanchen", ProviderUtil.getFileProviderName(activity));
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            }
        }
        activity.startActivityForResult(takePictureIntent, requestCode);
    }

    /**
     * 调用（打开）系统相册
     *
     * @param activity    当前activity
     * @param requestCode 打开相册的请求码
     */
    public static void openPic(Activity activity, int requestCode) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        photoPickerIntent.setType("image/*");
        activity.startActivityForResult(photoPickerIntent, requestCode);
    }

    /**
     * 调用系统裁剪
     *
     * @param activity    当前activity
     * @param orgUri      剪裁原图的Uri
     * @param desUri      剪裁后的图片的Uri
     * @param aspectX     X方向的比例
     * @param aspectY     Y方向的比例
     * @param width       剪裁图片的宽度
     * @param height      剪裁图片高度
     * @param requestCode 剪裁图片的请求码
     */
    public static void cropImageUri(Activity activity, Uri orgUri, Uri desUri, int aspectX,
                                    int aspectY, int width, int height, int requestCode) {

        Intent intent = new Intent("com.android.camera.action.CROP");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        intent.setDataAndType(orgUri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", aspectX);
        intent.putExtra("aspectY", aspectY);
        intent.putExtra("outputX", width);
        intent.putExtra("outputY", height);
        intent.putExtra("scale", true);
        //将剪切的图片保存到目标Uri中
        intent.putExtra(MediaStore.EXTRA_OUTPUT, desUri);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 把图片保存到指定的文件夹 并 通知图库更新
     *
     * @param bmp
     */
    public static void saveImageToGallery(Bitmap bmp) {
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(BaseApp.getAppCtx().getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 最后通知图库更新
        mediaScanConn.connect();
    }

    /**
     * 通知图库更新（4.4之后 使用）
     */
    public static MediaScannerConnection mediaScanConn = new MediaScannerConnection(BaseApp.getAppCtx(),
            new MediaScannerConnection.MediaScannerConnectionClient() {
                @Override
                public void onScanCompleted(String path, Uri uri) {  //当client和MediaScaner扫描完成后  进行关闭我们的连接
                    // TODO Auto-generated method stub
                    L.e("aaa", "扫描完成");
                    mediaScanConn.disconnect();
                }

                @Override
                public void onMediaScannerConnected() {   //当client和MediaScanner完成链接后，就开始进行扫描。
                    // TODO Auto-generated method stub
                    L.e("aaa", "扫描");
                    /** 这个方法一次只能扫描一个文件，path 必须是一个具体的文件，不能是目录 */
                    mediaScanConn.scanFile(FileUtils.getPath("/DCIM/camera/aaa.jpg"), "");
                }
            });

    /**
     * 通知系统媒体库更新 (使用此 广播方式)
     * @param context
     * @param action    扫描的类型 文件或目录（文件：Intent.ACTION_MEDIA_SCANNER_SCAN_FILE）
     * @param file      要扫描的文件
     */
    public static void scanFolder(Context context, String action, File file) {
        Intent mediaScanIntent = new Intent(action);
        Uri contentUri = Uri.fromFile(file);
        mediaScanIntent.setData(contentUri);
        context.sendBroadcast(mediaScanIntent);
    }

    /**
     * 通知系统媒体库更新
     * @param context
     * @param action    扫描的类型 文件或目录
     * @param file      要扫描的文件或目录
     */
    public static void scanMedia(Context context, String action, File file){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            new MediaScanner(context).scanFile(new File(FileUtils.getPath("/DCIM/camera/")), null);
        } else {
            scanFolder(context, action, file);
        }
    }


    /**
     * 读取uri所在的图片
     *
     * @param uri      图片对应的Uri
     * @return 获取图像的Bitmap
     */
    public static Bitmap getBitmapFromUri(Uri uri) {
        Context mContext = BaseApp.getAppCtx();
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uri);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取图片的旋转角度
     *
     * @param path 图片绝对路径
     * @return 图片的旋转角度
     */
    public static int getBitmapDegree(String path) {
        int degree = 0;
        try {
            // 从指定路径下读取图片，并获取其EXIF信息
            ExifInterface exifInterface = new ExifInterface(path);
            // 获取图片的旋转信息
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 将图片按照指定的角度进行旋转
     *
     * @param bitmap 需要旋转的图片
     * @param degree 指定的旋转角度
     * @return 旋转后的图片
     */
    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int degree) {
        // 根据旋转角度，生成旋转矩阵
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        // 将原始图片按照旋转矩阵进行旋转，并得到新的图片
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return newBitmap;
    }
}
