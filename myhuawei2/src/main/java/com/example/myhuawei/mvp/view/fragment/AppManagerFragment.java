package com.example.myhuawei.mvp.view.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.myhuawei.base.BaseFragment;
import com.example.myhuawei.view.LoadingPager;

/**
 * Created by acer on 2018/10/17.
 */

public class AppManagerFragment extends BaseFragment {
    @Override
    protected View creatSuccessView() {
        TextView textView = new TextView(getContext());
        textView.setText("AppManagerFragment");
        return textView;
    }

    @Override
    protected void load() {
        setState(LoadingPager.LoadResult.success);
    }
}
