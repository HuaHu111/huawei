package com.example.myhuawei.mvp.view.activity;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myhuawei.R;
import com.example.myhuawei.base.BaseActivity;

public class ApkManagementActivity extends BaseActivity {



    TextView title_text ;
    ImageView progressImg ;
    TextView nodata_localpkg_refresh ;


    @Override
    public void initlayout() {
        setContentView(R.layout.activity_apk_management);
        title_text= (TextView) findViewById(R.id.title_text);
        progressImg= (ImageView) findViewById(R.id.progressImg);
        nodata_localpkg_refresh= (TextView) findViewById(R.id.nodata_localpkg_refresh);
    }


    @Override
    public void initview() {

        //设置沉浸式状态栏
//        setStatusBar();
        setStatus();

        //设置沉浸式状态栏背景
//        title_bar.setBackgroundResource(R.color.black_alpha_5);
        title_text.setText("安装包管理");

        nodata_localpkg_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressImg.setVisibility(View.VISIBLE);
                AnimationDrawable drawable = (AnimationDrawable) progressImg.getDrawable();
                drawable.start();
            }
        });


    }
}
