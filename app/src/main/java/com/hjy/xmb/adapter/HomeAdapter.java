package com.hjy.xmb.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fy.baselibrary.utils.imgload.ImgLoadUtils;
import com.hjy.xmb.R;
import com.hjy.xmb.bean.ListToAppBean;

import java.util.List;

/**
 * Created by QKun on 2018/5/7.
 */

public class HomeAdapter extends BaseQuickAdapter<ListToAppBean.RowsBean, BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<ListToAppBean.RowsBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, ListToAppBean.RowsBean item) {
        if (!TextUtils.isEmpty(item.getGoodsPic())){
            ImgLoadUtils.loadImage(mContext, item.getGoodsPic(), helper.getView(R.id.icon));
        }

        helper.setText(R.id.tv_money, "￥" + item.getGoodsSalePrice());
        helper.setText(R.id.text, item.getGoodsName());
    }
}
