package com.example.myhuawei.di.component;

import com.example.myhuawei.di.module.ActivityModule;
import com.example.myhuawei.di.scope.PerActivity;
import com.example.myhuawei.mvp.view.activity.HomeActivity;

import dagger.Component;

/**
 * Created by acer on 2018/10/17.
 */

@PerActivity
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {

//    @ContextLife("Activity")
//    Context getActivityContext();

//    @ContextLife("Application")
//    Context getApplicationContext();

    void inject(HomeActivity activity);

}
