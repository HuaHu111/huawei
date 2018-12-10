package com.example.myhuawei.di.module;

import com.example.myhuawei.base.StoreApplication;

import dagger.Module;

/**
 * Created by acer on 2018/10/17.
 */


@Module
public class AppModule {

    private StoreApplication storeApplication;

    public AppModule(StoreApplication application){
        storeApplication=application;
    }

//    @Provides
//    @PerApp
//    @ContextLife("Application")
//    public Context provideAppContext(){
//        return storeApplication;
//    }
}
