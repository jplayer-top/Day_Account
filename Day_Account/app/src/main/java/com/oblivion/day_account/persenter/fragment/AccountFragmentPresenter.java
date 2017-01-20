package com.oblivion.day_account.persenter.fragment;

import android.app.Activity;

import com.oblivion.day_account.model.net.APIService;
import com.oblivion.day_account.model.net.BaseVar;
import com.oblivion.day_account.model.net.bean.AccountbannerBean;
import com.oblivion.day_account.utils.ToastUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */
public class AccountFragmentPresenter {
    public Activity mActivity;

    public AccountFragmentPresenter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void getRawData() {
        new Retrofit.Builder()
                .baseUrl(BaseVar.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService.class)
                .accountBannerBeanCall()
                .enqueue(new Callback<AccountbannerBean>() {
                    @Override
                    public void onResponse(Call<AccountbannerBean> call, Response<AccountbannerBean> response) {
                        ToastUtils.makeText(mActivity, response.body().result.size() + "Obl");
                    }

                    @Override
                    public void onFailure(Call<AccountbannerBean> call, Throwable t) {

                    }
                });
    }
}
