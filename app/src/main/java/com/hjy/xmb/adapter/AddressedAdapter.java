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
public class AddressedAdapter extends BaseQuickAdapter<ConfirmOrderBean.ListAddressBean, BaseViewHolder> {

    public AddressedAdapter(int layoutResId, @Nullable List<ConfirmOrderBean.ListAddressBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ConfirmOrderBean.ListAddressBean item) {
        helper.setText(R.id.tv_name, item.getConsigneeName()).setText(R.id.tv_phone, item.getTelphone())
                .setText(R.id.tv_site, item.getProvince() + item.getCity() + item.getArea() + item.getStreet());
    }
}
