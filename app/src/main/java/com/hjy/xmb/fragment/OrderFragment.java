package com.hjy.xmb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fy.baselibrary.retrofit.NetCallBack;
import com.fy.baselibrary.retrofit.RequestUtils;
import com.fy.baselibrary.retrofit.RxHelper;
import com.fy.baselibrary.retrofit.dialog.IProgressDialog;
import com.fy.baselibrary.statusbar.MdStatusBar;
import com.hjy.xmb.BaseFragment;
import com.hjy.xmb.R;
import com.hjy.xmb.adapter.OrderAdapter;
import com.hjy.xmb.adapter.OrderTwoAdapter;
import com.hjy.xmb.api.ApiService;
import com.hjy.xmb.bean.ListToAppBean;
import com.hjy.xmb.bean.OrderBean;
import com.hjy.xmb.detail.DetailActivity;
import com.hjy.xmb.detail.OrderDetailsActivity;
import com.hjy.xmb.expressage.ExpressageActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by QKun on 2018/5/7.
 * 订单页面
 */

public class OrderFragment extends BaseFragment {

    private static final String FRAGMENTTHREE = "Three";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    //    private OrderAdapter mAdapter;
    private OrderTwoAdapter mAdapter;


    public static OrderFragment newInstance(String parme) {
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENTTHREE, parme);
        OrderFragment orderFragment = new OrderFragment();
        orderFragment.setArguments(bundle);
        return orderFragment;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initData() {
        MdStatusBar.setColorBar(getActivity(), R.color.colorPrimaryDark, R.color.colorPrimaryDark);
        getInit();
        mRefreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        mRefreshLayout.setRefreshFooter(new ClassicsFooter(getActivity()));
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                OrderBean.RowsBean rowsBean = mAdapter.getData().get(position);
                switch (view.getId()) {
                    case R.id.tv_pay:
                        //再次购买
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("orderBean", rowsBean);
                        Intent intent = new Intent(getActivity(), DetailActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    //查看物流
                    case R.id.tv_logistics:
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("orderNo", rowsBean.getOrderNo());
                        Intent intent1 = new Intent(getActivity(), ExpressageActivity.class);
                        intent1.putExtras(bundle1);
                        startActivity(intent1);
                        break;
                }
            }
        });
        //订单详情
//        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                OrderBean.RowsBean orderBean1 = mAdapter.getData().get(position);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("orderBean1", orderBean1);
//                Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });
    }


    private void getInit() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mAdapter = new OrderAdapter(R.layout.item_order_external, new ArrayList<>());
        mAdapter = new OrderTwoAdapter(new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setEmptyView(R.layout.activity_null, (ViewGroup) mRecyclerView.getParent());

    }

    private void getStatus() {
        IProgressDialog progressDialog = new IProgressDialog().init(mContext).setDialogMsg(R.string.data_loading);
        Map<String, Object> param = new HashMap<>();
        param.put("pageNo", 1);
        param.put("pageSize", 10);
        RequestUtils.create(ApiService.class)
                .order(param)
                .compose(RxHelper.handleResult())
                .doOnSubscribe(RequestUtils::addDispos)
                .subscribe(new NetCallBack<OrderBean>(progressDialog) {
                    @Override
                    protected void onSuccess(OrderBean t) {
                        List<OrderBean.RowsBean> rows = t.getRows();
                        if (rows.size() != 0 && rows != null) {
                            for (OrderBean.RowsBean row : rows) {
                                List<OrderBean.RowsBean.GoodsListBean> goodsList = row.getGoodsList();
                                if (goodsList != null && goodsList.size() != 0) {
                                    if (goodsList.size() == 1) {
                                        row.setItemType(OrderBean.RowsBean.TYPE_ONE);
                                    } else if (goodsList.size() > 1) {
                                        row.setItemType(OrderBean.RowsBean.TYPE_TWO);
                                    }
                                }
                            }
                            mAdapter.setNewData(rows);
                        }
                    }

                    @Override
                    protected void updataLayout(int flag) {

                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        getStatus();

    }
}
