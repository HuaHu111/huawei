package com.example.myhuawei.mvp.presenter.impl;

import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenterImpl;
import com.example.myhuawei.bean.RecommendBean;
import com.example.myhuawei.mvp.interactor.RecommendFragmentInterator;
import com.example.myhuawei.mvp.presenter.RecommendFragmentPresenter;
import com.example.myhuawei.mvp.view.view.RecommendFragmentView;

import javax.inject.Inject;

/**
 * Created by acer on 2018/10/18.
 */

public class RecommendPresenterImpl extends BasePresenterImpl<RecommendFragmentView> implements RecommendFragmentPresenter {

    @Inject
    RecommendFragmentInterator mRecommendFragmentInterator;

    @Inject
    public RecommendPresenterImpl() {

    }


    @Override
    public void getRecommendData(BaseActivity activity) {
        mRecommendFragmentInterator.loadRecommendData(activity, new IGetDataDelegate<RecommendBean>() {
            @Override
            public void getDataSuccess(RecommendBean recommendBean) {
                mPresenterView.onRecommendDataSuccess(recommendBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onRecommendDataFail(errmsg);
            }
        });
    }

    @Override
    public void getMoreRecommendData(BaseActivity activity) {
        mRecommendFragmentInterator.loadRecommendData(activity, new IGetDataDelegate<RecommendBean>() {
            @Override
            public void getDataSuccess(RecommendBean recommendBean) {
                mPresenterView.onMoreRecommendDataSuccess(recommendBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onRecommendDataFail(errmsg);
            }
        });
    }


}
