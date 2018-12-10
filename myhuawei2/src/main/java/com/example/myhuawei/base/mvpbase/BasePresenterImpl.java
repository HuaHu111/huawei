package com.example.myhuawei.base.mvpbase;

/**
 * Created by acer on 2018/10/17.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    public T mPresenterView;

    @Override
    public void attachView(T view) {
        this.mPresenterView=view;
    }

    @Override
    public void detachView() {
        this.mPresenterView=null;
    }
}
