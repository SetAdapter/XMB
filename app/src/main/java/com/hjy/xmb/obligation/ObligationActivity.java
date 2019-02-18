package com.hjy.xmb.obligation;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fy.baselibrary.base.ViewHolder;
import com.fy.baselibrary.base.dialog.CommonDialog;
import com.fy.baselibrary.base.dialog.DialogConvertListener;
import com.fy.baselibrary.base.dialog.NiceDialog;
import com.fy.baselibrary.retrofit.NetCallBack;
import com.fy.baselibrary.retrofit.RequestUtils;
import com.fy.baselibrary.retrofit.RxHelper;
import com.fy.baselibrary.retrofit.dialog.IProgressDialog;
import com.fy.baselibrary.statusbar.MdStatusBar;
import com.hjy.xmb.BaseActivity;
import com.hjy.xmb.MainActivity;
import com.hjy.xmb.R;
import com.hjy.xmb.adapter.AddressedAdapter;
import com.hjy.xmb.adapter.ConfirmOrderAdapter;
import com.hjy.xmb.api.ApiService;
import com.hjy.xmb.bean.ConfirmOrderBean;
import com.hjy.xmb.bean.OrderBean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 初夏小溪 on 2018/5/8 0008.
 * 待付款订单
 */

public class ObligationActivity extends BaseActivity {

    @BindView(R.id.tv_expressage)
    TextView mTvExpressage;
    @BindView(R.id.edit_message)
    EditText mEditMessage;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_pay)
    TextView mTvPay;
    @BindView(R.id.tv_base_title)
    TextView mBaseTitle;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_total)
    TextView mTvTotal;
    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.tv_region)
    TextView mTvRegion;
    @BindView(R.id.Ll_addressed)
    LinearLayout mLlAddressed;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_site)
    TextView mTvSite;
    @BindView(R.id.tv_delivery)
    TextView mDelivery;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.Ll_region)
    LinearLayout mLlRegion;
    @BindView(R.id.Ll_distribution)
    LinearLayout mLlDistribution;
    @BindView(R.id.Ll_context)
    LinearLayout mLlContext;

    private ObligationAdapter mAdapter;
//    final String[] arrayFruit = new String[]{"顺丰快递", "圆通快递", "中通快递", "申通快递", "中国邮政EMS"};
    final String[] arrayFruit = new String[]{"顺丰快递"};
    List<ConfirmOrderBean.ListTransferStationBean> listTransferStation;
    private List<ConfirmOrderBean.ListCartBean> mListCart;
    private List<ConfirmOrderBean.ListAddressBean> mListAddress;
    private int mTransferStationId;
    private int mAddressId;
    private List<String> mStrings = new ArrayList<>();
    private int mType;
    private double mTotal;


    @Override
    protected int getContentView() {
        return R.layout.activity_obligation;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initData(Bundle savedInstanceState) {
        MdStatusBar.setColorBar(this, R.color.colorPrimaryDark, R.color.colorPrimaryDark);
        mBaseTitle.setText("待付款订单");
        back_iv.setVisibility(View.VISIBLE);

        Bundle extras = getIntent().getExtras();
        mType = extras.getInt("type", -2);

        ConfirmOrderBean confirmOrderBean = (ConfirmOrderBean) extras.getSerializable("confirmOrderBean");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ObligationAdapter(R.layout.item_obligation, new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);

        if (null != confirmOrderBean) {
            //商品 集合数据
            mListCart = confirmOrderBean.getListCart();
            mAdapter.setNewData(mListCart);
            //地址集合数据
            mListAddress = confirmOrderBean.getListAddress();
            //中转站集合数据
            listTransferStation = confirmOrderBean.getListTransferStation();

            mTotal = setData();
            mTvTotal.setText(mTotal + "");
            mTvMoney.setText("应付金额: ¥ " + mTotal + "");
        }
    }


    private double setData() {
        double allPrice = 0.0;
        for (int i = 0; i < mAdapter.getData().size(); i++) {
            allPrice += (mAdapter.getData().get(i).getGoodsSalePrice()) * mAdapter.getData().get(i).getGoodBuyAmount();
        }
        return allPrice;
    }

    @Override
    @OnClick({R.id.Ll_distribution, R.id.tv_pay, R.id.back_iv, R.id.Ll_region, R.id.Ll_addressed})
    public void onClick(View view) {
        super.onClick(view);
        AlertDialog alertDialog;
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.Ll_distribution:
                alertDialog = new AlertDialog.Builder(this)
                        .setTitle("选择快递")
                        .setItems(arrayFruit, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mTvExpressage.setText(arrayFruit[which]);
                            }
                        }).create();
                alertDialog.show();
                break;
            //中转站
            case R.id.Ll_region:
                NiceDialog.init()
                        .setLayoutId(R.layout.dialog_obligation)
                        .setDialogConvertListener(new DialogConvertListener() {
                            @Override
                            protected void convertView(ViewHolder holder, CommonDialog dialog) {
                                RecyclerView mRecyclerView = holder.getView(R.id.recycler_region);
                                mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                                ConfirmOrderAdapter mConfirmOrderAdapter = new ConfirmOrderAdapter(R.layout.item_obligation_context, listTransferStation);
                                mRecyclerView.setAdapter(mConfirmOrderAdapter);
                                mConfirmOrderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                        mTvRegion.setText(mConfirmOrderAdapter.getData().get(position).getTransferStationName());
                                        mTransferStationId = mConfirmOrderAdapter.getData().get(position).getTransferStationId();
                                        dialog.dismiss();
                                    }
                                });

                            }
                        }).setWidthPixels(325).setHeightPixels(-2).show(getSupportFragmentManager());

                break;
                //收货人信息
            case R.id.Ll_addressed:
                NiceDialog.init()
                        .setLayoutId(R.layout.dialog_addressed)
                        .setDialogConvertListener(new DialogConvertListener() {
                            @Override
                            protected void convertView(ViewHolder holder, CommonDialog dialog) {
                                RecyclerView mRecyclerView = holder.getView(R.id.recycler_region);
                                mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                                AddressedAdapter addressedAdapter = new AddressedAdapter(R.layout.item_obligation_addressed, mListAddress);
                                mRecyclerView.setAdapter(addressedAdapter);
                                addressedAdapter.setNewData(mListAddress);
                                addressedAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                    @SuppressLint("SetTextI18n")
                                    @Override
                                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                        mAddressId = addressedAdapter.getData().get(position).getAddressId();
                                        mTvName.setText(addressedAdapter.getData().get(position).getConsigneeName());
                                        mTvPhone.setText(addressedAdapter.getData().get(position).getTelphone());
                                        mTvSite.setText(addressedAdapter.getData().get(position).getProvince() +
                                                addressedAdapter.getData().get(position).getCity() +
                                                addressedAdapter.getData().get(position).getArea() +
                                                addressedAdapter.getData().get(position).getStreet());
                                        mDelivery.setVisibility(View.GONE);
                                        mLlContext.setVisibility(View.VISIBLE);
                                        mTvSite.setVisibility(View.VISIBLE);
                                        mImage.setVisibility(View.VISIBLE);
                                        dialog.dismiss();
                                    }
                                });

                            }
                        }).setWidthPixels(325).setHeightPixels(-2).show(getSupportFragmentManager());

                break;
            case R.id.tv_pay:
                mStrings.clear();

                for (ConfirmOrderBean.ListCartBean listCartBean : mListCart) {
                    mStrings.add(listCartBean.getGoodsNo());
                }
                if (mTvName.getText().equals("")) {
                    Toast.makeText(mContext, "选择收货人", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mTvRegion.getText().equals("选择地区")) {
                    Toast.makeText(mContext, "选择中转站", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mTvExpressage.getText().equals("选择快递")) {
                    Toast.makeText(mContext, "选择快递公司", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveToApp(mAddressId, mTransferStationId, mStrings, mTotal);
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void saveToApp(int addressed, int transferStationId, List<String> strings, double goodsAmountTotal) {
        IProgressDialog progressDialog = new IProgressDialog().init(mContext).setDialogMsg(R.string.data_loading);
        Map<String, Object> param = new HashMap<>();
        param.put("addressId", addressed);
        param.put("transferStationId", transferStationId);
        param.put("goodsAmountTotal", goodsAmountTotal);
        if (mType == 1) {
            param.put("buyStyle", 1);
        } else {
            param.put("buyStyle", 0);
        }
        RequestUtils.create(ApiService.class)
                .saveToApp(param, strings)
                .compose(RxHelper.handleResult())
                .doOnSubscribe(RequestUtils::addDispos)
                .subscribe(new NetCallBack<OrderBean>(progressDialog) {
                    @Override
                    protected void onSuccess(OrderBean t) {
                        Snackbar.make(mLlAddressed, "支付订单成功", Snackbar.LENGTH_SHORT)
                                .setActionTextColor(ContextCompat.getColor(mContext, R.color.white))
                                .show();
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    Thread.sleep(2000);//休眠2秒
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Intent intent = new Intent(ObligationActivity.this, MainActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("order", true);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        }.start();

                    }

                    @Override
                    protected void updataLayout(int flag) {

                    }
                });
    }
}
