package com.hjy.xmb.obligation;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjy.xmb.R;
import com.hjy.xmb.bean.ConfirmOrderBean;
import com.hjy.xmb.bean.ListToAppBean;

import java.util.List;

/**
 * Created by 初夏小溪 on 2018/5/9 0009.
 */

public class ObligationAdapter extends BaseQuickAdapter<ConfirmOrderBean.ListCartBean, BaseViewHolder> {

    public ObligationAdapter(int layoutResId, @Nullable List<ConfirmOrderBean.ListCartBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ConfirmOrderBean.ListCartBean item) {

        Glide.with(mContext).load(item.getGoodsPic()).into((ImageView) helper.getView(R.id.iv_pic));
        helper.setText(R.id.tv_title, item.getGoodsName()).setText(R.id.tv_context, "￥" + item.getGoodsSalePrice()).setText(R.id.tv_count, "×" + item.getGoodBuyAmount());
    }

}
