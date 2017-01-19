package com.oblivion.day_account.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.oblivion.day_account.R;
import com.oblivion.day_account.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation_bar_container)
    BottomNavigationBar bottomNavigationBarContainer;
    @BindView(R.id.drawable)
    DrawerLayout drawable;
    private Context mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        mContent = this;
        initListener();
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
                }
                ToastUtils.makeText(mContent, "position" + position);
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
                bottomNavigationBarContainer.selectTab(1);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}
