package com.symboljoyful.morse.ui.component;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.symboljoyful.morse.base.BaseActivity;
import com.symboljoyful.morse.databinding.ActivityWebViewBinding;

public class WebViewActivity extends BaseActivity {
    private WebView webView;
    private ActivityWebViewBinding mBinding;
    public static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityWebViewBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        init();
        webView.loadUrl(url);

    }
    private void init() {

        webView = findViewById(mBinding.webView.getId());

        webView.setWebViewClient(new WebViewClient(){
            //覆写shouldOverrideUrlLoading实现内部显示网页
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO 自动生成的方法存根
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);//设置webView支持javascript脚本
        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO 自动生成的方法存根

                if(newProgress==100){
                    mBinding.progressBar.setVisibility(View.GONE);//加载完网页进度条消失
                }
                else{
                    mBinding.progressBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    mBinding.progressBar.setProgress(newProgress);//设置进度值
                }

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                mBinding.title.setText(title);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //清除记录
        if (webView != null) {
            webView.clearCache(true);
            webView.clearHistory();
            webView.clearFormData();
            webView.destroy();
        }
    }

    //设置返回键动作（防止按返回键直接退出程序)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO 自动生成的方法存根
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            if(webView.canGoBack()) {  //当webView不是处于第一页面时，返回上一个页面
                webView.goBack();
                return true;
            }
            else {  //当webView处于第一页面时,直接退出程序
                System.exit(0);
            }


        }
        return super.onKeyDown(keyCode, event);
    }

}