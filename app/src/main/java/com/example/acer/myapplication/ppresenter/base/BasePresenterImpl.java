package com.example.acer.myapplication.ppresenter.base;

import com.example.acer.myapplication.view.view.BaseView;

/**
 * Created by acer on 2018/10/8.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    public T mPresenterView;

    @Override
    public void attachView(T view) {
        mPresenterView=view;
    }

    @Override
    public void detachView() {
        mPresenterView=null;
    }
}
