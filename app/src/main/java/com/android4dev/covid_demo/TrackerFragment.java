package com.android4dev.covid_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import im.delight.android.webview.AdvancedWebView;

/**
 * Created by Admin on 04-06-2015.
 */
public class TrackerFragment extends Fragment {

    private WebView mWebView;
    private ProgressBar progressBar;
    private String url="http://ec2-13-234-19-254.ap-south-1.compute.amazonaws.com:3000/";
    private String url1="https://www.covid19india.org/";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate
                (R.layout.fragment_tracker,container,false);
        return v;
    }

    @SuppressLint("JavascriptInterface")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mWebView=(WebView)view.findViewById(R.id.webview);
        progressBar=(ProgressBar)view.findViewById(R.id.activity_main_pb);
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
