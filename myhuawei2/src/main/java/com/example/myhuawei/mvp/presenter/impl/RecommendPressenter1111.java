package com.example.myhuawei.mvp.presenter.impl;

import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.bean.RecommendBean;
import com.example.myhuawei.mvp.interactor.RecommendFragmentInterator;
import com.example.myhuawei.mvp.presenter.RecommendFragmentPresenter;
import com.example.myhuawei.mvp.view.view.RecommendFragmentView;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/17.
 */

public class RecommendPressenter1111 implements  RecommendFragmentPresenter {

    public RecommendFragmentView mPresenterView;

    @Inject
    RecommendFragmentInterator mRecommendFragmentInterator;

    @Inject
    public RecommendPressenter1111() {

    }

    @Override
    public void getRecommendData(BaseActivity activity) {
        IGetDataDelegate<RecommendBean> iGetDataDelegate = new IGetDataDelegate<RecommendBean>() {
            @Override
            public void getDataSuccess(RecommendBean recommendBean) {
                mPresenterView.onRecommendDataSuccess(recommendBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onRecommendDataFail(errmsg);
            }
        };
        mRecommendFragmentInterator.loadRecommendData(activity,iGetDataDelegate );
    }

    @Override
    public void getMoreRecommendData(BaseActivity activity) {

    }

    @Override
    public void attachView(RecommendFragmentView view) {
        this.mPresenterView=view;
    }

    @Override
    public void detachView() {
        this.mPresenterView=null;
    }
}
