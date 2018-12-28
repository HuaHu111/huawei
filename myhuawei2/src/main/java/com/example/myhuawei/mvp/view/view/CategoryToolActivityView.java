package com.example.myhuawei.mvp.view.view;


import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.bean.CategoryToolBean;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategoryToolActivityView extends BaseView {
    void onCategoryToolDataSuccess(CategoryToolBean categoryToolBean);
    void onCategoryToolError(String msg);
}
