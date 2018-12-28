package com.example.myhuawei.mvp.view.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myhuawei.R;
import com.example.myhuawei.adapter.section.CategorySection;
import com.example.myhuawei.adapter.top.CategoryTopWrapper;
import com.example.myhuawei.base.BaseMvpFragment;
import com.example.myhuawei.bean.CategoryBean;
import com.example.myhuawei.mvp.presenter.impl.CategoryPresenterImpl;
import com.example.myhuawei.mvp.view.activity.CategoryNecessaryActivity;
import com.example.myhuawei.mvp.view.activity.CategoryNewActivity;
import com.example.myhuawei.mvp.view.activity.CategorySubjectActivity;
import com.example.myhuawei.mvp.view.activity.CategorySubscribeActivity;
import com.example.myhuawei.mvp.view.view.CategoryFragmentView;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.LoadingPager;
import com.example.myhuawei.view.ViewUpSearch;
import com.zhxu.recyclerview.section.SectionRVAdapter;

import javax.inject.Inject;

/**
 * Created by acer on 2018/10/17.
 */

public class CategoryFragment extends BaseMvpFragment<CategoryPresenterImpl> implements CategoryFragmentView {

    private String TAG=getClass().getSimpleName();
    private RecyclerView rv;
    private CategoryBean categoryBean;

    private ViewUpSearch search;
    private boolean isExpand;

    @Inject
    public CategoryPresenterImpl categoryPresenter;

    @Override
    protected void load() {
        mPresenter.getRecommendData(mActivity);
    }



    @Override
    protected View creatSuccessView() {
        View view= UIUtils.inflate(R.layout.fragment_category);
        search=view.findViewById(R.id.search);
        rv=view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        SectionRVAdapter adapter=new SectionRVAdapter(getContext());
        adapter.addSection(new CategorySection(getContext(),categoryBean.getTitle(),categoryBean.getCategoryDataBeanList()));
        CategoryTopWrapper topWrapper=new CategoryTopWrapper(getContext(),adapter);
        topWrapper.addData(categoryBean.getCategoryTopBeanList());
        rv.setAdapter(topWrapper);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) rv.getLayoutManager();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                if (firstVisibleItemPosition==0&&dy>0&&isExpand){   //dy》0上啦
                    search.updateShow(!isExpand);
                    isExpand=false;
                }else if (firstVisibleItemPosition==0&&dy<0&&!isExpand){
                    search.updateShow(!isExpand);
                    isExpand=true;
                }
            }
        });
        topWrapper.setOnItemClickListener(new CategoryTopWrapper.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(position == 0){
                    mActivity.startActivity(new Intent(mActivity, CategorySubscribeActivity.class));
                }else if(position == 1){
                    mActivity.startActivity(new Intent(mActivity,CategoryNecessaryActivity.class));
                }else if(position == 2){
                    mActivity.startActivity(new Intent(mActivity,CategoryNewActivity.class));
                }else {
                    mActivity.startActivity(new Intent(mActivity,CategorySubjectActivity.class));
                }
            }
        });
        return view;
    }


    @Override
    protected CategoryPresenterImpl initInject() {
        mFramgentComponent.inject(this);
        return categoryPresenter;
    }

    @Override
    public void onRecommendDataSuccess(CategoryBean categoryBean) {
        this.categoryBean=categoryBean;
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onRecommendDataFail(String errormsg) {
        setState(LoadingPager.LoadResult.error);
        showToast(errormsg);
    }
}
