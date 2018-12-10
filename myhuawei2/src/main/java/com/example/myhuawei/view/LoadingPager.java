package com.example.myhuawei.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.myhuawei.R;
import com.example.myhuawei.utils.UIUtils;


/**
 * Created by acer on 2018/6/10.
 */

public abstract class LoadingPager extends FrameLayout {


    /**
     * 默认状态
     */
    public final static int STATE_UNKOWN=0;

    /**
     * 加载中的状态
     */
    public final static  int STATE_LOADING=1;

    /**
     * j加载错误的状态
     */
    public final static int STATE_ERROR=2;

    /**
     * 加载成功的状态
     */
    public final static int STATE_SUCCESS=3;

    /**
     * j加载空状态
     */
    public final static int STATE_EMPTY=4;

    private int state=STATE_UNKOWN;


    private View loadingview;
    private View errorview;
    private View emptyView;
    private View successvView;

    public LoadingPager(@NonNull Context context) {
        super(context);
        init();
    }

    public LoadingPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        if (frameLayout==null){
//            frameLayout = new FrameLayout(getContext());
//            init();
//        }
//        return frameLayout;
//    }


    /**
     * 将布局添加到帧布局中
     */
    private void init() {
        if (loadingview==null){
            loadingview=CreatLoadingView();
            this.addView(loadingview,new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
        if (errorview==null){
            errorview=CreatErrorView();
            this.addView(errorview,new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
        if (emptyView==null){
            emptyView=CreatEmptyView();
            this.addView(emptyView,new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
        showPager();

    }

    private View CreatEmptyView() {
        return UIUtils.inflate(R.layout.loading_page_empty);
    }

    private View CreatErrorView() {
        View inflate = UIUtils.inflate(R.layout.loading_error_page);
        inflate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        return inflate ;
    }

    private View CreatLoadingView() {
        return UIUtils.inflate(R.layout.loading_page);
    }

    protected abstract View creatSuccessView();


    /**
     * 根据不同的状态显示不同的布局
     */
    private void showPager() {
        if (loadingview!=null){
            loadingview.setVisibility(state==STATE_UNKOWN||state==STATE_LOADING?View.VISIBLE:View.GONE);
        }
        if (errorview!=null){
            errorview.setVisibility(state==STATE_ERROR?View.VISIBLE:View.GONE);
        }
        if (emptyView!=null){
            emptyView.setVisibility(state==STATE_EMPTY?View.VISIBLE:View.GONE);
        }


        if (state==STATE_SUCCESS&&successvView==null){
            successvView=creatSuccessView();
            this.addView(successvView,new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }



    }


    /**
     * 请求网络 修u改状态
     */
    public void show() {
        if (state==STATE_UNKOWN||state==STATE_ERROR||STATE_EMPTY==state){
            state=STATE_LOADING;
            load();
        }
        showPager();
    }

    protected abstract void load() ;

    //设置状态
    public void setState(LoadResult result) {
        state=result.getValue();
        UIUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showPager();
            }
        });
    }

    public enum LoadResult {
        empty(STATE_EMPTY),error(STATE_ERROR),success(STATE_SUCCESS);
        int value;
        LoadResult(int value){
            this.value=value;
        }
        public int getValue(){
            return value;
        }
    }


}
