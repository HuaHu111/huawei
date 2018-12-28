package com.example.myhuawei.mvp.view.view;

import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.bean.AppIntroductionBean;

/**
 * Created by acer on 2018/12/25.
 */

public interface AppIntroductionFragmentView  extends BaseView{

    void onAppIntroductionDataSuccess(AppIntroductionBean appIntroductionBean);
    void onAppIntroductionDataFail(String msg);
}
