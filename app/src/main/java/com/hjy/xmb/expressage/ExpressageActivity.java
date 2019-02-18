package com.hjy.xmb.expressage;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fy.baselibrary.retrofit.NetCallBack;
import com.fy.baselibrary.retrofit.RequestUtils;
import com.fy.baselibrary.retrofit.RxHelper;
import com.fy.baselibrary.retrofit.dialog.IProgressDialog;
import com.fy.baselibrary.statusbar.MdStatusBar;
import com.hjy.xmb.BaseActivity;
import com.hjy.xmb.R;
import com.hjy.xmb.api.ApiService;
import com.hjy.xmb.bean.ExpressageBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by 初夏小溪 on 2018/5/7 0007.
 * 物流追踪效果
 */

public class ExpressageActivity extends BaseActivity {

    @BindView(R.id.back_iv)
    ImageView mBackIv;
    @BindView(R.id.main_pic_iv)
    ImageView main_pic_iv;
    @BindView(R.id.tv_base_title)
    TextView mBaseTitle;
    @BindView(R.id.traceRv)
    RecyclerView mRecyclerView;//物流追踪列表
    private TracesAdapter mAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_expressage;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        MdStatusBar.setColorBar(this, R.color.colorPrimaryDark, R.color.colorPrimaryDark);
        mBaseTitle.setText("物流信息");
        String orderNo = getIntent().getExtras().getString("orderNo");
        getStatus(orderNo);
        initRecyclerView();
        mBackIv.setVisibility(View.VISIBLE);

        mBackIv.setOnClickListener(v -> finish());
    }


    private void getStatus(String orderNo) {
        IProgressDialog progressDialog = new IProgressDialog().init(mContext).setDialogMsg(R.string.data_loading);
        Map<String, Object> param = new HashMap<>();
        param.put("pageNo", 1);
        param.put("pageSize", 10);
        param.put("orderNo", orderNo);
        RequestUtils.create(ApiService.class)
                .status(param)
                .compose(RxHelper.handleResult())
                .doOnSubscribe(RequestUtils::addDispos)
                .subscribe(new NetCallBack<ExpressageBean>(progressDialog) {
                    @Override
                    protected void onSuccess(ExpressageBean t) {
                        mAdapter.setNewData(t.getRows());
                    }

                    @Override
                    protected void updataLayout(int flag) {

                    }
                });
    }

    //初始化显示物流追踪的RecyclerView
    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TracesAdapter(R.layout.item_trace, new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
    }
}
