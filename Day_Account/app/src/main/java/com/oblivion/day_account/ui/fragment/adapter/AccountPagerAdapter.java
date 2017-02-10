package com.oblivion.day_account.ui.fragment.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oblivion.day_account.MyApplication;
import com.oblivion.day_account.R;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */

public class AccountPagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(MyApplication.appContext, R.layout.topfragment, null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("ss" + position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String[] arr = {"头条", "社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经", "时尚"};
        return arr[position];
    }
}
