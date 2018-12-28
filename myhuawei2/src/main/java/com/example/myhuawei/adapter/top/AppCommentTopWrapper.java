package com.example.myhuawei.adapter.top;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.myhuawei.bean.AppCommentBean;
import com.zhxu.recyclerview.wrapper.HeaderAndFooterWrapper;


/**
 * <p>Description:
 *
 * @author xzhang
 */

public class AppCommentTopWrapper extends HeaderAndFooterWrapper {

    private Context mContext ;
    private AppCommentController appCommentController ;

    public AppCommentTopWrapper(Context context, RecyclerView.Adapter adapter) {
        super(adapter);
        this.mContext = context ;
        appCommentController = new AppCommentController(mContext) ;
        addHeaderView(appCommentController.getContentView());
    }

    public void addDataAll(AppCommentBean appCommentBean) {
        if (appCommentController != null)
            appCommentController.setData(appCommentBean);
    }
}
