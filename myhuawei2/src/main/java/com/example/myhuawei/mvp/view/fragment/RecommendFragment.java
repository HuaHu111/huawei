package com.example.myhuawei.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.myhuawei.base.BaseMvpFragment;
import com.example.myhuawei.mvp.presenter.impl.RecommendPresenterImpl;
import com.example.myhuawei.mvp.view.view.RecommendFragmentView;
import com.example.myhuawei.view.LoadingPager;

import javax.inject.Inject;

/**
 * Created by acer on 2018/10/17.
 */

public class RecommendFragment extends BaseMvpFragment<RecommendPresenterImpl> implements RecommendFragmentView{

    @Inject
    public RecommendPresenterImpl recommendPresenter;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Override
    protected View creatSuccessView() {
        TextView textView = new TextView(getContext());
        textView.setText("RecommendFragment");
        return textView;
    }

    @Override
    protected void load() {
//        setState(LoadingPager.LoadResult.success);
        recommendPresenter.getRecommendData();
    }

    @Override
    protected RecommendPresenterImpl initInject() {
        framgentComponent.inject(this);
        return recommendPresenter;
    }

    @Override
    public void onRecommendDataSuccess() {
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onRecommendDataFail() {
        setState(LoadingPager.LoadResult.error);
    }
}
