package com.example.myhuawei.mvp.view.activity;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.myhuawei.R;
import com.example.myhuawei.adapter.FixPagerAdapter;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.base.BaseFragment;
import com.example.myhuawei.factiory.FragmentFactory;

import java.util.ArrayList;

import butterknife.InjectView;

/**
 * Created by acer on 2018/10/17.
 */

public class HomeActivity extends BaseActivity {


    @InjectView(R.id.status_bar)
    LinearLayout statusBar;
    @InjectView(R.id.tab_layout)
    TabLayout tabLayout;
    @InjectView(R.id.tab)
    LinearLayout tab;
    @InjectView(R.id.main_viewpager)
    ViewPager mainViewpager;


    private FixPagerAdapter fixPagerAdapter;
    private String[] title={"推荐","分类","排行","管理","我的"};
    private ArrayList<Fragment> fragments;


    @Override
    public void initlayout() {
        setContentView(R.layout.activity_home);
    }


    @Override
    public void initview() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            final int statusBarHeight = getStatusBarHeight();
            statusBar.post(new Runnable() {
                @Override
                public void run() {
                    int height = statusBar.getHeight();
                    ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
                    layoutParams.height= statusBarHeight+height;
                    statusBar.setLayoutParams(layoutParams);
                }
            });
        }
        initviewAPgerFragment();
    }


    private void initviewAPgerFragment() {
        fixPagerAdapter = new FixPagerAdapter(getSupportFragmentManager());
        fragments = new ArrayList<>();
        for (int i = 0; i <title.length; i++) {
            fragments.add(FragmentFactory.createFragment(i));
        }
        fixPagerAdapter.setTitles(title);
        fixPagerAdapter.setFragments(fragments);

        mainViewpager.setAdapter(fixPagerAdapter);
        tabLayout.setupWithViewPager(mainViewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        mainViewpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BaseFragment fragment =  FragmentFactory.createFragment(position);
                fragment.show();
            }
        });


    }

}
