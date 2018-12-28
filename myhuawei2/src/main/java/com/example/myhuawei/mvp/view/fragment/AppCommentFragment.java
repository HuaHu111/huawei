package com.example.myhuawei.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myhuawei.R;
import com.example.myhuawei.adapter.section.AppCommentContactsSection;
import com.example.myhuawei.adapter.top.AppCommentTopWrapper;
import com.example.myhuawei.base.BaseMvpFragment;
import com.example.myhuawei.bean.AppCommentBean;
import com.example.myhuawei.mvp.presenter.impl.AppCommentFragmentPresenterImpl;
import com.example.myhuawei.mvp.view.activity.AppDetailActivity;
import com.example.myhuawei.mvp.view.view.AppCommentFragmentView;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.LoadingPager;
import com.zhxu.recyclerview.section.SectionRVAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/23.
 */

public class AppCommentFragment extends BaseMvpFragment<AppCommentFragmentPresenterImpl> implements AppCommentFragmentView {
//    @BindView(R.id.rv)
    RecyclerView rv ;

    @Inject
    AppCommentFragmentPresenterImpl appCommentFragmentPresenter ;

    private String packageName ;
    private AppCommentBean appCommentBean ;
    private List<AppCommentBean.CommentsBean> hotList = new ArrayList<>();
    private List<AppCommentBean.CommentsBean> list = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        packageName = ((AppDetailActivity)getActivity()).getPackageName();
        show();
    }


    @Override
    protected View creatSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_app_comment) ;
        rv=view.findViewById(R.id.rv);
        for(AppCommentBean.CommentsBean commentsBean : appCommentBean.getComments()){
            //type为1是精彩评论
            if(commentsBean.getCommentType().equals("1")){
                hotList.add(commentsBean);
            }else{
                list.add(commentsBean);
            }
        }

        SectionRVAdapter sectionAdapter = new SectionRVAdapter(getContext());

        if(hotList.size() > 0)
            sectionAdapter.addSection(new AppCommentContactsSection(getContext(),"精彩评论",hotList));
        if(list.size() > 0)
            sectionAdapter.addSection(new AppCommentContactsSection(getContext(),"全部评论",list));

        AppCommentTopWrapper appCommentTopWrapper = new AppCommentTopWrapper(getContext(),sectionAdapter);
        appCommentTopWrapper.addDataAll(appCommentBean);
        rv.setAdapter(appCommentTopWrapper);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    protected void load() {
        appCommentFragmentPresenter.getAppCommentData(mActivity,packageName);
    }

    @Override
    protected AppCommentFragmentPresenterImpl initInject() {
        mFramgentComponent.inject(this);
        return appCommentFragmentPresenter;
    }

    @Override
    public void onAppCommentDataSuccess(AppCommentBean appCommentBean) {
        this.appCommentBean = appCommentBean ;
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onAppCommentDataError(String msg) {
        setState(LoadingPager.LoadResult.error);
    }
}
