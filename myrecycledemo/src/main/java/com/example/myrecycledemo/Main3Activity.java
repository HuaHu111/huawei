package com.example.myrecycledemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhxu.recyclerview.adapter.MultiItemTypeAdapter;
import com.zhxu.recyclerview.base.ItemViewDelegate;
import com.zhxu.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<User> userlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        userlist.add(new User("张三1",0));
        userlist.add(new User("张三2",0));
        userlist.add(new User("李四1",1));
        userlist.add(new User("李四2",1));
        userlist.add(new User("李四3",0));
        userlist.add(new User("王五1",1));
        userlist.add(new User("王五2",1));
        userlist.add(new User("王五3",0));
        userlist.add(new User("赵六1",0));
        userlist.add(new User("赵六2",1));

        UserAdapter userAdapter = new UserAdapter(getApplicationContext(), userlist);
        recyclerView.setAdapter(userAdapter);
    }

    public class UserAdapter extends MultiItemTypeAdapter<User> {
         UserAdapter(Context context, List<User> datas) {
            super(context, datas);
             addItemViewDelegate(new User0Deleger());
             addItemViewDelegate(new User1Deleger());
        }

        class User0Deleger implements ItemViewDelegate<User>{

            @Override
            public int getItemViewLayoutId() {
                return R.layout.item_normal;
            }

            @Override
            public boolean isForViewType(User item, int position) {
                return item.getType()==0;
            }

            @Override
            public void convert(ViewHolder holder, User user, int position) {
                holder.setText(R.id.tv,user.getName());
            }
        }

        class User1Deleger implements ItemViewDelegate<User>{

            @Override
            public int getItemViewLayoutId() {
                return R.layout.item_itme;
            }

            @Override
            public boolean isForViewType(User item, int position) {
                return item.getType()==1;
            }

            @Override
            public void convert(ViewHolder holder, User user, int position) {
                holder.setText(R.id.tv,user.getName());
            }
        }
    }

}
