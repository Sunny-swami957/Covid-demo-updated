package com.android4dev.covid_demo;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    private TrackerFragment trackerFragment;

    MyWebViewClient(TrackerFragment mainActivity) {
        trackerFragment = mainActivity;
    }


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        trackerFragment.showProgressBar(View.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        trackerFragment.showProgressBar(View.GONE);
    }
}
