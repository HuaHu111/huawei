package com.example.mydragger2.di.Module;

import com.example.mydragger2.di.Knife;
import com.example.mydragger2.di.scope.Type;

import dagger.Module;
import dagger.Provides;

/**
 * Created by acer on 2018/10/16.
 */

@Module
public class Main3Module {


    @Provides
    @Type("ruishi")
    public Knife provideMain3module1(){
        return new Knife("瑞士🔪");
    }


    @Provides
    @Type("shuiguo")
    public Knife provideMain3module2(){
        return new Knife("普通🔪");
    }
}
