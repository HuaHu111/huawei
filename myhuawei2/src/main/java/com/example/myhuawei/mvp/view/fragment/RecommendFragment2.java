package com.example.myhuawei.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myhuawei.R;
import com.example.myhuawei.adapter.RecommendAdapter;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.StoreApplication;
import com.example.myhuawei.bean.RecommendBean;
import com.example.myhuawei.di.component.DaggerFramgentComponent;
import com.example.myhuawei.di.component.FramgentComponent;
import com.example.myhuawei.di.module.FragmentModule;
import com.example.myhuawei.mvp.presenter.impl.RecommendPressenter1111;
import com.example.myhuawei.mvp.view.view.RecommendFragmentView;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.LoadingPager;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/17.
 */

public class RecommendFragment2 extends Fragment implements RecommendFragmentView {

    private LoadingPager loadingPager;
    public BaseActivity mActivity;
    public FramgentComponent framgentComponent;
    public RecommendPressenter1111 mPresenter;
    @Inject
    public RecommendPressenter1111 recommendPresenter;
    private RecommendBean recommendBean;
    private RecyclerView recyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        framgentComponent = DaggerFramgentComponent.builder()
                .fragmentModule(new FragmentModule(this))
                .appComponent(((StoreApplication) getActivity().getApplication()).getAppCompoment())
                .build();
        framgentComponent.inject(this);
        mPresenter = recommendPresenter;
        mPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (loadingPager==null){
            loadingPager=new LoadingPager(getContext()) {
                @Override
                protected View creatSuccessView() {
                    return creatSuccessViews();
                }

                @Override
                protected void load() {
                    loadd();
                }
            };
        }
        return loadingPager;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity= (BaseActivity) getActivity();
        show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    public void show(){
        if (loadingPager!=null){
            loadingPager.show();
        }
    }


    public void setState(LoadingPager.LoadResult result){
        if (loadingPager!=null){
            loadingPager.setState(result);
        }
    }



    @Override
    public void onRecommendDataSuccess(RecommendBean recommendBean) {
        this.recommendBean=recommendBean;
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onMoreRecommendDataSuccess(RecommendBean recommendBean) {

    }

    @Override
    public void onRecommendDataFail(String errormsg) {
        setState(LoadingPager.LoadResult.error);
        showToast(errormsg);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }



    protected View creatSuccessViews() {
        View view = UIUtils.inflate(R.layout.fragment_recommend2);
        recyclerView = view.findViewById(R.id.rv_recommend);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecommendAdapter adapter = new RecommendAdapter(getContext(), recommendBean.getRecommendAppBeanList());
        recyclerView.setAdapter(adapter);
        return view;
    }

    protected void loadd() {
        recommendPresenter.getRecommendData(mActivity);
    }
}
