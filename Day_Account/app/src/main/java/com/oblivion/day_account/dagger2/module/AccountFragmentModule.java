package com.oblivion.day_account.dagger2.module;

import android.app.Activity;

import com.oblivion.day_account.persenter.fragment.AccountFragmentPresenter;
import com.oblivion.day_account.ui.fragment.AccountFragment;

import dagger.Module;
import dagger.Provides;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */
@Module
public class AccountFragmentModule {
    public Activity mActivity;
    public AccountFragment accountFragment;

    public AccountFragmentModule() {
    }

    public AccountFragmentModule(AccountFragment accountFragment) {
        this.accountFragment = accountFragment;
        this.mActivity = accountFragment.getActivity();
    }

    @Provides
    public AccountFragmentPresenter provideAccountFragmentPresenter() {
        return new AccountFragmentPresenter(accountFragment);
    }
}
