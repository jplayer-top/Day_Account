package com.oblivion.day_account.dagger2.component;

import android.app.Activity;

import com.oblivion.day_account.dagger2.module.AccountFragmentModule;

import dagger.Component;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */
@Component(modules = {AccountFragmentModule.class})
public interface AccountFragmentComponent {
    void inject(Activity mActivity);
}
