package com.oblivion.day_account.dagger2.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by Oblivion on 2017/2/9.
 * 功能描述:
 */
@Module
public class RetrofitModule {
    private String host;

    public RetrofitModule(String host) {
        this.host = host;
    }

    @Provides
    public Retrofit providerRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .client(new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
