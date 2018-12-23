package com.example.myhuawei.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myhuawei.R;
import com.example.myhuawei.adapter.RecommendAdapter;
import com.example.myhuawei.adapter.top.RecommendTopWrapper;
import com.example.myhuawei.base.BaseMvpFragment;
import com.example.myhuawei.bean.RecommendBean;
import com.example.myhuawei.mvp.presenter.impl.RecommendPresenterImpl;
import com.example.myhuawei.mvp.view.activity.AppDetailActivity;
import com.example.myhuawei.mvp.view.view.RecommendFragmentView;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.LoadingPager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by acer on 2018/10/17.
 */

public class RecommendFragment extends BaseMvpFragment<RecommendPresenterImpl> implements RecommendFragmentView {

    @Inject
    public RecommendPresenterImpl recommendPresenter;
    private RecommendBean recommendBean;
    private RecyclerView recyclerView;
    private List<RecommendBean.RecommendAppBean> appBeenlist=new ArrayList<>();
    private RecommendAdapter adapter;
    private RecommendTopWrapper topWrapper;
    private SwipeRefreshLayout srl;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Override
    protected View creatSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_recommend2);
        recyclerView = view.findViewById(R.id.rv_recommend);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecommendAdapter(getContext(), recommendBean.getRecommendAppBeanList());

        topWrapper = new RecommendTopWrapper(getContext(),adapter);
        topWrapper.addData(recommendBean.getBannerList());
        recyclerView.setAdapter(topWrapper);

        srl = view.findViewById(R.id.ptr);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getMoreRecommendData(mActivity);
            }
        });

        adapter.setRecommendClickListener(new RecommendAdapter.AppItemClickListener() {
            @Override
            public void getAppDetail(String packageName) {
                Intent intent=new Intent(mActivity,AppDetailActivity.class);
                intent.putExtra("packageName",packageName);
                mActivity.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    protected void load() {
        recommendPresenter.getRecommendData(mActivity);
    }

    @Override
    protected RecommendPresenterImpl initInject() {
        mFramgentComponent.inject(this);
        return recommendPresenter;
    }

    @Override
    public void onRecommendDataSuccess(RecommendBean recommendBean) {
        this.recommendBean=recommendBean;
//        appBeenlist=recommendBean.getRecommendAppBeanList();
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onMoreRecommendDataSuccess(RecommendBean recommendBean) {
        appBeenlist.addAll(recommendBean.getRecommendAppBeanList());
        adapter.clearData();
        adapter.addDataAll(appBeenlist);
        topWrapper.notifyDataSetChanged();
        srl.setRefreshing(false);
    }

    @Override
    public void onRecommendDataFail(String msg) {
        setState(LoadingPager.LoadResult.error);
    }


}
