package com.example.myhuawei.mvp.presenter;

import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenter;
import com.example.myhuawei.mvp.view.view.AppIntroductionFragmentView;

/**
 * Created by acer on 2018/12/25.
 */

public interface AppIntroductionFragmentPresenter extends BasePresenter<AppIntroductionFragmentView> {

    void getAppIntroductionData(BaseActivity activity,String packageName);
}
