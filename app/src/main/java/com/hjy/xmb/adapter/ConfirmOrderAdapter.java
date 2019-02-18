package com.hjy.xmb.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjy.xmb.R;
import com.hjy.xmb.bean.ConfirmOrderBean;

import java.util.List;

/**
 * Created by 初夏小溪 on 2018/5/16 0016.
 */
public class ConfirmOrderAdapter extends BaseQuickAdapter<ConfirmOrderBean.ListTransferStationBean, BaseViewHolder> {

    public ConfirmOrderAdapter(int layoutResId, @Nullable List<ConfirmOrderBean.ListTransferStationBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ConfirmOrderBean.ListTransferStationBean item) {
        helper.setText(R.id.tv_title, item.getTransferStationName());
    }
}
