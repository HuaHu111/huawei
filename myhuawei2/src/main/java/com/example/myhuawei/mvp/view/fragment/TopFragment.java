package com.example.myhuawei.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myhuawei.R;
import com.example.myhuawei.adapter.section.TopSection;
import com.example.myhuawei.adapter.top.TopTopWrapper;
import com.example.myhuawei.base.BaseMvpFragment;
import com.example.myhuawei.bean.AppBean;
import com.example.myhuawei.bean.TopBean;
import com.example.myhuawei.mvp.presenter.impl.TopPresenterImpl;
import com.example.myhuawei.mvp.view.view.TopFragmentView;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.LoadingPager;
import com.example.myhuawei.view.ViewUpSearch;
import com.zhxu.recyclerview.section.SectionRVAdapter;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;


/**
 * Created by acer on 2018/10/17.
 */
//public class TopFragment extends BaseFragment {
//    @Override
//    protected View creatSuccessView() {
//        return null;
//    }
//
//    @Override
//    protected void load() {
//        setState(LoadingPager.LoadResult.error);
//    }


public class TopFragment extends BaseMvpFragment<TopPresenterImpl> implements TopFragmentView {

    private final static String TAG ="TopFragment";
    private TopBean topBean;
    private boolean isExpand;

    @Inject
    public TopPresenterImpl topPresenter;
    private RecyclerView rv;
    private ViewUpSearch search;

    @Override
    protected TopPresenterImpl initInject() {
        mFramgentComponent.inject(this);
        return topPresenter;
//        return null;
    }

    @Override
    protected View creatSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_top);
        rv = view.findViewById(R.id.rv);
        search = view.findViewById(R.id.search);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        SectionRVAdapter adapter=new SectionRVAdapter(getContext());
        Map<String, List<AppBean>> appBeanMap = topBean.getAppBeanMap();
        Set<String> strings = appBeanMap.keySet();
        for (String key : strings) {
            List<AppBean> appBeenlist = appBeanMap.get(key);
            adapter.addSection(new TopSection(getContext(),key,appBeenlist));
        }

        TopTopWrapper topTopWrapper=new TopTopWrapper(getContext(),adapter);
        topTopWrapper.addData(topBean.getTopTopBeanList());
        rv.setAdapter(topTopWrapper);


        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) rv.getLayoutManager();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                if (firstVisibleItemPosition==0&&dy>0&&isExpand){   //dy》0上啦
                    search.updateShow(!isExpand);
                    isExpand=false;
                }else if (firstVisibleItemPosition==0&&dy<0&&!isExpand){
                    search.updateShow(!isExpand);
                    isExpand=true;
                }
            }
        });
        return view;
    }

    @Override
    protected void load() {
        topPresenter.getTopData(mActivity);
    }

    @Override
    public void onTopDataSuccess(TopBean topBean) {
        this.topBean=topBean;
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onTopDataFail(String errormsg) {
        setState(LoadingPager.LoadResult.error);
        showToast(errormsg);
    }
}
