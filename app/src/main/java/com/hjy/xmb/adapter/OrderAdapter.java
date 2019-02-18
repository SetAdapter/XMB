package com.hjy.xmb.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjy.xmb.R;
import com.hjy.xmb.bean.HomeBean;
import com.hjy.xmb.bean.OrderBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.microedition.khronos.opengles.GL;

/**
 * Created by 初夏小溪 on 2018/5/8 0008.
 */

public class OrderAdapter extends BaseQuickAdapter<OrderBean.RowsBean, BaseViewHolder> {

    public OrderAdapter(int layoutResId, @Nullable List<OrderBean.RowsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean.RowsBean item) {

        RecyclerView mRecyclerView = helper.getView(R.id.recycler_external);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        OrderAdapterContext adapterContext = new OrderAdapterContext(R.layout.item_order_context, new ArrayList<>());
        mRecyclerView.setAdapter(adapterContext);
        adapterContext.setNewData(item.getGoodsList());

        helper.setText(R.id.tv_time, item.getCreateTime());
    }

}
