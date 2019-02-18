package com.hjy.xmb.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjy.xmb.R;
import com.hjy.xmb.bean.OrderBean;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by 初夏小溪 on 2018/5/15 0015.
 */

public class OrderAdapterContext extends BaseQuickAdapter<OrderBean.RowsBean.GoodsListBean, BaseViewHolder> {

    List<OrderBean.RowsBean.GoodsListBean> mList;

    public OrderAdapterContext(int layoutResId, @Nullable List<OrderBean.RowsBean.GoodsListBean> data) {
        super(layoutResId, data);
        this.mList = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean.RowsBean.GoodsListBean item) {
        helper.setText(R.id.tv_context, item.getGoodsName());//商品内容
        helper.setText(R.id.tv_money, item.getGoodsPrice() + "");//商品金额
        LinearLayout Ll_title = helper.getView(R.id.Ll_title);
//        helper.setText(R.id.tv_order, item.getPrice() + "");
//        helper.setText(R.id.tv_time, item.getTime());
//        helper.setText(R.id.tv_count, "× " + item.getCount() + "");
        Glide.with(mContext).load(item.getGoodsPic()).into((ImageView) helper.getView(R.id.icon));

        if (item.equals("")) {
            Ll_title.setVisibility(View.GONE);
        }
        helper.addOnClickListener(R.id.tv_pay);
        helper.addOnClickListener(R.id.tv_logistics);
    }

}
