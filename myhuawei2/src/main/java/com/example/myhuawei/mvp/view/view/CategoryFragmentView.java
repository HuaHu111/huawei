package com.example.myhuawei.mvp.view.view;

import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.bean.CategoryBean;

/**
 * Created by acer on 2018/12/18.
 */

public interface CategoryFragmentView extends BaseView {
    void onRecommendDataSuccess(CategoryBean categoryBean);
    void onRecommendDataFail(String errormsg);
}
