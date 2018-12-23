package com.example.myhuawei.adapter.section;

import android.content.Context;
import android.view.View;

import com.example.myhuawei.R;
import com.example.myhuawei.bean.AppBean;
import com.zhxu.recyclerview.base.ViewHolder;
import com.zhxu.recyclerview.section.StatelessSection;

import java.util.List;

/**
 * Created by acer on 2018/12/20.
 */

public class TopSection extends StatelessSection {

    private Context context;
    private String title;
    private List<AppBean>appBeanList;

    public TopSection(Context context,String title,List<AppBean>appBeanList) {
        super(R.layout.applistitem_titlecard,R.layout.applistitem_normal);
        this.context=context;
        this.title=title;
        this.appBeanList=appBeanList;
    }

    @Override
    public int getContentItemsTotal() {
        return appBeanList.size();
    }

    @Override
    public ViewHolder getItemViewHolder(View view, int viewType) {
        return new ViewHolder(context,view);
    }

    @Override
    public void onBindItemViewHolder(ViewHolder holder, int position) {
        AppBean appBean = appBeanList.get(position);
        holder.setText(R.id.appSerial,appBean.getAliasName());
        holder.setImageUrl(R.id.appicon, appBean.getIcon());
        holder.setText(R.id.ItemTitle,appBean.getName());
        holder.setText(R.id.ItemText,appBean.getSizeDesc());
        holder.setText(R.id.memo,appBean.getMemo());
    }

    @Override
    public ViewHolder getHeaderViewHolder(Context context, View view) {
        return new ViewHolder(context,view);
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        super.onBindHeaderViewHolder(holder);
        holder.setText(R.id.ItemTitle,title);
    }
}
