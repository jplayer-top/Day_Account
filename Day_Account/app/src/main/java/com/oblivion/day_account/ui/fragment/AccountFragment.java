package com.oblivion.day_account.ui.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.oblivion.day_account.MyApp;
import com.oblivion.day_account.R;
import com.oblivion.day_account.persenter.fragment.AccountFragmentPresenter;
import com.oblivion.day_account.ui.fragment.Base.BaseFragment;
import com.oblivion.day_account.ui.fragment.adapter.AccountPagerAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author:Created by Oblivion on 2017/1/19.
 * 功能描述:
 */

public class AccountFragment extends BaseFragment {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private PagerAdapter adapter;

    @Inject AccountFragmentPresenter presenter;

    @Override
    public View createView() {
        View view = View.inflate(mActivity, R.layout.account_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        // presenter = new AccountFragmentPresenter(mActivity);
        MyApp.accountFragmentComponent.inject(mActivity);
        presenter.getRawData();
        adapter = new AccountPagerAdapter();
        viewpager.setAdapter(adapter);
    }
}
