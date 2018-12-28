package com.example.myhuawei.mvp.view.activity;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.myhuawei.R;
import com.example.myhuawei.base.BaseActivity;

import static android.R.drawable.title_bar;


public class WebViewActivity extends BaseActivity {

//    @BindView(R.id.title_text)
    TextView title_text ;
//    @BindView(R.id.iv_search)
//    ImageView iv_search ;
//    @BindView(R.id.wv)
    WebView wv ;

    @Override
    public void initlayout() {

        setContentView(R.layout.activity_web_view);
        title_text= (TextView) findViewById(R.id.title_text);
        wv= (WebView) findViewById(R.id.wv);
    }

    @Override
    public void initview() {

        String name = getIntent().getStringExtra("name");
        String url = getIntent().getStringExtra("url");

        //设置沉浸式状态栏
        setStatus();
        //设置沉浸式状态栏背景
//        title_bar.setBackgroundResource(R.color.black_alpha_5);

        title_text.setText(name);

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }
        });
        wv.getSettings().setJavaScriptEnabled(true);

        wv.loadUrl(url);
    }
}
