package com.oblivion.day_account.dagger2.module;

import android.app.Activity;

import com.oblivion.day_account.persenter.fragment.AccountFragmentPresenter;
import com.oblivion.day_account.ui.activity.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */
@Module
public class AccountFragmentModule {
    public Activity mActivity;

    public AccountFragmentModule() {
    }

    public AccountFragmentModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    public  AccountFragmentPresenter provideAccountFragmentPresenter() {
        return new AccountFragmentPresenter((MainActivity) mActivity);
    }
}
