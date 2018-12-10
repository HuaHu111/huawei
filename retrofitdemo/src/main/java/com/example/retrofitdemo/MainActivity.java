package com.example.retrofitdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.retrofitdemo.api.DataApi;
import com.example.retrofitdemo.bean.Data;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zhxu.library.http.HttpManager;
import com.zhxu.library.listener.HttpOnNextListener;

public class MainActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get();
            }
        });
    }

    private void get(){
        DataApi  api=new DataApi(listent,this);
        HttpManager instance = HttpManager.getInstance();
        instance.doHttpDeal(api);
    }

    private HttpOnNextListener<Data> listent=new HttpOnNextListener<Data>() {
        @Override
        public void onNext(Data data) {
            Log.e("TAG",data.toString());
        }
    };
}
