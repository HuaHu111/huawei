package com.example.acer.myapplication.ppresenter.base;

/**
 * Created by acer on 2018/10/8.
 */

public interface BasePresenter<T> {

    void attachView(T view);

    void detachView();

}
