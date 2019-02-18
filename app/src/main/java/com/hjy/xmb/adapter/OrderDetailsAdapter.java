package com.hjy.xmb.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjy.xmb.R;
import com.hjy.xmb.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 初夏小溪 on 2018/5/16 0016.
 */
public class OrderDetailsAdapter extends BaseQuickAdapter<OrderBean.RowsBean.GoodsListBean, BaseViewHolder> {

    public OrderDetailsAdapter(int layoutResId, @Nullable List<OrderBean.RowsBean.GoodsListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean.RowsBean.GoodsListBean item) {

        helper.setText(R.id.tv_title, item.getGoodsName());
        helper.setText(R.id.tv_price, item.getGoodsPrice()+ "");
        Glide.with(mContext).load(item.getGoodsPic()).into((ImageView) helper.getView(R.id.image));
    }


}
