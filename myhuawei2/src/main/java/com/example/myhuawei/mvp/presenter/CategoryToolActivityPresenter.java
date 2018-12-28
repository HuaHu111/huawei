package com.example.myhuawei.mvp.presenter;


import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.mvpbase.BasePresenter;
import com.example.myhuawei.mvp.view.view.CategoryToolActivityView;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryToolActivityPresenter extends BasePresenter<CategoryToolActivityView> {
    void getCategoryToolData(BaseActivity activity) ;
}
