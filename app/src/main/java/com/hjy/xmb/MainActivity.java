package com.hjy.xmb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.fy.baselibrary.startactivity.StartActivity;
import com.fy.baselibrary.utils.JumpUtils;
import com.fy.baselibrary.utils.T;
import com.hjy.xmb.fragment.HomeFragment;
import com.hjy.xmb.fragment.OrderFragment;
import com.hjy.xmb.fragment.ShoppingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.layout_fragment)
    FrameLayout mLayoutFragment;
    @BindView(R.id.navigation)
    BottomNavigationBar mNavigation;
    @BindView(R.id.tv_base_title)
    TextView mTvTitle;

    private List<Fragment> mFragments = new ArrayList<>();
    private boolean mOrder;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mTvTitle.setText(R.string.mainTabOne);
        initBottomNavigation();
        initFragment();


        Bundle extras = getIntent().getExtras();
        mOrder = extras.getBoolean("order");
        if (mOrder) {
            setThreeFragment();
            mNavigation.setFirstSelectedPosition(2).initialise();
            mTvTitle.setText(R.string.mainTabThree);
        } else {
            setDefaultFragment();
        }

    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layout_fragment, mFragments.get(0));
        transaction.commit();

    }

    private void initFragment() {
        mFragments.add(HomeFragment.newInstance(""));
        mFragments.add(ShoppingFragment.newInstance(""));
        mFragments.add(OrderFragment.newInstance(""));

    }

    private void initBottomNavigation() {
        mNavigation.setMode(BottomNavigationBar.MODE_FIXED);
        mNavigation.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mNavigation
                .addItem(new BottomNavigationItem(R.drawable.ic_vector_home, getResources().getString(R.string.mainTabOne)))
                .addItem(new BottomNavigationItem(R.drawable.ic_vector_shopping_trolley, getResources().getString(R.string.mainTabTwo)))
                .addItem(new BottomNavigationItem(R.drawable.ic_vector_order_form_, getResources().getString(R.string.mainTabThree)))
                .setFirstSelectedPosition(0)
                .initialise();
        mNavigation.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        if (mFragments != null) {
            if (position < mFragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment currentFragment = fm.findFragmentById(R.id.layout_fragment);
                Fragment nextFragment = mFragments.get(position);
                if (nextFragment.isAdded()) {
                    ft.hide(currentFragment).show(nextFragment);
                } else {
                    ft.hide(currentFragment).add(R.id.layout_fragment, nextFragment);
                    if (nextFragment.isHidden()) {
                        ft.show(nextFragment);
                    }
                }
                ft.commitAllowingStateLoss();

                switch (position) {
                    case 0:
                        mTvTitle.setText(R.string.mainTabOne);
                        break;
                    case 1:
                        mTvTitle.setText(R.string.mainTabTwo);
                        break;
                    case 2:
                        mTvTitle.setText(R.string.mainTabThree);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
        if (mFragments != null) {
            if (position < mFragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment nextFragment = mFragments.get(position);
                ft.hide(nextFragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    private void setThreeFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layout_fragment, mFragments.get(2));
        transaction.commit();

    }

//    @Override
//    public void onBackPressed() {
////        如果DrawerLayout是打开状态则关闭
//        // super.onBackPressed(); 	不要调用父类的方法
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.addCategory(Intent.CATEGORY_HOME);
//        startActivity(intent);
//    }

    //保存点击的时间
    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            //处理 退出界面
            if ((System.currentTimeMillis() - exitTime) > 2000) {

                T.showLong(com.fy.baselibrary.R.string.exit_app);
                exitTime = System.currentTimeMillis();
            } else {
                JumpUtils.exitApp(mContext, StartActivity.class);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
