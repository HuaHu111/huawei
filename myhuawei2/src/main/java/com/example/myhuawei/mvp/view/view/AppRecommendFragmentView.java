package com.example.myhuawei.mvp.view.view;


import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.bean.AppRecommendBean;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppRecommendFragmentView extends BaseView {
    void onAppRecommendDataSuccess(AppRecommendBean appRecommendBean);
    void onAppRecommendDataError(String msg);
}
