package com.oblivion.day_account.model.net;

import com.oblivion.day_account.model.net.bean.NewsBean;
import com.oblivion.day_account.model.net.bean.AccountbannerBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */

public interface APIService {
    //accountBannerBean
    @GET("account_banner.json")
    Call<AccountbannerBean> accountBannerBeanCall();

    @GET("index")
    Call<NewsBean> newsBeanCall(@Query("type") String type, @Query("key") String key);
}
