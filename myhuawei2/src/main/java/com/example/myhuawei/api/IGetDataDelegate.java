package com.example.myhuawei.api;

/**
 * Created by acer on 2018/12/16.
 */

public interface IGetDataDelegate<T> {
    void getDataSuccess(T t);
    void getDataError(String errmsg);
}
