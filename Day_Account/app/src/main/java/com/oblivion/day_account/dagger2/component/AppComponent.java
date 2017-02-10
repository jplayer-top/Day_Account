package com.oblivion.day_account.dagger2.component;

import com.oblivion.day_account.dagger2.module.AccountFragmentModule;
import com.oblivion.day_account.dagger2.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * author:Created by Oblivion on 2017/2/9.
 * 功能描述:
 */
@Singleton
@Component
public interface AppComponent {

    AccountFragmentComponent addSub(AccountFragmentModule accountFragmentModule);

    RetrofitComponent addSub(RetrofitModule retrofitModule);
}
