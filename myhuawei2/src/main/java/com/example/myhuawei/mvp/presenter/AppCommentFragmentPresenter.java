package com.example.myhuawei.mvp.presenter;


import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenter;
import com.example.myhuawei.mvp.view.view.AppCommentFragmentView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppCommentFragmentPresenter extends BasePresenter<AppCommentFragmentView> {
    void getAppCommentData(BaseActivity activity, String packageName);
}
