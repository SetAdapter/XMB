package com.hjy.xmb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fy.baselibrary.retrofit.NetCallBack;
import com.fy.baselibrary.retrofit.RequestUtils;
import com.fy.baselibrary.retrofit.RxHelper;
import com.fy.baselibrary.retrofit.dialog.IProgressDialog;
import com.fy.baselibrary.statusbar.MdStatusBar;
import com.hjy.xmb.BaseFragment;
import com.hjy.xmb.R;
import com.hjy.xmb.adapter.HomeAdapter;
import com.hjy.xmb.api.ApiService;
import com.hjy.xmb.bean.ListToAppBean;
import com.hjy.xmb.detail.DetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by QKun on 2018/5/7.
 */

public class HomeFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {
    private static final String FRAGMENTONE = "home";
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private HomeAdapter mAdapter;


    public static HomeFragment newInstance(String parme) {
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENTONE, parme);
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        login();
        MdStatusBar.setColorBar(getActivity(), R.color.colorPrimaryDark, R.color.colorPrimaryDark);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new HomeAdapter(R.layout.item_home, new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
        /**设置BannerHeadView*/
        View mHomeBannerHeadView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_home_banner_head, (ViewGroup) mRecyclerView.getParent(), false);
        AppCompatImageView mBanner = mHomeBannerHeadView.findViewById(R.id.banner);
        Glide.with(getActivity()).load(R.mipmap.banner).into(mBanner);

        mAdapter.addHeaderView(mHomeBannerHeadView);


        mAdapter.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        ListToAppBean.RowsBean rowsBean = mAdapter.getData().get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("homeBean", rowsBean);
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    private void login() {
        IProgressDialog progressDialog = new IProgressDialog().init(mContext)
                .setDialogMsg(R.string.loading_get);

        Map<String, Object> param = new HashMap<>();
        param.put("pageNo", 1);
        param.put("pageSize", 10);

        RequestUtils.create(ApiService.class)
                .getlistgoods(param)
                .compose(RxHelper.handleResult())
                .doOnSubscribe(RequestUtils::addDispos)
                .subscribe(new NetCallBack<ListToAppBean>(progressDialog) {
                    @Override
                    protected void onSuccess(ListToAppBean t) {
                        if (t != null && t.getRows() != null && t.getRows().size() != 0) {
                            mAdapter.setNewData(t.getRows());
                        }


                    }

                    @Override
                    protected void updataLayout(int flag) {

                    }
                });
    }

}
