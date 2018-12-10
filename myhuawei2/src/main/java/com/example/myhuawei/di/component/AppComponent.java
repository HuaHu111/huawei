package com.example.myhuawei.di.component;

import com.example.myhuawei.di.module.AppModule;
import com.example.myhuawei.di.scope.PerApp;

import dagger.Component;

/**
 * Created by acer on 2018/10/17.
 */

@PerApp
@Component(modules = AppModule.class)
public interface AppComponent {

//    @ContextLife("Application")
//    Context getApplicationtext();
}
