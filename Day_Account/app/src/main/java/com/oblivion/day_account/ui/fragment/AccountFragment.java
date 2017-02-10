package com.oblivion.day_account.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.HorizontalScrollView;

import com.oblivion.day_account.MyApplication;
import com.oblivion.day_account.R;
import com.oblivion.day_account.dagger2.module.AccountFragmentModule;
import com.oblivion.day_account.model.net.bean.AccountbannerBean;
import com.oblivion.day_account.persenter.fragment.AccountFragmentPresenter;
import com.oblivion.day_account.ui.fragment.Base.BaseFragment;
import com.oblivion.day_account.ui.fragment.adapter.AccountPagerAdapter;
import com.oblivion.day_account.utils.ToastUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.FOCUS_LEFT;
import static android.view.View.FOCUS_RIGHT;

/**
 * author:Created by Oblivion on 2017/1/19.
 * 功能描述:
 */

public class AccountFragment extends BaseFragment implements AccountFragmentView {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.horScroll)
    HorizontalScrollView horScroll;
    private PagerAdapter adapter;

    @Inject
    AccountFragmentPresenter presenter;

    @Override
    public View createView() {
        View view = View.inflate(mActivity, R.layout.account_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        ((MyApplication) mActivity.getApplication()).getAppComponent()
                .addSub(new AccountFragmentModule(this)).inject(this);
        presenter.getRawData();
        adapter = new AccountPagerAdapter();
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        initListener();
    }

    private void initListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() > 4) {
                    horScroll.pageScroll(FOCUS_RIGHT);
                } else {
                    horScroll.pageScroll(FOCUS_LEFT);

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showErrow() {
        ToastUtils.makeText(mActivity, "请求出错");
    }

    @Override
    public void showLoadding() {

    }

    @Override
    public void showComplete(AccountbannerBean bean) {
        ToastUtils.makeText(mActivity, bean.result.size() + "条信息");
    }
}
