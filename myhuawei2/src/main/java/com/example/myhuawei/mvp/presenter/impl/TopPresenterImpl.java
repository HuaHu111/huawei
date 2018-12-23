package com.example.myhuawei.mvp.presenter.impl;

import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenterImpl;
import com.example.myhuawei.bean.TopBean;
import com.example.myhuawei.mvp.interactor.TopFragmentInterator;
import com.example.myhuawei.mvp.presenter.TopFragmentPresenter;
import com.example.myhuawei.mvp.view.view.TopFragmentView;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/20.
 */

public class TopPresenterImpl extends BasePresenterImpl<TopFragmentView> implements TopFragmentPresenter {


    @Inject
    public TopFragmentInterator interator;


    @Inject
    public TopPresenterImpl(){

    }


    @Override
    public void getTopData(BaseActivity activity) {
        interator.loadTopData(activity, new IGetDataDelegate<TopBean>() {
            @Override
            public void getDataSuccess(TopBean topBean) {
                mPresenterView.onTopDataSuccess(topBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onTopDataFail(errmsg);
            }
        });
    }
}
