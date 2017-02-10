package com.oblivion.day_account.dagger2.component;

import com.oblivion.day_account.dagger2.module.AccountFragmentModule;
import com.oblivion.day_account.ui.fragment.AccountFragment;

import dagger.Subcomponent;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */
@Subcomponent(modules = AccountFragmentModule.class)
public interface AccountFragmentComponent {
    void inject(AccountFragment fragment);
}
