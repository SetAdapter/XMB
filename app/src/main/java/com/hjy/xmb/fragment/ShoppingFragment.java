package com.hjy.xmb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.fy.baselibrary.retrofit.NetCallBack;
import com.fy.baselibrary.retrofit.RequestUtils;
import com.fy.baselibrary.retrofit.RxHelper;
import com.fy.baselibrary.retrofit.dialog.IProgressDialog;
import com.fy.baselibrary.utils.BigDecimalUtil;
import com.fy.baselibrary.utils.L;
import com.fy.baselibrary.utils.T;
import com.hjy.xmb.BaseFragment;
import com.hjy.xmb.R;
import com.hjy.xmb.adapter.ShoppingAdapter;
import com.hjy.xmb.api.ApiService;
import com.hjy.xmb.bean.ConfirmOrderBean;
import com.hjy.xmb.bean.ListToAppBean;
import com.hjy.xmb.obligation.ObligationActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by QKun on 2018/5/7.
 */

public class ShoppingFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.tv_edit)
    TextView tv_edit;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.ll_money)
    LinearLayout ll_money;
    @BindView(R.id.tv_settlement)
    TextView tv_settlement;
    @BindView(R.id.cb_all)
    CheckBox cb_all;
    @BindView(R.id.tv_all)
    TextView tv_all;
    @BindView(R.id.tv_allPrice)
    TextView tv_allPrice;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;


    ShoppingAdapter adapter;
    private static final String FRAGMENTTWO = "TWO";
    private double s = 0;
    //private List<HomeBean> goodsList;
    //private GoodsArray goodsArray;
    private ListToAppBean listbean;
    private List<ListToAppBean.RowsBean> beanList;
    //private HomeBean bean;
    private ListToAppBean.RowsBean bean;
    private double price;
    private int count;
    private double v;
    private String cartId;

    public static ShoppingFragment newInstance(String parme) {
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENTTWO, parme);
        ShoppingFragment shoppingFragment = new ShoppingFragment();
        shoppingFragment.setArguments(bundle);
        return shoppingFragment;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_shpping;
    }

    @Override
    protected void initView() {
        super.initView();
        refreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        refreshLayout.setRefreshFooter(new ClassicsFooter(getActivity()));
//        tv_edit.setVisibility(View.GONE);
//        cb_all.setVisibility(View.INVISIBLE);
//        tv_all.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initData() {

        rv_list.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new ShoppingAdapter(new ArrayList<>());
        rv_list.setAdapter(adapter);
        adapter.setEmptyView(R.layout.activity_null, (ViewGroup) rv_list.getParent());
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(rv_list);
        adapter.enableSwipeItem();
//        adapter.setOnItemSwipeListener(new OnItemSwipeListener() {
//            @Override
//            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
//
//            }
//
//            @Override
//            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
//            }
//
//            @Override
//            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
//                bean = adapter.getData().get(pos);
//
//                price = bean.getGoodsSalePrice();
//                count = bean.getGoodBuyAmount();
//                //单价
//                v = price / count;
//                //价格
//                double v2 = v * (count - 1);
//                bean.setGoodsSalePrice(v2);
//                //个数
//                bean.setGoodBuyAmount(count - 1);
//                adapter.notifyDataSetChanged();
//                double data1 = setData();
//                tv_allPrice.setText(data1 + "");
//                adapter.remove(pos);
//
//
//                //GoodsArray goodsArray = (GoodsArray) mCache.getAsObject("GoodsArray");
//               // List<HomeBean> homeBeanList;
//                getListToApp();
//               // List<ListToAppBean.RowsBean> RowsBeanList;
//                if (null == listbean) {
//                    listbean = new ListToAppBean();
//                    beanList = new ArrayList<>();
//                } else {
//                    beanList = listbean.getRows();
//                    if (null == beanList) beanList = new ArrayList<>();
//                }
//
//                beanList.remove(pos);
//               // mCache.put("GoodsArray", listbean);
//            }
//
//            @Override
//            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
//
//            }
//        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter madapter, View view, int position) {
                bean = adapter.getData().get(position);
                price = bean.getGoodsSalePrice();
                count = bean.getGoodBuyAmount();
                cartId = String.valueOf(bean.getCartId());
                //单价
                v = price / count;
                switch (view.getId()) {
                    case R.id.cb_item:
                        boolean flag = bean.isFlag();
                        if (flag) {
                            bean.setFlag(false);
                        } else {
                            bean.setFlag(true);
                        }
                        tv_allPrice.setText(setData() + "");
                        adapter.notifyItemChanged(position);

                        break;
                    case R.id.tv_plus:
                        setUpdate(cartId,++count);
                        bean.setGoodBuyAmount(count);
                        adapter.notifyDataSetChanged();
                        tv_allPrice.setText(setData() + "");
                        break;
                    case R.id.tv_reduce:
                        //价格
                        if (count > 1) {
                            setUpdate(cartId,--count);
                            bean.setGoodBuyAmount(count);
                            adapter.notifyDataSetChanged();
                            tv_allPrice.setText(setData() + "");
                        } else return;

                        break;
                }
            }
        });
    }

    //修改数量（加减号）
    private void setUpdate(String cartId,Integer count) {
        IProgressDialog progressDialog = new IProgressDialog().init(mContext)
                .setDialogMsg(R.string.data_loading);

        RequestUtils.create(ApiService.class)
                .update(cartId,count)
                .compose(RxHelper.handleResult())
                .doOnSubscribe(RequestUtils::addDispos)
                .subscribe(new NetCallBack<Object>(progressDialog) {
                    @Override
                    protected void onSuccess(Object ListToAppBean) {
                    }

                    @Override
                    protected void updataLayout(int flag) {
                        L.e("net updataLayout", flag + "-----");
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        getListToApp();
        cb_all.setChecked(false);
        if (cb_all.isChecked()) {
            List<ListToAppBean.RowsBean> data = adapter.getData();
            for (ListToAppBean.RowsBean datum : data) {
                datum.setFlag(true);
                adapter.notifyDataSetChanged();
            }
        } else {
            List<ListToAppBean.RowsBean> data = adapter.getData();
            for (ListToAppBean.RowsBean datum : data) {
                datum.setFlag(false);
                adapter.notifyDataSetChanged();
            }
        }

        // goodsArray = (GoodsArray) mCache.getAsObject("GoodsArray");
        if (null != listbean) {

        }
    }

    private void getListToApp() {
        IProgressDialog progressDialog = new IProgressDialog().init(mContext)
                .setDialogMsg(R.string.data_loading);

        Map<String, Object> param = new HashMap<>();
        param.put("pageNo", 1);
        param.put("pageSize", 10);

        RequestUtils.create(ApiService.class)
                .getListToApp(param)
                .compose(RxHelper.handleResult())
                .doOnSubscribe(RequestUtils::addDispos)
                .subscribe(new NetCallBack<ListToAppBean>(progressDialog) {
                    @Override
                    protected void onSuccess(ListToAppBean ListToAppBean) {
                        if (ListToAppBean != null) {
                            adapter.setNewData(ListToAppBean.getRows());
                            beanList = ListToAppBean.getRows();
                            adapter.setNewData(beanList);
                            tv_allPrice.setText(setData() + "");
                        }
                    }

                    @Override
                    protected void updataLayout(int flag) {
                        L.e("net updataLayout", flag + "-----");
                    }
                });
    }

    private String setData() {
        double allPrice = 0.0;
        for (int i = 0; i < adapter.getData().size(); i++) {
            if (adapter.getData().get(i).isFlag()) {
                if (beanList != null) {
                    allPrice += (beanList.get(i).getGoodsSalePrice()) * beanList.get(i).getGoodBuyAmount();
                }
            }
        }
//        DecimalFormat decimalFormat = new DecimalFormat("######0.00");
//        double aDouble = Double.parseDouble(decimalFormat.format(allPrice));

        return BigDecimalUtil.fromat4S5R(allPrice, 2);
    }

    boolean flag = true;
    List<String> selectData = new ArrayList<>();

    @OnClick({R.id.tv_edit, R.id.tv_settlement, R.id.cb_all})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_edit:
                if (flag) {
                    tv_edit.setText("完成");
                    ll_money.setVisibility(View.INVISIBLE);
                    tv_settlement.setText("删除");
                    flag = false;
                } else {
                    tv_edit.setText("编辑");
                    ll_money.setVisibility(View.VISIBLE);
                    tv_settlement.setText("结 算");
                    flag = true;
                }
                break;
            case R.id.tv_settlement:
                selectData.clear();

                if (tv_settlement.getText().toString().equals("删除")) {

                    List<Integer> paramList = new ArrayList<>();
                    List<ListToAppBean.RowsBean> data = adapter.getData();
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).isFlag()) {
                            paramList.add(data.get(i).getCartId());
                        }
                    }
                    IProgressDialog progressDialog = new IProgressDialog().init(mContext)
                            .setDialogMsg(R.string.data_loading);

                    RequestUtils.create(ApiService.class)
                            .remove(paramList)
                            .compose(RxHelper.handleResult())
                            .doOnSubscribe(RequestUtils::addDispos)
                            .subscribe(new NetCallBack<Object>(progressDialog) {
                                @Override
                                protected void onSuccess(Object ListToAppBean) {
                                    if (ListToAppBean != null) {
                                    }
                                }

                                @Override
                                protected void updataLayout(int flag) {
                                    L.e("net updataLayout", flag + "-----");
                                }
                            });


                    List<ListToAppBean.RowsBean> list = new ArrayList<>();
                    //List<ListToAppBean.RowsBean> data = adapter.getData();
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).isFlag()) {
                            list.add(data.get(i));
                        }
                    }
                    for (ListToAppBean.RowsBean homeBean : list) {
                        if (data.contains(homeBean)) {
                            data.remove(homeBean);
                        }
                    }
                    adapter.setNewData(data);
                    // mCache.put("GoodsArray", listbean);
                    adapter.notifyDataSetChanged();

                } else {
                    List<ListToAppBean.RowsBean> list = new ArrayList<>();
                    List<ListToAppBean.RowsBean> data = adapter.getData();
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).isFlag()) {
                            list.add(data.get(i));
                        }
                    }
                    if (list.size() == 0) {
                        T.showShort("请先选择商品");
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            selectData.add(list.get(i).getGoodsNo());
                        }
                        confirm(selectData);
                    }
//                    List<ListToAppBean.RowsBean> list = new ArrayList<>();
//                    List<ListToAppBean.RowsBean> data = adapter.getData();
//                    for (int i = 0; i < data.size(); i++) {
//                        if (data.get(i).isFlag()) {
//                            list.add(data.get(i));
//                        }
//                    }
//                    //GoodsArray goodsData = new GoodsArray();
//                    ListToAppBean listBean = new ListToAppBean();
//                    listBean.setRows(list);
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("goodsArray", listBean);
//                    Intent intent = new Intent(getActivity(), ObligationActivity.class);
//                    intent.putExtras(bundle);
//                    startActivity(intent);

                }
                break;
            case R.id.cb_all:
                if (cb_all.isChecked()) {
                    List<ListToAppBean.RowsBean> data = adapter.getData();
                    for (ListToAppBean.RowsBean datum : data) {
                        datum.setFlag(true);
                        adapter.notifyDataSetChanged();
                    }
                    tv_allPrice.setText(setData() + "");
                } else {
                    List<ListToAppBean.RowsBean> data = adapter.getData();
                    for (ListToAppBean.RowsBean datum : data) {
                        datum.setFlag(false);
                        adapter.notifyDataSetChanged();
                    }
                    tv_allPrice.setText(setData() + "");
                }
                break;

        }
    }

    private void confirm(List<String> strings) {
        IProgressDialog progressDialog = new IProgressDialog().init(mContext)
                .setDialogMsg(R.string.data_loading);

        RequestUtils.create(ApiService.class)
                .confirm(strings)
                .compose(RxHelper.handleResult())
                .doOnSubscribe(RequestUtils::addDispos)
                .subscribe(new NetCallBack<ConfirmOrderBean>(progressDialog) {
                    @Override
                    protected void onSuccess(ConfirmOrderBean confirmOrderBean) {
                        if (confirmOrderBean != null) {
                            Intent intent = new Intent(getActivity(), ObligationActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("confirmOrderBean", confirmOrderBean);
                            bundle.putInt("type", 0);
                            intent.putExtras(bundle);
                            startActivity(intent);

                        }

                    }

                    @Override
                    protected void updataLayout(int flag) {
                    }
                });
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        refreshLayout.finishLoadMore(1000);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        if (adapter != null) {
            refreshLayout.finishRefresh(1000);
            adapter.notifyDataSetChanged();
        }
    }

}
