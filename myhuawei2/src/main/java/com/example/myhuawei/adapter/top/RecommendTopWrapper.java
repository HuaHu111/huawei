package com.example.myhuawei.adapter.top;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.myhuawei.banner.RecommendController;
import com.zhxu.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.List;

/**
 * Created by acer on 2018/12/17.
 */

public class RecommendTopWrapper extends HeaderAndFooterWrapper {

    private RecommendController controller;

    public RecommendTopWrapper(Context context,RecyclerView.Adapter adapter) {
        super(adapter);
        controller=new RecommendController(context);
        addHeaderView(controller.getContentView());
    }

    public void addData(List<String>urls){
        if (controller!=null){
            controller.setData(urls);
        }
    }


}
