package com.oblivion.day_account.persenter.fragment;

import android.app.Activity;

import com.oblivion.day_account.model.net.BaseVar;
import com.oblivion.day_account.model.net.bean.NewsBean;
import com.oblivion.day_account.MyApplication;
import com.oblivion.day_account.dagger2.module.RetrofitModule;
import com.oblivion.day_account.model.net.APIService;
import com.oblivion.day_account.ui.fragment.AccountFragment;
import com.oblivion.day_account.ui.fragment.AccountFragmentView;

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

    public AccountFragmentView accountFragment;

    public AccountFragmentPresenter(AccountFragment accountFragment) {
        this.mActivity = accountFragment.mActivity;
        this.accountFragment = accountFragment;
    }


    public void getRawData(String type, String newsKey, final int position) {
        ((MyApplication) mActivity.getApplication()).getAppComponent()
                .addSub(new RetrofitModule(BaseVar.JH_HOST)).inject(this);
        retrofit
                .create(APIService.class)
                .newsBeanCall(type, newsKey)
                .enqueue(new Callback<NewsBean>() {
                    @Override
                    public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                        accountFragment.showComplete(response.body(), position);
                    }

                    @Override
                    public void onFailure(Call<NewsBean> call, Throwable t) {
                        accountFragment.showErrow();
                        System.out.println(t.toString());
                    }
                });
    }
}
