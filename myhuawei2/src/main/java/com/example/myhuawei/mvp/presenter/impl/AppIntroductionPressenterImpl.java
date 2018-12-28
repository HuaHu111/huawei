package com.example.myhuawei.mvp.presenter.impl;

import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenterImpl;
import com.example.myhuawei.bean.AppIntroductionBean;
import com.example.myhuawei.mvp.interactor.AppIntroductionInteractor;
import com.example.myhuawei.mvp.presenter.AppIntroductionFragmentPresenter;
import com.example.myhuawei.mvp.view.view.AppIntroductionFragmentView;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/25.
 */

public class AppIntroductionPressenterImpl extends BasePresenterImpl<AppIntroductionFragmentView> implements AppIntroductionFragmentPresenter {


    @Inject
    public AppIntroductionInteractor appIntroductionInteractor;

    @Inject
    public AppIntroductionPressenterImpl(){

    }

    @Override
    public void getAppIntroductionData(BaseActivity activity, String packageName) {
            appIntroductionInteractor.loadAppIntrductionData(activity, packageName, new IGetDataDelegate<AppIntroductionBean>() {
                @Override
                public void getDataSuccess(AppIntroductionBean appIntroductionBean) {
                    mPresenterView.onAppIntroductionDataSuccess(appIntroductionBean);
                }

                @Override
                public void getDataError(String errmsg) {
                    mPresenterView.onAppIntroductionDataFail(errmsg);
                }
            });
    }
}
