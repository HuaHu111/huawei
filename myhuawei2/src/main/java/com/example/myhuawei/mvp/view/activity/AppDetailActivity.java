package com.example.myhuawei.mvp.view.activity;

import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myhuawei.R;
import com.example.myhuawei.adapter.AppDetailPagerAdapter;
import com.example.myhuawei.base.BaseMvpActivity;
import com.example.myhuawei.bean.AppDetailBean;
import com.example.myhuawei.mvp.presenter.impl.AppDetailPresenterImpl;
import com.example.myhuawei.mvp.view.fragment.AppCommentFragment;
import com.example.myhuawei.mvp.view.fragment.AppIntroductionFragment;
import com.example.myhuawei.mvp.view.fragment.AppRecommednFragment;
import com.example.myhuawei.mvp.view.view.AppDetialActivityView;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.SubTabNavigator;
import com.example.myhuawei.view.widge.DownloadProgressButton;
import com.zhxu.library.download.DownInfo;
import com.zhxu.library.download.DownState;
import com.zhxu.library.download.HttpDownManager;
import com.zhxu.library.listener.HttpDownOnNextListener;
import com.zhxu.library.utils.DbDownUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class AppDetailActivity extends BaseMvpActivity<AppDetailPresenterImpl> implements AppDetialActivityView {

    private final static String TAG = "Appdetialactivity";
    @Inject
    AppDetailPresenterImpl appDetailPresenter;



    private String packageName;
    private LinearLayout detial_head_label_icon_layout;
    private boolean expand=false;
    private LinearLayout detail_head_safe_icon_container;
    private LinearLayout detail_head_safe_icon_layout;
    private TextView detail_head_lable_folding_textview;
    private SubTabNavigator subTanNavigator;
    private ViewPager viewPager;
    private DownloadProgressButton detailDownloadButton;
    private HttpDownManager manager;
    private DbDownUtil dbDownUtil;
    private File outfile;
    private DownInfo downInfo;


    @Override
    public void initview() {
        super.initview();
        setStatus();
        TextView titletext = (TextView) findViewById(R.id.title_text);
        titletext.setText(getResources().getString(R.string.title_activity_app_detail));
        detial_head_label_icon_layout = (LinearLayout) findViewById(R.id.detail_head_label_icon_layout_linearlayout);
        detail_head_safe_icon_container = (LinearLayout) findViewById(R.id.detail_head_safe_icon_container_linearlayout);
        detail_head_safe_icon_layout = (LinearLayout) findViewById(R.id.detail_head_safe_icon_layout_linearlayout);
        detail_head_lable_folding_textview = (TextView) findViewById(R.id.detail_head_lable_folding_textview);
        subTanNavigator = (SubTabNavigator) findViewById(R.id.subTab);
        viewPager = (ViewPager) findViewById(R.id.vp);
        detailDownloadButton = (DownloadProgressButton) findViewById(R.id.detail_download_button);
    }

    @Override
    public void initlayout() {
        setContentView(R.layout.activity_app_detail2);
    }

    @Override
    protected void initData() {
        packageName = getIntent().getStringExtra("packageName");
        Log.e(TAG,packageName);
        appDetailPresenter.getAppDetialData(this, packageName);

        manager=HttpDownManager.getInstance();
        dbDownUtil=DbDownUtil.getInstance();
        downInfo = dbDownUtil.queryDownBy((long) packageName.hashCode());
        if (downInfo ==null){
            outfile= new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),packageName+".apk");
        }

    }

    @Override
    protected AppDetailPresenterImpl intiinject() {
        activityComponent.inject(this);
        return appDetailPresenter;
    }

    @Override
    public void onAppDetailDataSuccess(AppDetailBean detailBean) {

        setDetailHead(detailBean);

        setLable(detailBean);

        setSafeLabel(detailBean);

        setSubTab(detailBean);

        setDownLoad(detailBean);

    }

    private void setDownLoad(final AppDetailBean detailBean) {
        if (downInfo==null){
            detailDownloadButton.setStartText("安装"+ Formatter.formatFileSize(this,Long.parseLong(detailBean.getSize())));
        }else {
            if (downInfo.getState()==DownState.DOWN){
                detailDownloadButton.setState(DownloadProgressButton.STATUS_PROGRESS_BAR_DOWNLOADING);
                downInfo.setListener(downListenter);
                manager.startDown(downInfo);
            }else if (downInfo.getState()==DownState.PAUSE){
                detailDownloadButton.setState(DownloadProgressButton.STATUS_PROGRESS_BAR_PAUSE);
            }else if (downInfo.getState()==DownState.FINISH){
                detailDownloadButton.setState(DownloadProgressButton.STATUS_PROGRESS_BAR_BEGIN);
            }
            detailDownloadButton.setProgress((int) ((100*downInfo.getReadLength())/downInfo.getCountLength()));
        }


        detailDownloadButton.setStateChangeListener(new DownloadProgressButton.StateChangeListener() {
            @Override
            public void onPauseTask() {
                manager.pause(downInfo);
            }

            @Override
            public void onFinishTask() {

            }

            @Override
            public void onLoadingTask() {
                if (downInfo==null){
                    downInfo=new DownInfo(detailBean.getDownloadUrl());
                    downInfo.setListener(downListenter);
                    downInfo.setId((long) packageName.hashCode());
                    downInfo.setSavePath(outfile.getAbsolutePath());
                    downInfo.setState(DownState.START);
                    dbDownUtil.save(downInfo);
                }
                if (downInfo.getState()!=DownState.FINISH){
                    manager.startDown(downInfo);
                }
            }
        });
    }


    private HttpDownOnNextListener downListenter=new HttpDownOnNextListener() {
        @Override
        public void onNext(Object o) {

        }

        @Override
        public void onStart() {

        }

        @Override
        public void onComplete() {

        }

        @Override
        public void updateProgress(long readLength, long countLength) {
            int progress=(int)((100*readLength)/countLength);
            detailDownloadButton.setProgress(progress);
        }
    };

    private void setSubTab(AppDetailBean appDetailBean) {
        subTanNavigator.setLeftText(appDetailBean.getTabInfoList().get(0));
        subTanNavigator.setNoneText(appDetailBean.getTabInfoList().get(1));
        subTanNavigator.setRightText(appDetailBean.getTabInfoList().get(2));


        List<Fragment>list=new ArrayList<>();
        list.add(new AppIntroductionFragment());
        list.add(new AppCommentFragment());
        list.add(new AppRecommednFragment());
        AppDetailPagerAdapter adapter=new AppDetailPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(list);
        viewPager.setAdapter(adapter);
        subTanNavigator.setViewPager(viewPager);

        viewPager.setOnPageChangeListener(subTanNavigator);
    }

    private void setSafeLabel(AppDetailBean appDetailBean){
        for(AppDetailBean.SafeLabel safeLabelsBean : appDetailBean.getSafeLabelList()){
            View safeLabelView = UIUtils.inflate(R.layout.appdetail_item_head_safe_item);
            TextView safe_checker = (TextView) safeLabelView.findViewById(R.id.safe_checker_textview);
            TextView safe_checker_label = (TextView) safeLabelView.findViewById(R.id.safe_checker_label);
            ImageView detail_head_app_icon = (ImageView) safeLabelView.findViewById(R.id.detail_head_app_icon_imageview);
            TextView detail_safe_desc_textview = (TextView) safeLabelView.findViewById(R.id.detail_safe_desc_textview);

            safe_checker.setText(safeLabelsBean.getDetectorName());
            safe_checker_label.setText(safeLabelsBean.getDetectorDesc());
            Glide.with(UIUtils.getContext()).load(safeLabelsBean.getUrl()).into(detail_head_app_icon);
            detail_safe_desc_textview.setText(safeLabelsBean.getName());

            detail_head_safe_icon_container.addView(safeLabelView);
//            detial_head_label_icon_layout.addView(safeLabelView);
        }




        detial_head_label_icon_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expand){
                    expand=false;
                    detail_head_safe_icon_layout.setVisibility(View.GONE);
                    detail_head_lable_folding_textview.setBackgroundResource(R.drawable.ic_public_arrow_down);
                }else {
                    expand=true;
                    detail_head_safe_icon_layout.setVisibility(View.VISIBLE);
                    detail_head_lable_folding_textview.setBackgroundResource(R.drawable.ic_public_arrow_up);
                }
            }
        });
    }

    private void setLable(AppDetailBean detailBean) {
        List<AppDetailBean.LabelName> labelNameList = detailBean.getLabelNameList();
        for (AppDetailBean.LabelName lablename:labelNameList){
            View view = UIUtils.inflate(R.layout.appdetail_item_head_label_item);
            TextView label = view.findViewById(R.id.appdetail_head_label_textview);
            label.setText(lablename.getName());
            if (lablename.getType()==1){
                label.setTextColor(getResources().getColor(R.color.app_not_safe_textcolor));
            }
            ViewGroup parent = (ViewGroup) label.getParent();
            if (parent!=null){
                parent.removeAllViews();
            }
            detial_head_label_icon_layout.addView(label);
        }
    }


    private void setDetailHead(AppDetailBean detailBean) {
        ImageView detailHeadAppIconImageview = (ImageView) findViewById(R.id.detail_head_app_icon_imageview);
        TextView detailHeadAppNameTextview = (TextView) findViewById(R.id.detail_head_app_name_textview);
        RatingBar detailHeadAppStarsRatingbar = (RatingBar) findViewById(R.id.detail_head_app_stars_ratingbar);
        TextView detailHeadDownloadCountTextview = (TextView) findViewById(R.id.detail_head_download_count_textview);
        Glide.with(UIUtils.getContext()).load(detailBean.getIcoUrl()).into(detailHeadAppIconImageview);
        detailHeadAppNameTextview.setText(detailBean.getName());
        detailHeadAppStarsRatingbar.setRating(Float.parseFloat(detailBean.getStars()));
        detailHeadDownloadCountTextview.setText(detailBean.getIntro());
    }

    @Override
    public void onAppDetialDataFail(String errmsg) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbDownUtil!=null&&downInfo!=null){
            dbDownUtil.update(downInfo);
        }
    }

    public String getPackageName(){
        return packageName;
    }
}
