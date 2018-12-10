package com.example.mydragger2.di.component;

import com.example.mydragger2.di.Main3Activity;
import com.example.mydragger2.di.Module.Main3Module;

import dagger.Component;

/**
 * Created by acer on 2018/10/16.
 */


@Component(modules = Main3Module.class)
public interface Main3Component {


    void inject(Main3Activity activity);
}
