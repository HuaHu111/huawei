package com.example.myhuawei.mvp.presenter;

import com.example.myhuawei.base.mvpbase.BasePresenter;
import com.example.myhuawei.mvp.view.view.RecommendFragmentView;

/**
 * Created by acer on 2018/10/18.
 */

public interface RecommendFragmentPresenter extends BasePresenter<RecommendFragmentView>{

    void getRecommendData();

}
