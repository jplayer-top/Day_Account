package com.oblivion.day_account.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.oblivion.day_account.R;
import com.oblivion.day_account.model.net.bean.NewsBean;
import com.oblivion.day_account.ui.fragment.Base.BaseFragment;
import com.oblivion.day_account.ui.fragment.adapter.NewsFragmentAdpater;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author:Created by Oblivion on 2017/2/10.
 * 功能描述:
 */

public class NewsFragment extends BaseFragment {

    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    private NewsFragmentAdpater adapter;

    @Override
    public void initView() {
        recycleview.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new NewsFragmentAdpater(mActivity);
        recycleview.setAdapter(adapter);
    }

    @Override
    public View createView(ViewGroup container) {
        container.removeAllViews();
        View view = View.inflate(mActivity, R.layout.newsfragment, null);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataComplete(NewsBean bean) {
        if (bean != null) {
            adapter.addData(bean);
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }
}
