package com.example.myhuawei.di.component;

import com.example.myhuawei.di.module.ActivityModule;
import com.example.myhuawei.di.scope.PerActivity;
import com.example.myhuawei.mvp.view.activity.AppDetailActivity;
import com.example.myhuawei.mvp.view.activity.AppMoreRecommendActivity;
import com.example.myhuawei.mvp.view.activity.CategoryNecessaryActivity;
import com.example.myhuawei.mvp.view.activity.CategoryNewActivity;
import com.example.myhuawei.mvp.view.activity.CategorySubjectActivity;
import com.example.myhuawei.mvp.view.activity.CategorySubscribeActivity;
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
    void inject(AppDetailActivity appDetailActivity);
    void inject(AppMoreRecommendActivity appMoreRecommendActivity);
    void inject(CategoryNecessaryActivity categoryNecessaryActivity);
    void inject(CategoryNewActivity categoryNecessaryActivity);
    void inject(CategorySubjectActivity categoryNecessaryActivity);
    void inject(CategorySubscribeActivity categoryNecessaryActivity);



}
