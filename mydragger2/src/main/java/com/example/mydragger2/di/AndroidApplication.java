package com.example.mydragger2.di;

import android.app.Application;

import com.example.mydragger2.di.Module.AppleModule;
import com.example.mydragger2.di.component.AppleCOmpent;
import com.example.mydragger2.di.component.DaggerAppleCOmpent;

/**
 * Created by acer on 2018/10/16.
 */

public class AndroidApplication extends Application {


    private AppleCOmpent appleCOmpent;

    @Override
    public void onCreate() {
        super.onCreate();
        appleCOmpent = DaggerAppleCOmpent.builder().appleModule(new AppleModule()).build();
    }


    public AppleCOmpent getAppleCOmpent(){
        return appleCOmpent;
    }
}
