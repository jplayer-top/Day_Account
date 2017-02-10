package com.oblivion.day_account;

import android.app.Application;
import android.content.Context;

import com.oblivion.day_account.dagger2.component.AppComponent;
import com.oblivion.day_account.dagger2.component.DaggerAppComponent;


/**
 * author:Created by Oblivion on 2017/2/9.
 * 功能描述:
 */

public class MyApplication extends Application {
    public static Context appContext;
    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        appComponent = DaggerAppComponent.create();
    }
}
