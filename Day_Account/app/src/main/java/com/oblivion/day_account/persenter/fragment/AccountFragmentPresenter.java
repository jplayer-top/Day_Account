package com.oblivion.day_account.persenter.fragment;

import android.app.Activity;

import com.oblivion.day_account.MyApplication;
import com.oblivion.day_account.dagger2.module.RetrofitModule;
import com.oblivion.day_account.model.net.APIService;
import com.oblivion.day_account.model.net.bean.AccountbannerBean;
import com.oblivion.day_account.ui.fragment.AccountFragment;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */
public class AccountFragmentPresenter {
    public Activity mActivity;
    @Inject
    public Retrofit retrofit;

    public AccountFragment accountFragment;

    public AccountFragmentPresenter(AccountFragment accountFragment) {
        this.mActivity = accountFragment.mActivity;
        this.accountFragment = accountFragment;
    }


    public void getRawData() {
        ((MyApplication) mActivity.getApplication()).getAppComponent()
                .addSub(new RetrofitModule()).inject(this);
        retrofit
                .create(APIService.class)
                .accountBannerBeanCall()
                .enqueue(new Callback<AccountbannerBean>() {
                    @Override
                    public void onResponse(Call<AccountbannerBean> call, Response<AccountbannerBean> response) {
                        accountFragment.showComplete(response.body());
                    }

                    @Override
                    public void onFailure(Call<AccountbannerBean> call, Throwable t) {
                        accountFragment.showErrow();
                    }
                });
    }
}
