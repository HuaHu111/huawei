package com.example.myrecycledemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhxu.recyclerview.base.ViewHolder;
import com.zhxu.recyclerview.section.SectionRVAdapter;
import com.zhxu.recyclerview.section.StatelessSection;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<String>list=new ArrayList<>();
    private ArrayList<String>listtitle=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        for (int i = 0; i < 20; i++) {
            list.add("我是selection"+i);
            listtitle.add("我是title"+i);
        }

        SectionRVAdapter adapter = new SectionRVAdapter(getApplicationContext());
        adapter.addSection(new DataSection("我是titile1",list,getApplicationContext()));
        adapter.addSection(new DataSection("我是titile22",list,getApplicationContext()));
        adapter.addSection(new DataSection("我是titile333",list,getApplicationContext()));
        rv.setAdapter(adapter);
    }



    private class DataSection extends StatelessSection{

        private String title;
        private ArrayList<String>strlist;
        private Context context;



        public DataSection(String title,ArrayList<String>strlist,Context context) {
            super(R.layout.item_normal,R.layout.item_itme);
            this.title=title;
            this.strlist=strlist;
            this.context=context;
        }


        @Override
        public int getContentItemsTotal() {
            return strlist.size();
        }

        @Override
        public ViewHolder getItemViewHolder(View view, int viewType) {
            return new ViewHolder(context,view);
        }

        @Override
        public void onBindItemViewHolder(ViewHolder holder, int position) {
            String s=strlist.get(position);
            holder.setText(R.id.tv,s);
        }

        @Override
        public ViewHolder getHeaderViewHolder(Context context, View view) {
            return new ViewHolder(context,view);
        }

        @Override
        public void onBindHeaderViewHolder(ViewHolder holder) {
            super.onBindHeaderViewHolder(holder);
            holder.setText(R.id.tv,title);
        }
    }
}
