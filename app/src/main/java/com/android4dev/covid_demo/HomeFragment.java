package com.android4dev.covid_demo;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by KUNAL on 9/9/2016.
 */
@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

    private TextView ddTextView,smTextView,lmTextView;
    private LinearLayout SALayout,HLLayout,TCLayout;
    private MainActivity mainActivity;

    @SuppressLint("ValidFragment")
    public HomeFragment(MainActivity m)
    {
        this.mainActivity=m;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(
                R.layout.frament_home, container, false);

        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ddTextView=(TextView)view.findViewById(R.id.dd_info);
        smTextView=(TextView)view.findViewById(R.id.sm_info);
        lmTextView=(TextView)view.findViewById(R.id.lm_info);
        SALayout=(LinearLayout)view.findViewById(R.id.self_ass);
        HLLayout=(LinearLayout)view.findViewById(R.id.hrlp_line);
        TCLayout=(LinearLayout)view.findViewById(R.id.test_center);
        ddTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.mohfw.gov.in/pdf/Poster_Corona_ad_Eng.pdf"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        smTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.mohfw.gov.in/pdf/ProtectivemeasuresEng.pdf"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        lmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.mohfw.gov.in/pdf/FAQ.pdf"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        SALayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.loadfragment(v);
            }
        });
        HLLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.loadfragment(v);
            }
        });
        TCLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.loadfragment(v);
            }
        });
    }
}