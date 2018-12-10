package com.example.myhuawei.mvp.presenter.impl;

import android.os.SystemClock;

import com.example.myhuawei.base.mvpbase.BasePresenterImpl;
import com.example.myhuawei.mvp.presenter.RecommendFragmentPresenter;
import com.example.myhuawei.mvp.view.view.RecommendFragmentView;

import javax.inject.Inject;

/**
 * Created by acer on 2018/10/18.
 */

public class RecommendPresenterImpl extends BasePresenterImpl<RecommendFragmentView> implements RecommendFragmentPresenter {


    @Inject
    public RecommendPresenterImpl() {

    }

    @Override
    public void getRecommendData() {


        //模拟网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                mPresenterView.onRecommendDataSuccess();
            }
        }).start();
    }

}
