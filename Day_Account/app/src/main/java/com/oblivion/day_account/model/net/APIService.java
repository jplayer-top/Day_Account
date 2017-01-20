package com.oblivion.day_account.model.net;

import com.oblivion.day_account.model.net.bean.AccountbannerBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */

public interface APIService {
    //accountBannerBean
    @GET("account_banner.json")
    Call<AccountbannerBean> accountBannerBeanCall();
}
