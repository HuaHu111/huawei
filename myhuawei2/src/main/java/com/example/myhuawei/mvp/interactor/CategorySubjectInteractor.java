package com.example.myhuawei.mvp.interactor;


import com.example.myhuawei.api.CategorySubjectApi;
import com.example.myhuawei.api.IGetDataDelegate;
import com.example.myhuawei.base.BaseActivity;
import com.example.myhuawei.utils.JsonParseUtils;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

import java.util.List;

import javax.inject.Inject;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class CategorySubjectInteractor {

    private IGetDataDelegate<List<String>> mDelegate ;

    @Inject
    public CategorySubjectInteractor(){

    }

    public void loadCategorySubjectData(BaseActivity activity, IGetDataDelegate<List<String>> delegate){
        this.mDelegate = delegate ;
        CategorySubjectApi categorySubjectApi = new CategorySubjectApi(httpListener,activity);
        HttpManager httpListener = HttpManager.getInstance();
        httpListener.doHttpDeal(categorySubjectApi);
    }
    private HttpOnNextListener<List<String>> httpListener = new HttpOnNextListener<List<String>>() {
        @Override
        public void onNext(List<String> list) {
            mDelegate.getDataSuccess(list);
        }

        @Override
        public void onCacheNext(String string) {
            super.onCacheNext(string);
            List<String> strings = JsonParseUtils.parseCategorySubject(string);
            mDelegate.getDataSuccess(strings);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mDelegate.getDataError(e.getMessage());
        }
    };
}
