package com.oblivion.day_account.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.oblivion.day_account.R;
import com.oblivion.day_account.ui.fragment.Base.BaseFragment;
import com.oblivion.day_account.ui.fragment.Base.FragmentFactory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.bottom_navigation_bar_container)
    BottomNavigationBar bottomNavigationBarContainer;
    @BindView(R.id.drawable)
    DrawerLayout drawable;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    private Context mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContent = this;
        initView();
        initListener();
        //  initFragment(1);
    }

    private void initFragment(int position) {
        BaseFragment fragment = FragmentFactory.createFragment(position);
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        for (int i = 1; i <= 5; i++) {
            Fragment fragmentByTag = getSupportFragmentManager().findFragmentByTag("" + i);
            if (position == i) {
                if (fragmentByTag == null) {
                    fragmentTransaction.add(R.id.framelayout, fragment, "" + position);
                } else {
                   // fragmentTransaction.add(R.id.framelayout, fragmentByTag, "" + position);
                }
            } else {
                if (fragmentByTag != null) {
                    fragmentTransaction.hide(fragmentByTag);
                }
            }
        }
        if (getSupportFragmentManager().findFragmentByTag("" + position) != null) {
            fragmentTransaction.show(getSupportFragmentManager().findFragmentByTag("" + position));
        } else {
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }


    private void initView() {
        bottomNavigationBarContainer
                .setActiveColor(R.color.colorGray)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .addItem(new BottomNavigationItem(R.drawable.arrow, ""))
                .addItem(new BottomNavigationItem(R.drawable.account, "流水"))
                .addItem(new BottomNavigationItem(R.drawable.wallet, "账户"))
                .addItem(new BottomNavigationItem(R.drawable.chart, "图表"))
                .addItem(new BottomNavigationItem(R.drawable.conduct, "理财"))
                .addItem(new BottomNavigationItem(R.drawable.more, "更多"))
                .setFirstSelectedPosition(1)
                .initialise();
    }

    private void initListener() {
        bottomNavigationBarContainer.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                if (position == 0) {
                    drawable.openDrawer(Gravity.LEFT);
                    return;
                }
                initFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        drawable.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                bottomNavigationBarContainer.hide();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                bottomNavigationBarContainer.show();
                if (bottomNavigationBarContainer.getCurrentSelectedPosition() == 0) {
                    bottomNavigationBarContainer.selectTab(1);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}