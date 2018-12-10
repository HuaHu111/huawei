package com.example.myrecycledemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhxu.recyclerview.adapter.CommonAdapter;
import com.zhxu.recyclerview.base.ViewHolder;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String>listStr=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        for (int i = 0; i < 20; i++) {
            listStr.add("我是普通条目"+i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DataAdapter dataAdapter = new DataAdapter(getApplicationContext(), R.layout.item_normal);
        dataAdapter.addDataAll(listStr);
        recyclerView.setAdapter(dataAdapter);
    }


    private class DataAdapter extends CommonAdapter<String> {
        public DataAdapter(Context context, int layoutId) {
            super(context, layoutId);
        }

        @Override
        protected void convert(ViewHolder holder, String s, int position) {
            holder.setText(R.id.tv,s);
        }
    }
}
