package com.example.myhuawei.mvp.view.view;

import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.bean.RecommendBean;

/**
 * Created by acer on 2018/10/17.
 */

public interface RecommendFragmentView extends BaseView {
    void onRecommendDataSuccess(RecommendBean recommendBean);
    void onMoreRecommendDataSuccess(RecommendBean recommendBean);
    void onRecommendDataFail(String errormsg);
}
