package com.example.myhuawei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.myhuawei.base.mvpbase.BasePresenter;
import com.example.myhuawei.base.mvpbase.BaseView;
import com.example.myhuawei.di.component.DaggerFramgentComponent;
import com.example.myhuawei.di.component.FramgentComponent;
import com.example.myhuawei.di.module.FragmentModule;

/**
 * Created by acer on 2018/10/17.
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    public FramgentComponent mFramgentComponent;
    public T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentCompent();
        mPresenter = initInject();
        mPresenter.attachView(this);
    }

    private void initFragmentCompent() {
        mFramgentComponent = DaggerFramgentComponent.builder()
                .fragmentModule(new FragmentModule(this))
                .appComponent(((StoreApplication) getActivity().getApplication()).getAppCompoment())
                .build();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    protected abstract T initInject();
}
