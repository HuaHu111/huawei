package com.example.myhuawei.mvp.interactor;

import com.example.myhuawei.api.CategoryApi;
import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.bean.CategoryBean;
import com.example.myhuawei.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import javax.inject.Inject;

/**
 * Created by acer on 2018/12/18.
 */

public class CategoryFragmentInteractor  {

    @Inject
    public CategoryFragmentInteractor (){

    }


    private IGetDataDelegate<CategoryBean>delegate;

    public void getCategoryData(BaseActivity activity, IGetDataDelegate<CategoryBean>delegate){
        this.delegate=delegate;
        CategoryApi categoryApi = new CategoryApi(listener, activity);
        HttpManager instance = HttpManager.getInstance();
        instance.doHttpDeal(categoryApi);
    }

    HttpOnNextListener<CategoryBean>listener=new HttpOnNextListener<CategoryBean>() {
        @Override
        public void onNext(CategoryBean categoryBean) {
            delegate.getDataSuccess(categoryBean);
        }

        @Override
        public void onCacheNext(String string) {
            delegate.getDataSuccess(JsonParseUtils.parseCategoryBean(string));
            super.onCacheNext(string);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            delegate.getDataError(e.getMessage());
        }
    };
}
