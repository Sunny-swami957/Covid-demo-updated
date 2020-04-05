package com.android4dev.covid_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private AdvancedWebView mWebView;
    private String mHtmlString1,mHtmlString2,mHtmlString3;
    private ProgressBar progressBar;
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
        mWebView=(AdvancedWebView)view.findViewById(R.id.webview);
        progressBar=(ProgressBar)view.findViewById(R.id.activity_main_pb);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient(this));
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.loadUrl("https://www.covid19india.org/");

    }

    public void showProgressBar(int visibilityMode) {

        progressBar.setVisibility(visibilityMode);

    }
}
