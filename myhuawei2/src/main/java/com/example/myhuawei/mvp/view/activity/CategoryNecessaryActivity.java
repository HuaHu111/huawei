package com.example.myhuawei.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.myhuawei.R;
import com.example.myhuawei.adapter.top.CategoryNecessaryTopWrapper;
import com.example.myhuawei.base.BaseMvpActivity;
import com.example.myhuawei.bean.AppBean;
import com.example.myhuawei.bean.CategoryNecessaryBean;
import com.example.myhuawei.mvp.presenter.impl.CategoryNecessaryPresenterImpl;
import com.example.myhuawei.mvp.view.view.CategoryNecessaryView;
import com.zhxu.recyclerview.adapter.CommonAdapter;
import com.zhxu.recyclerview.adapter.MultiItemTypeAdapter;
import com.zhxu.recyclerview.base.ViewHolder;

import javax.inject.Inject;


public class CategoryNecessaryActivity extends BaseMvpActivity<CategoryNecessaryPresenterImpl> implements CategoryNecessaryView {

//    @BindView(R.id.title_text)
    TextView title_text ;
//    @BindView(R.id.iv_search)
//    ImageView iv_search ;
//    @BindView(R.id.rv)
    RecyclerView rv ;

    @Inject
    public CategoryNecessaryPresenterImpl categoryNecessaryPresenter ;




    @Override
    public void initlayout() {
        setContentView(R.layout.activity_category_necessary);
        title_text= (TextView) findViewById(R.id.title_text);
        rv= (RecyclerView) findViewById(R.id.rv);
    }

    @Override
    public void initview() {
        //设置沉浸式状态栏
        setStatus();
//        iv_search.setVisibility(View.VISIBLE);
        //设置沉浸式状态栏背景
//        title_bar.setBackgroundResource(R.color.black_alpha_5);
        title_text.setText("装机必备");
    }

    @Override
    protected void initData() {
        categoryNecessaryPresenter.getCategoryNecessaryData(this);
    }

    @Override
    public CategoryNecessaryPresenterImpl intiinject() {
        activityComponent.inject(this);
        return categoryNecessaryPresenter;
    }



    @Override
    public void onCategoryNecessaryDataSuccess(final CategoryNecessaryBean categoryNecessaryBean) {
        rv.setLayoutManager(new LinearLayoutManager(this));
        CategoryNecessaryAdapter adapter = new CategoryNecessaryAdapter(this);
        adapter.addDataAll(categoryNecessaryBean.getAppBeanList());
        CategoryNecessaryTopWrapper categoryNecessaryTopWrapper = new CategoryNecessaryTopWrapper(this,adapter,categoryNecessaryBean.getHead());
        rv.setAdapter(categoryNecessaryTopWrapper);

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                AppBean appBean = categoryNecessaryBean.getAppBeanList().get(position);
                Intent intent = new Intent(CategoryNecessaryActivity.this,AppDetailActivity.class);
                intent.putExtra("packageName",appBean.getPackageName());
                startActivity(intent);

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                return false;
            }
        });
    }

    @Override
    public void onCategoryNecessaryDataError(String msg) {

    }

    class CategoryNecessaryAdapter extends CommonAdapter<AppBean> {

        public CategoryNecessaryAdapter(Context context) {
            super(context, R.layout.applistitem_recommend);
        }
        @Override
        protected void convert(ViewHolder holder, AppBean appBean, int position) {
            holder.setText(R.id.appTitle,appBean.getName());
            holder.setText(R.id.app_size,appBean.getSizeDesc());
            holder.setText(R.id.app_des,appBean.getMemo());
            holder.setImageUrl(R.id.appicon,appBean.getIcon());
        }
    }
}
