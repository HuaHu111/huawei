package com.example.mydragger2.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by acer on 2018/10/16.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Type {
    String value() default "";
}
