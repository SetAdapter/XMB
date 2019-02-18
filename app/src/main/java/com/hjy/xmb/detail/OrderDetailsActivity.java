package com.hjy.xmb.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fy.baselibrary.statusbar.MdStatusBar;
import com.hjy.xmb.BaseActivity;
import com.hjy.xmb.R;
import com.hjy.xmb.adapter.OrderDetailsAdapter;
import com.hjy.xmb.bean.ListToAppBean;
import com.hjy.xmb.bean.OrderBean;
import com.hjy.xmb.obligation.ObligationActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 初夏小溪 on 2018/5/16 0016.
 * 订单详情
 */
public class OrderDetailsActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_base_title)
    TextView tv_base_title;
    @BindView(R.id.back_iv)
    ImageView back_iv;

    OrderDetailsAdapter mAdapter;
    OrderBean.RowsBean mRowsBean;

    @Override
    protected int getContentView() {
        return R.layout.activity_order_details;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        MdStatusBar.setColorBar(this, R.color.colorPrimaryDark, R.color.colorPrimaryDark);
        tv_base_title.setText("订单详情");
        back_iv.setVisibility(View.VISIBLE);
        Bundle bundle = getIntent().getExtras();
        mRowsBean = (OrderBean.RowsBean) bundle.getSerializable("orderBean1");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new OrderDetailsAdapter(R.layout.item_order_detail, new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setEmptyView(R.layout.activity_null, (ViewGroup) mRecyclerView.getParent());
        mAdapter.setNewData(mRowsBean.getGoodsList());
    }

    @OnClick({R.id.back_iv})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
        }
    }
}
