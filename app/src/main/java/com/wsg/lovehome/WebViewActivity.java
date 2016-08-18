package com.wsg.lovehome;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wsg.lovehome.base.BaseActivity;
import com.zgh.stylelib.style.StyleHelper;


public class WebViewActivity extends BaseActivity {
    WebView webview;


    @Override
    public void initInjector() {

    }

    @Override
    protected boolean isEnableSwipBack() {
        return true;
    }


    @Override
    public int bindLayout() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initView(View view) {
        findViewById(R.id.btn_baidu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StyleHelper.changeStyle(0, 1);
            }
        });
        findViewById(R.id.btn_wangyi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StyleHelper.changeStyle(0, 2);
            }
        });
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                StyleHelper.setupWebView(view);
            }
        });
        webview.setBackgroundColor(0);
        webview.loadUrl("http://www.baidu.com");
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
