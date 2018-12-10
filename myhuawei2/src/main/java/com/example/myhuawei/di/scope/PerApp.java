package com.example.myhuawei.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by acer on 2018/10/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApp {
}
