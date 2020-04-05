package com.android4dev.covid_demo;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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
    private TextView h1TextView,h2TextView,h3TextView,h4TextView,h5TextView;
    private LinearLayout SALayout,HLLayout,TCLayout,safetyLayout,isolateLayout1,isolateLayout2,isolateLayout;
    private MainActivity mainActivity;
    private int pk;
    @SuppressLint("ValidFragment")
    public HomeFragment(MainActivity m,int p)
    {
        this.mainActivity=m;
        this.pk=p;

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
        safetyLayout=(LinearLayout)view.findViewById(R.id.safety_layout);
        isolateLayout=(LinearLayout)view.findViewById(R.id.safety_protocol);
        isolateLayout1=(LinearLayout)view.findViewById(R.id.sp_2);
        isolateLayout2=(LinearLayout)view.findViewById(R.id.sp_3);
        h1TextView=(TextView)view.findViewById(R.id.sb_1);
        h2TextView=(TextView)view.findViewById(R.id.sb_2);
        h3TextView=(TextView)view.findViewById(R.id.sb_4);
        h4TextView=(TextView)view.findViewById(R.id.sb_5);
        h5TextView=(TextView)view.findViewById(R.id.sp_1);
        ddTextView=(TextView)view.findViewById(R.id.dd_info);
        smTextView=(TextView)view.findViewById(R.id.sm_info);
        lmTextView=(TextView)view.findViewById(R.id.lm_info);
        SALayout=(LinearLayout)view.findViewById(R.id.self_ass);
        HLLayout=(LinearLayout)view.findViewById(R.id.hrlp_line);
        TCLayout=(LinearLayout)view.findViewById(R.id.test_center);
        setPage(pk);
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
    public void setPage(int p)
    {
        switch (p)
        {
            case 0:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    safetyLayout.setBackground(getResources().getDrawable(R.drawable.safety_bkg));
                }
                h1TextView.setText(getResources().getString(R.string.safety_h1));
                h2TextView.setText(getResources().getString(R.string.safety_h2));
                h3TextView.setText(getResources().getString(R.string.safety_h3_low));
                h5TextView.setVisibility(View.VISIBLE);
                h5TextView.setText("Be prepared but don't panic");
                h4TextView.setText(getResources().getString(R.string.safety_h5_low));
                isolateLayout.setVisibility(View.GONE);

                break;
            case 1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    safetyLayout.setBackground(getResources().getDrawable(R.drawable.helpline_bkg));
                }
                h1TextView.setText(getResources().getString(R.string.safety_h1_low));
                h2TextView.setText(getResources().getString(R.string.safety_h2_low));
                h3TextView.setText(getResources().getString(R.string.safety_h3_low));
                h4TextView.setText(getResources().getString(R.string.safety_h4_low));
                isolateLayout.setVisibility(View.GONE);
                h5TextView.setVisibility(View.VISIBLE);
                h5TextView.setText("Be prepared but don't panic");
                h4TextView.setText(getResources().getString(R.string.safety_h4_low));
                break;
            case 2:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    safetyLayout.setBackground(getResources().getDrawable(R.drawable.safety_bkg_mod));
                }
                h1TextView.setText(getResources().getString(R.string.safety_h1_mod));
                h2TextView.setText(getResources().getString(R.string.safety_h2_mod));
                h3TextView.setText(getResources().getString(R.string.safety_h3_mod));
                h4TextView.setText("In case of any symptoms of fever or shortness of breath please consult a doctor");
                h5TextView.setVisibility(View.VISIBLE);
                h5TextView.setText("Safety protocols to follow");
                isolateLayout.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    isolateLayout1.setBackground(getResources().getDrawable(R.drawable.safety_bkg_mod));
                    isolateLayout2.setBackground(getResources().getDrawable(R.drawable.safety_bkg_mod));
                }
                break;
            case 3:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    safetyLayout.setBackground(getResources().getDrawable(R.drawable.testcenter_bkg));
                }
                h1TextView.setText(getResources().getString(R.string.safety_h1_high));
                h2TextView.setText(getResources().getString(R.string.safety_h2_high));
                h3TextView.setText(getResources().getString(R.string.safety_h3_high));
                h4TextView.setText(getResources().getString(R.string.safety_h4_high));
                h5TextView.setVisibility(View.GONE);
                isolateLayout.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    isolateLayout1.setBackground(getResources().getDrawable(R.drawable.testcenter_bkg));
                    isolateLayout2.setBackground(getResources().getDrawable(R.drawable.testcenter_bkg));
                }
                break;
            default:
                break;
        }
    }
}