package com.example.retrofitdemo.api;

import com.example.retrofitdemo.bean.Data;
import com.zhxu.library.api.BaseResultEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by acer on 2018/10/24.
 */

public interface HttpGetService {

    @GET("AppStore/test")
    Observable<BaseResultEntity<Data>> getData();


}
