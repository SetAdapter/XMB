package com.hjy.xmb.expressage;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjy.xmb.R;
import com.hjy.xmb.bean.ExpressageBean;

import java.util.List;


/**
 * 追踪物流列表的适配器
 */

public class TracesAdapter extends BaseQuickAdapter<ExpressageBean.RowsBean, BaseViewHolder> {

    List<ExpressageBean.RowsBean> mExpressageBeans;

    public TracesAdapter(int layoutResId, @Nullable List<ExpressageBean.RowsBean> data) {
        super(layoutResId, data);
        this.mExpressageBeans = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ExpressageBean.RowsBean item) {

        TextView accept_time_tv = helper.getView(R.id.accept_time_tv); //时间
        TextView accept_station_tv = helper.getView(R.id.accept_station_tv); //地点
        ImageView dotIv = helper.getView(R.id.dot_iv); //当前位置
        View dividerLineView = helper.getView(R.id.divider_line_view); //时间轴的竖线
        View timeLineView = helper.getView(R.id.time_line_view); //水平的分割线
        accept_time_tv.setText(item.getLogisticsStatusCreateTime());
        accept_station_tv.setText(item.getLogisticsStatusDescription());

        int type = item.getLogisticsCurrentSign();
        if (type == 1) {
            accept_time_tv.setTextColor(mContext.getResources().getColor(R.color.color_c03));
            accept_station_tv.setTextColor(mContext.getResources().getColor(R.color.color_c03));
            dotIv.setImageResource(R.mipmap.dot_red);
        } else {
            accept_time_tv.setTextColor(mContext.getResources().getColor(R.color.txtSecondColor));
            accept_station_tv.setTextColor(mContext.getResources().getColor(R.color.txtSecondColor));
            dotIv.setImageResource(R.mipmap.dot_black);
        }

        if (helper.getLayoutPosition() == mExpressageBeans.size() - 1) {
            //最后一条数据，隐藏时间轴的竖线和水平的分割线
            dividerLineView.setVisibility(View.GONE);
            timeLineView.setVisibility(View.GONE);
        }
    }

}
