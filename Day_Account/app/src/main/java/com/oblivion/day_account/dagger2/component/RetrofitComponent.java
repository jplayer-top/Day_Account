package com.oblivion.day_account.dagger2.component;

import com.oblivion.day_account.dagger2.module.RetrofitModule;
import com.oblivion.day_account.persenter.fragment.AccountFragmentPresenter;

import dagger.Subcomponent;

/**
 * author:Created by Oblivion on 2017/2/9.
 * 功能描述:
 */

@Subcomponent(modules = RetrofitModule.class)
public interface RetrofitComponent {
    void inject(AccountFragmentPresenter accountFragmentPresenter);
}
