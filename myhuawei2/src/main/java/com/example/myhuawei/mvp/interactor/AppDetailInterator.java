package com.example.myhuawei.mvp.interactor;

import com.example.myhuawei.api.AppDetailApi;
import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.bean.AppDetailBean;
import com.example.myhuawei.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/21.
 */

public class AppDetailInterator {

    @Inject
    public AppDetailInterator(){

    }

    private IGetDataDelegate<AppDetailBean>mDelegate;

    public void loadAppDetailData(BaseActivity activity,IGetDataDelegate<AppDetailBean>delegate,String packageName){
        mDelegate=delegate;
        HttpManager.getInstance().doHttpDeal(new AppDetailApi(new HttpOnNextListener<AppDetailBean>() {
            @Override
            public void onNext(AppDetailBean o) {
                mDelegate.getDataSuccess(o);
            }

            @Override
            public void onCacheNext(String string) {
                super.onCacheNext(string);
                AppDetailBean appDetailBean = JsonParseUtils.parseAppDetailBean(string);
                mDelegate.getDataSuccess(appDetailBean);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mDelegate.getDataError(e.getMessage());
            }
        },activity,packageName));
    }
}
