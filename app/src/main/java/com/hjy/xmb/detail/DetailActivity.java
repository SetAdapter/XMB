package com.hjy.xmb.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fy.baselibrary.retrofit.NetCallBack;
import com.fy.baselibrary.retrofit.RequestUtils;
import com.fy.baselibrary.retrofit.RxHelper;
import com.fy.baselibrary.retrofit.dialog.IProgressDialog;
import com.fy.baselibrary.statusbar.MdStatusBar;
import com.fy.baselibrary.utils.T;
import com.fy.baselibrary.utils.imgload.ImgLoadUtils;
import com.hjy.xmb.BaseActivity;
import com.hjy.xmb.R;
import com.hjy.xmb.api.ApiService;
import com.hjy.xmb.bean.ConfirmOrderBean;
import com.hjy.xmb.bean.ListToAppBean;
import com.hjy.xmb.obligation.ObligationActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

/**
 * 商品详情
 * Created by QKun on 2018/5/8.
 */
public class DetailActivity extends BaseActivity {
    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.tv_base_title)
    TextView tv_base_title;
    @BindView(R.id.detail_iv)
    AppCompatImageView mDetailIv;
    @BindView(R.id.tvCommodityUnitPrice)
    TextView tvCommodityUnitPrice;
    @BindView(R.id.tvCommodityName)
    TextView mTvCommodityName;
    @BindView(R.id.tvCount)
    TextView mTvCount;
    @BindView(R.id.tvSpecifications)
    TextView mTvSpecifications;
    @BindView(R.id.tvShopping)
    TextView mTvShopping;
    @BindView(R.id.tvAdd)
    TextView mTvAdd;
    @BindView(R.id.tvPurchase)
    TextView mTvPurchase;
    private ListToAppBean mListToAppBean;

    ListToAppBean.RowsBean mRowsBean;

    private List<String> mStrings = new ArrayList<>();

    @Override
    protected int getContentView() {
        return R.layout.activity_detail;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initData(Bundle savedInstanceState) {
        MdStatusBar.setColorBar(this, R.color.colorPrimaryDark, R.color.colorPrimaryDark);
        tv_base_title.setText("商品详情");
        back_iv.setVisibility(View.VISIBLE);

        Bundle bundle = getIntent().getExtras();
        mRowsBean = (ListToAppBean.RowsBean) bundle.getSerializable("homeBean");

        if (mRowsBean != null) {
            mTvCommodityName.setText(mRowsBean.getGoodsName());
            ImgLoadUtils.loadImage(this, mRowsBean.getGoodsPic(), mDetailIv);
            tvCommodityUnitPrice.setText("￥" + mRowsBean.getGoodsSalePrice());
        }
    }

    @OnClick({R.id.back_iv, R.id.tvAdd, R.id.tvPurchase})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvAdd://加入购物车
                if (mRowsBean != null) {
                    List<ListToAppBean.RowsBean> goodsList = new ArrayList<>();

                    //  if (null ==mRowsBean ) {
                    mListToAppBean = new ListToAppBean();
                    //       goodsList = new ArrayList<>();
                    // } else {
                    // goodsList = mListToAppBean.getRows();
                    //if (null == goodsList) goodsList = new ArrayList<>();
                    //  }

                    goodsList.add(mRowsBean);
                    mListToAppBean.setRows(goodsList);

                    mCache.put("GoodsArray", mListToAppBean);
                    saveCart(mRowsBean.getGoodsNo());
                }
                break;
            case R.id.tvPurchase://立即购买
                String goodsNo = mRowsBean.getGoodsNo();
                getImmediateBuy(goodsNo);
                break;
            case R.id.back_iv:
                finish();
                break;
        }
    }


    /**
     * 商品详情中来确认订单 9.直接购买
     *
     * @param strings
     */
    private void getImmediateBuy(String strings) {
        IProgressDialog progressDialog = new IProgressDialog().init(mContext).setDialogMsg(R.string.data_loading);
        RequestUtils.create(ApiService.class)
                .getImmediateBuy(strings)
                .compose(RxHelper.handleResult())
                .doOnSubscribe(RequestUtils::addDispos)
                .subscribe(new NetCallBack<ConfirmOrderBean>(progressDialog) {
                    @Override
                    protected void onSuccess(ConfirmOrderBean confirmOrderBean) {
                        if (confirmOrderBean != null) {
                            Intent intent = new Intent(DetailActivity.this, ObligationActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("confirmOrderBean", confirmOrderBean);
                            bundle.putInt("type", 1);
                            intent.putExtras(bundle);
                            startActivity(intent);

                        }

                    }

                    @Override
                    protected void updataLayout(int flag) {
                    }
                });
    }

    private void saveCart(String goodsNo) {
        IProgressDialog progressDialog = new IProgressDialog().init(mContext)
                .setDialogMsg(R.string.data_loading);

        Map<String, Object> param = new HashMap<>();
        param.put("goodsNo", goodsNo);
        param.put("goodBuyAmount", 10);

//        RequestUtils.create(ApiService.class)
//                .saveCart(param)
//                .compose(RxHelper.handleResult())
//                .doOnSubscribe(RequestUtils::addDispos)
//                .subscribe(new NetCallBack<Object>(progressDialog) {
//                    @Override
//                    protected void onSuccess(Object login) {
//                        T.showLong("已加入购物车");
//                    }
//
//                    @Override
//                    protected void updataLayout(int flag) {
//                    }
//                });

        Observable<Object> aa = RequestUtils.create(ApiService.class)
                .saveCart(param)
                .compose(RxHelper.handleResult())
                .doOnSubscribe(RequestUtils::addDispos);

        RequestUtils.request(aa, "cart/save")
                .subscribe(new NetCallBack<Object>() {
                    @Override
                    protected void onSuccess(Object login) {
                        T.showLong("已加入购物车");
                    }

                    @Override
                    protected void updataLayout(int flag) {
                    }
                });
    }
}
