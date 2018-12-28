package com.example.myhuawei.mvp.view.view;


import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.bean.AppCommentBean;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface AppCommentFragmentView extends BaseView {
    void onAppCommentDataSuccess(AppCommentBean appCommentBean);
    void onAppCommentDataError(String msg) ;
}
