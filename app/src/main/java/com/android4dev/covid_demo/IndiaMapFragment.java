package com.android4dev.covid_demo;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class IndiaMapFragment extends Fragment {

    private WebView mWebView;
    private ProgressBar progressBar;
    private String url="http://ec2-13-234-19-254.ap-south-1.compute.amazonaws.com:3000/map";
    private String url1="https://www.covid19india.org/";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate
                (R.layout.fragment_india_map,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mWebView=(WebView)view.findViewById(R.id.webview2);
        progressBar=(ProgressBar)view.findViewById(R.id.activity_main_pb_2);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted (WebView view,String url, Bitmap favicon)
            {
                showProgressBar(View.VISIBLE);
            }
            @Override
            public void onPageFinished (WebView view, String url)
            {
                showProgressBar(View.GONE);
            }
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // DO NOT CALL SUPER METHOD
                handler.proceed();
            }
        });
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.loadUrl(url);

    }
    public void showProgressBar(int visibilityMode) {

        progressBar.setVisibility(visibilityMode);

    }
}