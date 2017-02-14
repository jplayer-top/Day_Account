package com.oblivion.day_account.ui.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.oblivion.day_account.model.net.bean.NewsBean;
import com.oblivion.day_account.ui.activity.MainActivity;
import com.oblivion.day_account.ui.fragment.viewholder.NewsFragmentViewHolder;

/**
 * author:Created by Oblivion on 2017/2/13.

 * 功能描述:Obl-test-asdadd

 */
public class NewsFragmentAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    NewsBean bean;
    MainActivity mActivity;

    public NewsFragmentAdpater(MainActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void addData(NewsBean bean) {
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (bean != null) {
            return NewsFragmentViewHolder.getHolder(mActivity);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (bean != null) {
            ((NewsFragmentViewHolder) holder).bindData(bean.result.data.get(position), mActivity);
        } else {

        }
        Toast.makeText(mActivity, "" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        if (bean != null) {
            return bean.result.data.size();

        } else {
            return 0;
        }
    }
}
