package com.example.myhuawei.mvp.presenter.impl;


import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenterImpl;
import com.example.myhuawei.bean.CategoryBean;
import com.example.myhuawei.mvp.interactor.CategoryFragmentInteractor;
import com.example.myhuawei.mvp.presenter.CategoryFragmentPresenter;
import com.example.myhuawei.mvp.view.view.CategoryFragmentView;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategoryFragmentPresenterImpl extends BasePresenterImpl<CategoryFragmentView> implements CategoryFragmentPresenter {

    @Inject
    CategoryFragmentInteractor categoryFragmentInteractor ;

    @Inject
    public CategoryFragmentPresenterImpl(){

    }



    @Override
    public void getRecommendData(BaseActivity activity) {
        categoryFragmentInteractor.getCategoryData(activity, new IGetDataDelegate<CategoryBean>() {
            @Override
            public void getDataSuccess(CategoryBean categoryBean) {
                mPresenterView.onRecommendDataSuccess(categoryBean);
            }

            @Override
            public void getDataError(String errmsg) {
                mPresenterView.onRecommendDataFail(errmsg);
            }
        });
    }

}
