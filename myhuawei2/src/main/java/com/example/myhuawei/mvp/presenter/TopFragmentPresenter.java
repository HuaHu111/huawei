package com.example.myhuawei.mvp.presenter;

import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenter;
import com.example.myhuawei.mvp.view.view.TopFragmentView;

/**
 * Created by acer on 2018/12/20.
 */

public interface TopFragmentPresenter  extends BasePresenter<TopFragmentView> {
    void getTopData(BaseActivity activity);
}
