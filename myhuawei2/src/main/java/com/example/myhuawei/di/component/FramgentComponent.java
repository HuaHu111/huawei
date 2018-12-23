package com.example.myhuawei.di.component;

import android.app.Activity;

import com.example.myhuawei.di.module.FragmentModule;
import com.example.myhuawei.di.scope.PerFragment;
import com.example.myhuawei.mvp.view.fragment.AppManagerFragment;
import com.example.myhuawei.mvp.view.fragment.CategoryFragment;
import com.example.myhuawei.mvp.view.fragment.MyFragment;
import com.example.myhuawei.mvp.view.fragment.RecommendFragment;
import com.example.myhuawei.mvp.view.fragment.RecommendFragment2;
import com.example.myhuawei.mvp.view.fragment.TopFragment;

import dagger.Component;

/**
 * Created by acer on 2018/10/17.
 */

@PerFragment
@Component(modules = FragmentModule.class,dependencies = AppComponent.class)
public interface FramgentComponent {

//    @ContextLife("Activity")
//    Context getActivityContext();
//
//    @ContextLife("Application")
//    Context getApplicationContext();
//
    Activity getActivity();

    void inject(RecommendFragment fragment);
    void inject(RecommendFragment2 fragment);
    void inject(CategoryFragment fragment);
    void inject(TopFragment fragment);
    void inject(MyFragment fragment);
    void inject(AppManagerFragment fragment);

}
