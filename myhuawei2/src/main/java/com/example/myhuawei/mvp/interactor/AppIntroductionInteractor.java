package com.example.myhuawei.mvp.interactor;

import com.example.myhuawei.api.AppIntroductionApi;
import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.bean.AppIntroductionBean;
import com.example.myhuawei.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/25.
 */

public class AppIntroductionInteractor {

    private IGetDataDelegate<AppIntroductionBean> mDelegate;


    @Inject
    public AppIntroductionInteractor(){

    }



    public void loadAppIntrductionData(BaseActivity activity,String packageName,IGetDataDelegate<AppIntroductionBean> delegate){
        mDelegate=delegate;
        AppIntroductionApi appIntroductionApi = new AppIntroductionApi(listener, activity, packageName);
        HttpManager instance = HttpManager.getInstance();
        instance.doHttpDeal(appIntroductionApi);
    }


    private HttpOnNextListener<AppIntroductionBean> listener=new HttpOnNextListener<AppIntroductionBean>() {
        @Override
        public void onNext(AppIntroductionBean appIntroductionBean) {
            mDelegate.getDataSuccess(appIntroductionBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            AppIntroductionBean appIntroductionBean = JsonParseUtils.parseAppIntroductionBean(string);
            mDelegate.getDataSuccess(appIntroductionBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
