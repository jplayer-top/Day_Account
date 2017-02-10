package com.oblivion.day_account.dagger2.module;

import com.oblivion.day_account.model.net.BaseVar;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by Oblivion on 2017/2/9.
 * 功能描述:
 */
@Module
public class RetrofitModule {
    @Provides
    public Retrofit providerRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseVar.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
