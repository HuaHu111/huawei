package com.example.mydragger2.di.component;

import com.example.mydragger2.di.Main2Activity;
import com.example.mydragger2.di.MainActivity;
import com.example.mydragger2.di.Module.AppleModule;
import com.example.mydragger2.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by acer on 2018/10/16.
 */

@PerActivity
@Component(modules = AppleModule.class)
public interface AppleCOmpent {
    void inject(MainActivity activity);
    void inject(Main2Activity activity2);
}
