package com.example.retrofitdemo;

import android.app.Application;

import com.zhxu.library.RxRetrofitApp;

/**
 * Created by acer on 2018/10/24.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RxRetrofitApp.init(this,true);
    }
}
