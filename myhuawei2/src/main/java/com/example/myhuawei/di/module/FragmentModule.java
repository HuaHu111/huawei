package com.example.myhuawei.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.myhuawei.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by acer on 2018/10/17.
 */

@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment){
        mFragment=fragment;
    }

    @Provides
    @PerFragment
    public Fragment provideFragment(){
        return mFragment;
    }


    @Provides
    @PerFragment
    public Activity provideFragmentContext(){
        return mFragment.getActivity();
    }

//    @Provides
//    @PerFragment
//    @ContextLife("Activity")
//    public Context provideFramgentContext(){
//        return mFragment.getContext();
//    }
}
