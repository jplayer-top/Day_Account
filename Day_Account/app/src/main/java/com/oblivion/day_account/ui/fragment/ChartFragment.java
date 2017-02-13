package com.oblivion.day_account.ui.fragment;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;

import com.oblivion.day_account.ui.fragment.Base.BaseFragment;

/**
 * author:Created by Oblivion on 2017/1/19.
 * 功能描述:
 */

public class ChartFragment extends BaseFragment {
    private Handler handler = new Handler();

    @Override
    public void initView() {
    }

    @Override
    public View createView(ViewGroup container) {
        stateView.showEmpty();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!isHidden()) {
                            stateView.showRetry();
                        }
                    }
                });
            }
        }).start();
        return super.createView(container);
    }


}
