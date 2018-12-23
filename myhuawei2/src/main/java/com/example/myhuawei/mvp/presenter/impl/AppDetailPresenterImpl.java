package com.example.myhuawei.mvp.presenter.impl;

import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenterImpl;
import com.example.myhuawei.bean.AppDetailBean;
import com.example.myhuawei.mvp.interactor.AppDetailInterator;
import com.example.myhuawei.mvp.presenter.AppDetailActivityPresenter;
import com.example.myhuawei.mvp.view.view.AppDetialActivityView;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/21.
 */

public class AppDetailPresenterImpl extends BasePresenterImpl<AppDetialActivityView> implements AppDetailActivityPresenter{


    @Inject
    public AppDetailInterator appDetailInterator;

    @Inject
    public AppDetailPresenterImpl(){

    }

    @Override
    public void getAppDetialData(BaseActivity activity,String packageName) {
        appDetailInterator.loadAppDetailData(activity, new IGetDataDelegate<AppDetailBean>() {
            @Override
            public void getDataSuccess(AppDetailBean detailBean) {
                mPresenterView.onAppDetailDataSuccess(detailBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onAppDetialDataFail(errmsg);
            }
        },packageName);
    }
}
