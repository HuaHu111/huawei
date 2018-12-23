package com.example.myhuawei.base;

import android.os.Handler;

import com.example.myhuawei.BuildConfig;
import com.example.myhuawei.di.component.AppComponent;
import com.example.myhuawei.di.component.DaggerAppComponent;
import com.example.myhuawei.di.module.AppModule;
import com.example.recyclelib.App;
import com.zhxu.library.RxRetrofitApp;

/**
 * Created by acer on 2018/10/17.
 */

public class StoreApplication extends App {
    private static int mMainThreadId;
    private static Handler mhandler;
    public AppComponent appCompoment;


    @Override
    public void onCreate() {
        super.onCreate();
        mhandler = new Handler();
        iniApplicationComponent();
        RxRetrofitApp.init(this, BuildConfig.DEBUG);
    }


    private void iniApplicationComponent(){
        appCompoment= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }


    public AppComponent getAppCompoment(){
        return appCompoment;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Handler getHandler() {
        return mhandler;
    }
}
