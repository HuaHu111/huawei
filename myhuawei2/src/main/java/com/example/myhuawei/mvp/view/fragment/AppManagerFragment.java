package com.example.myhuawei.mvp.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.myhuawei.R;
import com.example.myhuawei.base.BaseFragment;
import com.example.myhuawei.mvp.view.activity.ApkManagementActivity;
import com.example.myhuawei.mvp.view.activity.CleanCacheActivity;
import com.example.myhuawei.mvp.view.activity.InstallAppInfoActivity;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.LoadingPager;
import com.example.myhuawei.view.widge.EnterLayout;

/**
 * Created by acer on 2018/10/17.
 */

public class AppManagerFragment extends BaseFragment {

    TextView tvUpdateLabel ;
    TextView tvUpdateLabelSubtitle ;
    EnterLayout installManager ;
    EnterLayout apkManager ;
    EnterLayout systemManager ;
    EnterLayout connect ;

    @Override
    protected View creatSuccessView() {
        View view= UIUtils.inflate(R.layout.fragment_manager);
        tvUpdateLabel=view.findViewById(R.id.update_label_textview);
        tvUpdateLabelSubtitle=view.findViewById(R.id.update_label_subtitle);
        installManager=view.findViewById(R.id.install_manager_layout);
        apkManager=view.findViewById(R.id.apk_manager_layout);
        systemManager=view.findViewById(R.id.system_manager_layout);
        connect=view.findViewById(R.id.connect_computer);
        initView();
        return view;
    }

    @Override
    protected void load() {
        setState(LoadingPager.LoadResult.success);
    }


    public void initView() {
        tvUpdateLabel.setText(UIUtils.getString(R.string.update_manager_title));
        tvUpdateLabelSubtitle.setText(UIUtils.getString(R.string.update_manager_subtitle_version_new));
        installManager.setTitle(UIUtils.getString(R.string.install_manager_title_ex));
        installManager.setMemo(UIUtils.getString(R.string.install_manager_subtitle));
        apkManager.setTitle(UIUtils.getString(R.string.apk_management));
        apkManager.setMemo(UIUtils.getString(R.string.apkmanage_tips_modify));
        systemManager.setTitle(UIUtils.getString(R.string.system_manager_title));
        systemManager.setMemo(UIUtils.getString(R.string.system_manager_memo));
        connect.setTitle(UIUtils.getString(R.string.connect_pc));
        connect.setMemo(UIUtils.getString(R.string.manager_phone_by_pc));

        installManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(getContext(),InstallAppInfoActivity.class));
            }
        });

        apkManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(getContext(), ApkManagementActivity.class));
            }
        });

        systemManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(getContext(), CleanCacheActivity.class));
            }
        });
    }


}
