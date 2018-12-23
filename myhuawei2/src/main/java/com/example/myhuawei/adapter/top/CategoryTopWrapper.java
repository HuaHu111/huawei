package com.example.myhuawei.adapter.top;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myhuawei.R;
import com.example.myhuawei.base.StoreApplication;
import com.example.myhuawei.bean.CategoryBean;
import com.example.myhuawei.utils.UIUtils;
import com.zhxu.recyclerview.section.SectionRVAdapter;
import com.zhxu.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.List;

/**
 * Created by acer on 2018/12/18.
 */

public class CategoryTopWrapper extends HeaderAndFooterWrapper {

    private GridView gridView;
    private Context context;

    public CategoryTopWrapper(Context context,SectionRVAdapter adapter) {
        super(adapter);
        this.context=context;
        View view = UIUtils.inflate(R.layout.header_top);
        gridView = view.findViewById(R.id.gv_title_grid);
        addHeaderView(view);
    }

    public void addData(List<CategoryBean.CategoryTopBean> topBeanList) {
        gridView.setNumColumns(topBeanList.size());
        GridAdapter adapter = new GridAdapter(context, topBeanList);
        gridView.setAdapter(adapter);
    }


    public class GridAdapter extends BaseAdapter {

        private Context mContext;
        private List<CategoryBean.CategoryTopBean> topBeanList;

        public GridAdapter(Context mContext, List<CategoryBean.CategoryTopBean> topBeanList) {
            this.mContext = mContext;
            this.topBeanList = topBeanList;
        }

        @Override
        public int getCount() {
            return topBeanList.size();
        }

        @Override
        public Object getItem(int i) {
            return topBeanList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View contentview, ViewGroup viewGroup) {
            ViewHolder holder;
            if (contentview == null) {
                contentview = UIUtils.inflate(R.layout.appdetail_subcat_title);
                holder = new ViewHolder();
                contentview.setTag(holder);
            } else {
                holder = (ViewHolder) contentview.getTag();
            }
            holder.appicon = contentview.findViewById(R.id.appicon);
            holder.ItemTitle = contentview.findViewById(R.id.ItemTitle);

            holder.ItemTitle.setText(topBeanList.get(i).getName());
            Glide.with(StoreApplication.getContext()).load(topBeanList.get(i).getIconUrl()).into(holder.appicon);
            return contentview;
        }


        public class ViewHolder {
            public ImageView appicon;
            public TextView ItemTitle;
        }
    }
}
