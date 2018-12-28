package com.example.myhuawei.mvp.presenter;


import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenter;
import com.example.myhuawei.mvp.view.view.AppMoreRecommendView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppMoreRecommendPresenter extends BasePresenter<AppMoreRecommendView> {
    void getAppMoreRecommendData(BaseActivity activity, String type, String packageName) ;
}
