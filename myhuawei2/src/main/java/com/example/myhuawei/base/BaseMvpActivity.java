package com.example.myhuawei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.myhuawei.base.mvpbase.BasePresenter;
import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.di.component.ActivityComponent;
import com.example.myhuawei.di.component.DaggerActivityComponent;
import com.example.myhuawei.di.module.ActivityModule;

/**
 * Created by acer on 2018/10/17.
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    public ActivityComponent activityComponent;
    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityComponent();
        mPresenter = intiinject();
        mPresenter.attachView(this);
        initData();
    }

    protected  abstract  void initData();

    public void initActivityComponent() {
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((StoreApplication) getApplication()).getAppCompoment())
                .build();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 完成注入并返回注入的Presenter对象
     *
     * @return
     */
    protected abstract T intiinject();

}
