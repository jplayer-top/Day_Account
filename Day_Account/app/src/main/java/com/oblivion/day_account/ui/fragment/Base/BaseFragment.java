package com.oblivion.day_account.ui.fragment.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.nukc.stateview.StateView;
import com.oblivion.day_account.ui.activity.MainActivity;

/**
 * author:Created by Oblivion on 2017/1/19.
 * 功能描述:
 */

public abstract class BaseFragment extends Fragment {
    public MainActivity mActivity;
    public StateView stateView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        stateView = StateView.inject(container, false);
        return createView(container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            stateView.setVisibility(View.INVISIBLE);
        } else {
            stateView.setVisibility(View.VISIBLE);
        }
    }

    public abstract void initView();

    public View createView(ViewGroup container) {
        TextView tv = new TextView(getContext());
        tv.setText(this.getClass().getSimpleName());
        tv.setGravity(Gravity.CENTER);
        return tv;
    }

    public View createView(int res) {
        return View.inflate(mActivity, res, null);
    }


}
