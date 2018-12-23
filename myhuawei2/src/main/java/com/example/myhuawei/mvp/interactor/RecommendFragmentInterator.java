package com.example.myhuawei.mvp.interactor;

import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.api.RecommendApi;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.bean.RecommendBean;
import com.example.myhuawei.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/16.
 */

public class RecommendFragmentInterator  {
    @Inject
    public RecommendFragmentInterator(){

    }

    private IGetDataDelegate<RecommendBean> mDelegate;

    public void loadRecommendData(BaseActivity activity,IGetDataDelegate<RecommendBean>delegate){
        this.mDelegate=delegate;
        RecommendApi recommendApi = new RecommendApi(httplistener, activity);
        HttpManager httpManager=HttpManager.getInstance();
        httpManager.doHttpDeal(recommendApi);
    }

    HttpOnNextListener httplistener=new HttpOnNextListener<RecommendBean>() {

        @Override
        public void onNext(RecommendBean recommendBean) {
            mDelegate.getDataSuccess(recommendBean);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            RecommendBean recommendBean = JsonParseUtils.parseRecommendBean(string);
            mDelegate.getDataSuccess(recommendBean);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };

}
