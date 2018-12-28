package com.example.myhuawei.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myhuawei.R;
import com.example.myhuawei.base.BaseMvpFragment;
import com.example.myhuawei.bean.AppIntroductionBean;
import com.example.myhuawei.mvp.presenter.impl.AppIntroductionPressenterImpl;
import com.example.myhuawei.mvp.view.activity.GalleryActivity;
import com.example.myhuawei.mvp.view.view.AppIntroductionFragmentView;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.LoadingPager;
import com.example.myhuawei.view.widge.FlowLayout;
import com.example.myhuawei.view.widge.FoldingTextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/23.
 */

public class AppIntroductionFragment extends BaseMvpFragment<AppIntroductionPressenterImpl> implements AppIntroductionFragmentView, View.OnClickListener {

    @Inject
    public AppIntroductionPressenterImpl appIntroductionPressenter;
    private String packageName;
    private AppIntroductionBean appIntroductionBean;


    //    @Inject(R.id.app_detail_gallery_container_linearlayout)
    LinearLayout app_detail_gallery_container;
    //    @BindView(R.id.detail_appinfo_tariff_textview)
    TextView appInfoTariff;
    //    @BindView(R.id.detail_appinfo_size_textview)
    TextView appInfoSize;
    //    @BindView(R.id.detail_appinfo_version_textview)
    TextView appInfoVersion;
    //    @BindView(R.id.detail_appinfo_release_date_textview)
    TextView appInfoDate;
    //    @BindView(R.id.appdetail_appinfo_developer_textview)
    TextView appInfoDeveloper;
    //    @BindView(R.id.ll)
    LinearLayout appInfoDes;
    //    @BindView(R.id.flowLayout)
    FlowLayout flowLayout;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        packageName = (getActivity()).getPackageName();
        show();
    }


    @Override
    protected View creatSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_app_introduction);
        app_detail_gallery_container = view.findViewById(R.id.app_detail_gallery_container_linearlayout);
        appInfoTariff = view.findViewById(R.id.detail_appinfo_tariff_textview);
        appInfoSize = view.findViewById(R.id.detail_appinfo_size_textview);
        appInfoVersion = view.findViewById(R.id.detail_appinfo_version_textview);
        appInfoDate = view.findViewById(R.id.detail_appinfo_release_date_textview);
        appInfoDeveloper = view.findViewById(R.id.appdetail_appinfo_developer_textview);
        appInfoDes = view.findViewById(R.id.ll);
        flowLayout = view.findViewById(R.id.flowLayout);


        for (int i = 0; i < appIntroductionBean.getImageCompressList().size(); i++) {
            String url = appIntroductionBean.getImageCompressList().get(i);
            View screenView = View.inflate(getContext(), R.layout.appdetail_item_screen_image, null);
            ImageView screenImageView = (ImageView) screenView.findViewById(R.id.appdetail_screen_img_imageview);
            screenImageView.setContentDescription(screenImageView.getResources().getString(R.string.appdetail_screenshot));
            screenImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            screenView.setOnClickListener(this);
            screenView.setTag(i);
            Glide.with(UIUtils.getContext()).load(url).into(screenImageView);
            app_detail_gallery_container.addView(screenView);
        }

        appInfoTariff.setText(appIntroductionBean.getAppInfoBean().getTariffDesc());
        appInfoSize.setText(Formatter.formatFileSize(getContext(), Long.parseLong(appIntroductionBean.getAppInfoBean().getSize())));
        appInfoDate.setText(appIntroductionBean.getAppInfoBean().getReleaseDate());
        appInfoVersion.setText(appIntroductionBean.getAppInfoBean().getVersion());
        appInfoDeveloper.setText(appIntroductionBean.getAppInfoBean().getDeveloper());

        for (int i = 0; i < appIntroductionBean.getAppDetailInfoBeanList().size(); i++) {
            FoldingTextView foldingTextView = new FoldingTextView(getContext());
            foldingTextView.setTitle(appIntroductionBean.getAppDetailInfoBeanList().get(i).getTitle());
            foldingTextView.setContent(appIntroductionBean.getAppDetailInfoBeanList().get(i).getBody());
            appInfoDes.addView(foldingTextView);
        }

        List<String> tagList = appIntroductionBean.getTagList();
        for (int i = 0; i < tagList.size(); i++) {
            View labView = UIUtils.inflate(R.layout.appdetail_item_label_item);
            TextView tv = (TextView) labView.findViewById(R.id.appdetail_label_content_textview);
            tv.setText(tagList.get(i));
            flowLayout.addView(labView);
        }
        return view;
    }

    @Override
    protected void load() {
        appIntroductionPressenter.getAppIntroductionData(mActivity, packageName);
    }

    @Override
    protected AppIntroductionPressenterImpl initInject() {
        mFramgentComponent.inject(this);
        return appIntroductionPressenter;
    }

    @Override
    public void onAppIntroductionDataSuccess(AppIntroductionBean appIntroductionBean) {
        setState(LoadingPager.LoadResult.success);
        this.appIntroductionBean = appIntroductionBean;
    }

    @Override
    public void onAppIntroductionDataFail(String msg) {
        setState(LoadingPager.LoadResult.error);

    }

    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        List<String> images = appIntroductionBean.getImagesList();
        Intent intent = new Intent(getContext(), GalleryActivity.class);
        intent.putExtra("tag",tag) ;
        intent.putStringArrayListExtra("urlList", (ArrayList<String>) images);
        getActivity().startActivity(intent) ;
    }
}
