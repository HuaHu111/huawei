package com.example.myhuawei.mvp.view.view;

import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.bean.TopBean;

/**
 * Created by acer on 2018/12/20.
 */

public interface TopFragmentView extends BaseView {

    void onTopDataSuccess(TopBean topBean);
    void onTopDataFail(String errormsg);
}
