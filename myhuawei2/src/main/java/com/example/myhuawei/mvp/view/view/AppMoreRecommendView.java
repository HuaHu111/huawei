package com.example.myhuawei.mvp.view.view;


import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.bean.AppMoreRecommendBean;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppMoreRecommendView extends BaseView {
    void onAppMoreRecommendDataSuccess(AppMoreRecommendBean appMoreRecommendBean) ;
    void onAppMoreRecommendDataError(String msg) ;
}
