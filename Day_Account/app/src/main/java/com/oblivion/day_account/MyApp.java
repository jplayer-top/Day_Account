package com.oblivion.day_account;

import android.app.Application;
import android.content.Context;

import com.oblivion.day_account.dagger2.component.AccountFragmentComponent;
import com.oblivion.day_account.dagger2.component.DaggerAccountFragmentComponent;
import com.oblivion.day_account.dagger2.module.AccountFragmentModule;
import com.oblivion.day_account.ui.activity.MainActivity;

/**
 * author:Created by Oblivion on 2017/2/6.
 * 功能描述:
 */

public class MyApp extends Application {
    public static AccountFragmentComponent accountFragmentComponent;
    MainActivity mActivity;
    public static  Context mContext;

    public MainActivity getmActivity() {

        return mActivity;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mActivity = (MainActivity) getApplicationContext();
        accountFragmentComponent = DaggerAccountFragmentComponent.builder().accountFragmentModule(new AccountFragmentModule(mActivity)).build();
    }
}
