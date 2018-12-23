package com.example.myhuawei.mvp.interactor;

import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.api.TopApi;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.bean.TopBean;
import com.example.myhuawei.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/20.
 */

public class TopFragmentInterator {


    @Inject
    public TopFragmentInterator (){

    }


    public void loadTopData (BaseActivity activity, final IGetDataDelegate<TopBean>iGetDataDelegate){
        TopApi topApi = new TopApi(new HttpOnNextListener<TopBean>() {
            @Override
            public void onNext(TopBean topBean) {
                iGetDataDelegate.getDataSuccess(topBean);
            }

            @Override
            public void onCacheNext(String string) {
                super.onCacheNext(string);
                TopBean topBean = JsonParseUtils.parseTopBean(string);
                iGetDataDelegate.getDataSuccess(topBean);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                iGetDataDelegate.getDataError(e.getMessage());
            }
        }, activity);
        HttpManager httpManager=HttpManager.getInstance();
        httpManager.doHttpDeal(topApi);
    }
}
