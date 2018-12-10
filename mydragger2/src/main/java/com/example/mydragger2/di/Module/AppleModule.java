package com.example.mydragger2.di.Module;

import com.example.mydragger2.di.Apple;
import com.example.mydragger2.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by acer on 2018/10/16.
 */

@Module
public class AppleModule {

    @Provides
    @PerActivity
    public Apple provideApple(){
        return new Apple();
    }
}
