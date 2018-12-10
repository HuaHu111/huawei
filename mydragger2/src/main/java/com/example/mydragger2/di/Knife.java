package com.example.mydragger2.di;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by acer on 2018/10/16.
 */

public class Knife {


    @Inject
    public Knife(String name){
        Log.e("MainActivity","我是一把刀"+name);
    }
}
