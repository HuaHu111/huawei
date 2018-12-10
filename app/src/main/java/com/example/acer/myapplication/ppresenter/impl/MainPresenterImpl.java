package com.example.acer.myapplication.ppresenter.impl;

import com.example.acer.myapplication.model.User;
import com.example.acer.myapplication.ppresenter.MainPresenter;
import com.example.acer.myapplication.ppresenter.base.BasePresenterImpl;
import com.example.acer.myapplication.view.view.MainView;

/**
 * Created by acer on 2018/10/8.
 */

public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {
    @Override
    public void login(User user) {
        if (user.username.equals("张三")&&user.pwd.equals("123")){
            mPresenterView.loginsuccess();
        }else {
            mPresenterView.loginFail();
        }
    }
}
