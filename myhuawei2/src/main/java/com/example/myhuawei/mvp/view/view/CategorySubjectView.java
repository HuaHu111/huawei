package com.example.myhuawei.mvp.view.view;


import com.example.myhuawei.base.mvpbase.BaseView;

import java.util.List;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public interface CategorySubjectView extends BaseView {
    void onCategorySubjectDataSuccess(List<String> list) ;
    void onCategorySubjectDataError(String msg);
}
