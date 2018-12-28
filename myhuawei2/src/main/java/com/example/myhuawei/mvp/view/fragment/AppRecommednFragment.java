package com.example.myhuawei.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myhuawei.R;
import com.example.myhuawei.adapter.section.AppRecommendHotSection;
import com.example.myhuawei.adapter.section.AppRecommendPopularSection;
import com.example.myhuawei.adapter.section.AppRecommendTasteSection;
import com.example.myhuawei.base.BaseMvpFragment;
import com.example.myhuawei.bean.AppRecommendBean;
import com.example.myhuawei.mvp.presenter.impl.AppRecommendFragmentPresenterImpl;
import com.example.myhuawei.mvp.view.activity.AppDetailActivity;
import com.example.myhuawei.mvp.view.view.AppRecommendFragmentView;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.LoadingPager;
import com.zhxu.recyclerview.section.SectionRVAdapter;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/23.
 */

public class AppRecommednFragment  extends BaseMvpFragment<AppRecommendFragmentPresenterImpl> implements AppRecommendFragmentView {

//    @BindView(R.id.rv)
    RecyclerView rv ;

    @Inject
    AppRecommendFragmentPresenterImpl appRecommendFragmentPresenter ;

    private String packageName ;

    private AppRecommendBean appRecommendBean ;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        packageName = ((AppDetailActivity)getActivity()).getPackageName();
        show();
    }

    @Override
    protected View creatSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_app_recommend);
        rv=view.findViewById(R.id.rv);

        SectionRVAdapter adapter = new SectionRVAdapter(getContext());
        adapter.addSection(new AppRecommendPopularSection(getContext(),"流行应用",appRecommendBean.getPopularAppBeanList(),packageName));
        adapter.addSection(new AppRecommendTasteSection(getContext(),"兴趣相近的用户也安装了",appRecommendBean.getTasteAppBeanList(),packageName));
        adapter.addSection(new AppRecommendHotSection(getContext(),"本周热议的社区应用",appRecommendBean.getHotAppBeanList(),packageName));
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    protected void load() {
        appRecommendFragmentPresenter.getAppRecommendData(mActivity,packageName);
    }

    @Override
    protected AppRecommendFragmentPresenterImpl initInject() {
        mFramgentComponent.inject(this);
        return appRecommendFragmentPresenter;
    }

    @Override
    public void onAppRecommendDataSuccess(AppRecommendBean appRecommendBean) {
        this.appRecommendBean = appRecommendBean ;
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onAppRecommendDataError(String msg) {
        setState(LoadingPager.LoadResult.error);
    }
}
