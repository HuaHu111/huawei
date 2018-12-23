package com.example.myhuawei.mvp.presenter;

import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenter;
import com.example.myhuawei.mvp.view.view.AppDetialActivityView;

/**
 * Created by acer on 2018/12/21.
 */

public interface AppDetailActivityPresenter extends BasePresenter<AppDetialActivityView> {
    void getAppDetialData(BaseActivity activity,String packageName);
}
