package com.example.myhuawei.mvp.view.view;

import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.bean.AppDetailBean;

/**
 * Created by acer on 2018/12/21.
 */

public interface AppDetialActivityView extends BaseView {
    void onAppDetailDataSuccess(AppDetailBean detailBean);
    void onAppDetialDataFail(String errmsg);
}
