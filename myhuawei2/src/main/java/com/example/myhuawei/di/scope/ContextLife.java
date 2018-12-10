package com.example.myhuawei.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by acer on 2018/10/17.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextLife {
    String  value() default "";
}
