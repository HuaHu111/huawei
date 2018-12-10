package com.example.myhuawei.di.module;

import android.app.Activity;

import com.example.myhuawei.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by acer on 2018/10/17.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity=activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity(){
        return mActivity;
    }


//    @Provides
//    @PerActivity
//    @ContextLife("Activity")
//    public Context provideActivityContext(){
//        return mActivity;
//    }

}
