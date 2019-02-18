package com.hjy.xmb.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fy.baselibrary.utils.imgload.ImgLoadUtils;
import com.hjy.xmb.R;
import com.hjy.xmb.bean.OrderBean;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.NineGridViewAdapter;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 初夏小溪 on 2018/5/8 0008.
 */

public class OrderTwoAdapter extends BaseMultiItemQuickAdapter<OrderBean.RowsBean, BaseViewHolder> {

    private List<OrderBean.RowsBean> mRowsBeans = new ArrayList<>();

    public OrderTwoAdapter(@Nullable List<OrderBean.RowsBean> data) {
        super(data);
        addItemType(OrderBean.RowsBean.TYPE_ONE, R.layout.recycler_view_type_one);
        addItemType(OrderBean.RowsBean.TYPE_TWO, R.layout.recycler_view_type_two);
        mRowsBeans.addAll(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean.RowsBean item) {
        switch (helper.getItemViewType()) {
            case OrderBean.RowsBean.TYPE_ONE:
                helper.setText(R.id.tv_time, item.getCreateTime());
//                helper.setText(R.id.tv_payment, item.getOrderStatus());

                ImgLoadUtils.loadImage(mContext, item.getGoodsList().get(0).getGoodsPic(), helper.getView(R.id.image));
                helper.setText(R.id.text, item.getGoodsList().get(0).getGoodsName());

//                helper.setText(R.id.tv_order, "共" + mRowsBeans.size() + "件商品 应付总额：¥ " + item.getOrderAmountTotal());

                helper.addOnClickListener(R.id.tv_pay);
                helper.addOnClickListener(R.id.tv_logistics);
                break;
            case OrderBean.RowsBean.TYPE_TWO:
                helper.setText(R.id.tv_time, item.getCreateTime());
//                helper.setText(R.id.tv_payment, item.getOrderStatus());

                NineGridView nineGridView = helper.getView(R.id.nine_grid_image);
                ArrayList<ImageInfo> imageInfos = new ArrayList<>();
                List<OrderBean.RowsBean.GoodsListBean> goodsList = item.getGoodsList();
                if (goodsList != null) {
                    for (OrderBean.RowsBean.GoodsListBean goodsListBean : goodsList) {
                        ImageInfo imageInfo = new ImageInfo();
                        imageInfo.setThumbnailUrl(goodsListBean.getGoodsPic());
                        imageInfo.setBigImageUrl(goodsListBean.getGoodsPic());
                        imageInfos.add(imageInfo);
                    }
                }
                nineGridView.setAdapter(new NineGridViewClickAdapter(mContext, imageInfos));

//                helper.setText(R.id.tv_order, "共" + mRowsBeans.size() + "件商品 应付总额：¥ " + item.getOrderAmountTotal());

                helper.addOnClickListener(R.id.tv_pay);
                helper.addOnClickListener(R.id.tv_logistics);
                break;

        }

    }

}
