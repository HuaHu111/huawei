package com.example.myhuawei.base.mvpbase;

/**
 * Created by acer on 2018/10/17.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
