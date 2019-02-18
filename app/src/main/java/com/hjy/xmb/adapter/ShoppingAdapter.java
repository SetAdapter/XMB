package com.hjy.xmb.adapter;

import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fy.baselibrary.utils.BigDecimalUtil;
import com.hjy.xmb.R;
import com.hjy.xmb.bean.HomeBean;
import com.hjy.xmb.bean.ListToAppBean;

import java.util.List;

/**
 * Created by Stefan on 2018/5/8.
 */

public class ShoppingAdapter extends BaseItemDraggableAdapter<ListToAppBean.RowsBean, BaseViewHolder> {
    protected SparseBooleanArray mSelectedPositions;//保存多选 数据
    private CheckBox cb;
    private TextView tv_price;

    public ShoppingAdapter(@Nullable List<ListToAppBean.RowsBean> data) {
        super(R.layout.item_shopping, data);
        mSelectedPositions = new SparseBooleanArray();
    }

    @Override
    protected void convert(BaseViewHolder helper, ListToAppBean.RowsBean item) {
        helper.setText(R.id.tv_price, BigDecimalUtil.fromat4S5R(item.getGoodsSalePrice(),2));
        helper.setText(R.id.tv_name, item.getGoodsName());
        helper.setText(R.id.tv_num, item.getGoodBuyAmount() + "");
        //helper.setBackgroundRes(R.id.iv_img, item.getDrawbles());
        Glide.with(mContext).load(item.getGoodsPic()).into((ImageView) helper.getView(R.id.iv_img));
        // helper.setText(R.id.tv_count, item.getCount() + "个");
        TextView tv_count = helper.getView(R.id.tv_count);
        CheckBox cb_item=helper.getView(R.id.cb_item);
        tv_count.setText(item.getGoodBuyAmount() + "个");
        helper.addOnClickListener(R.id.tv_plus);
        helper.addOnClickListener(R.id.tv_reduce);
        helper.addOnClickListener(R.id.cb_item);
        if(item.isFlag()){
            cb_item.setChecked(true);
        }else {
            cb_item.setChecked(false);
        }
    }

    /**
     * 设置给定位置条目的选择状态
     *
     * @param array
     * @param position
     * @param isChecked
     */
    protected void setItemChecked(SparseBooleanArray array, int position, boolean isChecked) {
        array.put(position, isChecked);
    }

    /**
     * 根据位置判断条目是否选中
     *
     * @param position
     * @return
     */
    protected boolean isItemChecked(SparseBooleanArray array, int position) {
        return array.get(position);
    }

    /**
     * 设置全选 or 反选
     *
     * @param isAllSelect
     */
    public void setIsAllSelect(boolean isAllSelect) {
        for (int i = 0; i < getItemCount(); i++) {
            setItemChecked(mSelectedPositions, i, isAllSelect);
        }
        if (isAllSelect) {
            cb.setChecked(true);
        } else {
            cb.setChecked(false);
        }
        notifyDataSetChanged();
    }

    public SparseBooleanArray getmSelectedPositions() {
        return mSelectedPositions;
    }
}
