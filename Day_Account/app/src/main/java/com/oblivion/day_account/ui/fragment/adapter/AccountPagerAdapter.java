package com.oblivion.day_account.ui.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.oblivion.day_account.model.net.BaseVar;
import com.oblivion.day_account.ui.fragment.NewsFragment;
import com.oblivion.day_account.ui.fragment.NewsFragmentFactory;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */

public class AccountPagerAdapter extends FragmentPagerAdapter {

    private NewsFragment newsFragment;
    FragmentManager fm;

    public AccountPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        newsFragment = NewsFragmentFactory.getFragment(position);
        return newsFragment;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return BaseVar.arr[position];
    }

}
