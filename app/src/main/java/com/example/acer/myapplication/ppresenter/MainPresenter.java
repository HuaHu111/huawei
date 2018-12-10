package com.example.acer.myapplication.ppresenter;

import com.example.acer.myapplication.model.User;
import com.example.acer.myapplication.ppresenter.base.BasePresenter;
import com.example.acer.myapplication.view.view.MainView;

/**
 * Created by acer on 2018/10/8.
 */

public interface MainPresenter extends BasePresenter<MainView> {

    void login(User user);

}
