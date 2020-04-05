package com.android4dev.covid_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class SelfAssessmentFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout relativeLayout;
    private TextInputLayout textInputLayout;
    private ScrollView scrollView;
    private LinearLayout genderOp,symptomsOp,conditionOp;
    private TextView genderQue,genderMale,genderFemale,genderOther,genderAns,ageQue,ageAns;
    private TextView symQue,symCough,symFever,symBreathe,symNone,symAns;
    private TextView condQue,condDB,condHT,condLD,condHD,condNone,condAns;
    private TextView appQue,appInt,appLive,appWork,appNone,appAns;
    private TextView sugg,next,leftNext;
    private TextInputEditText ageOp;
    private ImageView retry;
    private MainActivity mainActivity;
    private InputMethodManager imm;
    private static int sym=0,cond=0,app=0;
    public static int age;
    public static String sympt,condt,apps;

    @SuppressLint("ValidFragment")
    public SelfAssessmentFragment(MainActivity main)
    {
        this.mainActivity=main;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(
                R.layout.fragment_self_assess, container, false);

        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imm = (InputMethodManager) mainActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        textInputLayout=(TextInputLayout)view.findViewById(R.id.text_input_layout);
        relativeLayout=(RelativeLayout)view.findViewById(R.id.rel_layout);
        scrollView=(ScrollView)view.findViewById(R.id.scroll_view);
        retry=(ImageView)view.findViewById(R.id.retry);
        ageOp=(TextInputEditText)view.findViewById(R.id.age_option);
        genderOp=(LinearLayout)view.findViewById(R.id.gender_option);
        symptomsOp=(LinearLayout)view.findViewById(R.id.sym_options);
        conditionOp=(LinearLayout)view.findViewById(R.id.cond_options);
        genderQue=(TextView)view.findViewById(R.id.gender_que);
        genderMale=(TextView)view.findViewById(R.id.gen_male);
        genderFemale=(TextView)view.findViewById(R.id.gen_female);
        genderOther=(TextView)view.findViewById(R.id.gen_other);
        genderAns=(TextView)view.findViewById(R.id.gen_ans);
        ageQue=(TextView)view.findViewById(R.id.age_que);
        ageAns=(TextView)view.findViewById(R.id.age_ans);
        symQue=(TextView)view.findViewById(R.id.sym_que);
        symCough=(TextView)view.findViewById(R.id.sym_cough);
        symFever=(TextView)view.findViewById(R.id.sym_fever);
        symBreathe=(TextView)view.findViewById(R.id.sym_breathe);
        symNone=(TextView)view.findViewById(R.id.sym_none);
        symAns=(TextView)view.findViewById(R.id.sym_ans);
        condQue=(TextView)view.findViewById(R.id.cond_que);
        condDB=(TextView)view.findViewById(R.id.cond_db);
        condHT=(TextView)view.findViewById(R.id.cond_ht);
        condLD=(TextView)view.findViewById(R.id.cond_ld);
        condHD=(TextView)view.findViewById(R.id.cond_hd);
        condNone=(TextView)view.findViewById(R.id.cond_none);
        condAns=(TextView)view.findViewById(R.id.cond_ans);
        appQue=(TextView)view.findViewById(R.id.app_que);
        appInt=(TextView)view.findViewById(R.id.app_int);
        appLive=(TextView)view.findViewById(R.id.app_live);
        appWork=(TextView)view.findViewById(R.id.app_worker);
        appNone=(TextView)view.findViewById(R.id.app_none);
        appAns=(TextView)view.findViewById(R.id.app_ans);
        sugg=(TextView)view.findViewById(R.id.suggestion);
        next=(TextView)view.findViewById(R.id.next);
        leftNext=(TextView)view.findViewById(R.id.left_next);
        genderMale.setOnClickListener(this);
        genderFemale.setOnClickListener(this);
        genderOther.setOnClickListener(this);
        retry.setOnClickListener(this);
        next.setOnClickListener(this);
        symFever.setOnClickListener(this);
        symCough.setOnClickListener(this);
        symBreathe.setOnClickListener(this);
        symNone.setOnClickListener(this);
        condNone.setOnClickListener(this);
        condHD.setOnClickListener(this);
        condDB.setOnClickListener(this);
        condHT.setOnClickListener(this);
        condLD.setOnClickListener(this);
        appNone.setOnClickListener(this);
        appWork.setOnClickListener(this);
        appLive.setOnClickListener(this);
        appInt.setOnClickListener(this);
        leftNext.setOnClickListener(this);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.gen_male:
                genderOp.setVisibility(View.GONE);
                genderAns.setVisibility(View.VISIBLE);
                genderAns.setText("Male");
                textInputLayout.setVisibility(View.VISIBLE);
                ageQue.setVisibility(View.VISIBLE);
                ageOp.setVisibility(View.VISIBLE);
                ageOp.requestFocus();
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                next.setVisibility(View.VISIBLE);
                textInputLayout.setHintEnabled(false);
                break;
            case R.id.gen_female:
                genderOp.setVisibility(View.GONE);
                genderAns.setVisibility(View.VISIBLE);
                genderAns.setText("Female");
                ageQue.setVisibility(View.VISIBLE);
                ageOp.setVisibility(View.VISIBLE);
                textInputLayout.setVisibility(View.VISIBLE);
                ageOp.requestFocus();
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                next.setVisibility(View.VISIBLE);
                textInputLayout.setHintEnabled(false);
                break;
            case R.id.gen_other:
                genderOp.setVisibility(View.GONE);
                genderAns.setVisibility(View.VISIBLE);
                genderAns.setText("Other");
                ageQue.setVisibility(View.VISIBLE);
                textInputLayout.setVisibility(View.VISIBLE);
                ageOp.setVisibility(View.VISIBLE);
                ageOp.requestFocus();
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                next.setVisibility(View.VISIBLE);
                textInputLayout.setHintEnabled(false);
                break;
            case R.id.sym_cough:
                if(symCough.getCurrentTextColor()==getResources().getColor(R.color.PrimaryDarkColor))
                {
                    symCough.setBackgroundColor(getResources().getColor(R.color.PrimaryDarkColor));
                    symCough.setTextColor(getResources().getColor(R.color.ans_color));
                    sym++;
                }else{
                    symCough.setBackgroundColor(getResources().getColor(R.color.ans_color));
                    symCough.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
                    sym--;
                }
                if(sym==0)
                {
                    symNone.setVisibility(View.VISIBLE);
                    leftNext.setVisibility(View.GONE);
                }else{
                    symNone.setVisibility(View.GONE);
                    leftNext.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.sym_fever:
                if(symFever.getCurrentTextColor()==getResources().getColor(R.color.PrimaryDarkColor))
                {
                    symFever.setBackgroundColor(getResources().getColor(R.color.PrimaryDarkColor));
                    symFever.setTextColor(getResources().getColor(R.color.ans_color));
                    sym++;
                }else{
                    symFever.setBackgroundColor(getResources().getColor(R.color.ans_color));
                    symFever.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
                    sym--;
                }
                if(sym==0)
                {
                    symNone.setVisibility(View.VISIBLE);
                    leftNext.setVisibility(View.GONE);
                }else{
                    symNone.setVisibility(View.GONE);
                    leftNext.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.sym_breathe:
                if(symBreathe.getCurrentTextColor()==getResources().getColor(R.color.PrimaryDarkColor))
                {
                    symBreathe.setBackgroundColor(getResources().getColor(R.color.PrimaryDarkColor));
                    symBreathe.setTextColor(getResources().getColor(R.color.ans_color));
                    sym++;
                }else{
                    symBreathe.setBackgroundColor(getResources().getColor(R.color.ans_color));
                    symBreathe.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
                    sym--;
                }
                if(sym==0)
                {
                    symNone.setVisibility(View.VISIBLE);
                    leftNext.setVisibility(View.GONE);
                }else{
                    symNone.setVisibility(View.GONE);
                    leftNext.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.sym_none:
                symptomsOp.setVisibility(View.GONE);
                symNone.setVisibility(View.GONE);
                symAns.setText("None of the Above");
                symAns.setVisibility(View.VISIBLE);
                condQue.setVisibility(View.VISIBLE);
                conditionOp.setVisibility(View.VISIBLE);
                condHD.setVisibility(View.VISIBLE);
                condNone.setVisibility(View.VISIBLE);
                sym=0;
                break;
            case R.id.cond_db:
                if(condDB.getCurrentTextColor()==getResources().getColor(R.color.PrimaryDarkColor))
                {
                    condDB.setBackgroundColor(getResources().getColor(R.color.PrimaryDarkColor));
                    condDB.setTextColor(getResources().getColor(R.color.ans_color));
                    cond++;
                }else{
                    condDB.setBackgroundColor(getResources().getColor(R.color.ans_color));
                    condDB.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
                    cond--;
                }
                if(cond==0)
                {
                    condNone.setVisibility(View.VISIBLE);
                    leftNext.setVisibility(View.GONE);
                }else{
                    condNone.setVisibility(View.GONE);
                    leftNext.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.cond_ht:
                if(condHT.getCurrentTextColor()==getResources().getColor(R.color.PrimaryDarkColor))
                {
                    condHT.setBackgroundColor(getResources().getColor(R.color.PrimaryDarkColor));
                    condHT.setTextColor(getResources().getColor(R.color.ans_color));
                    cond++;
                }else{
                    condHT.setBackgroundColor(getResources().getColor(R.color.ans_color));
                    condHT.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
                    cond--;
                }
                if(cond==0)
                {
                    condNone.setVisibility(View.VISIBLE);
                    leftNext.setVisibility(View.GONE);
                }else{
                    condNone.setVisibility(View.GONE);
                    leftNext.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.cond_ld:
                if(condLD.getCurrentTextColor()==getResources().getColor(R.color.PrimaryDarkColor))
                {
                    condLD.setBackgroundColor(getResources().getColor(R.color.PrimaryDarkColor));
                    condLD.setTextColor(getResources().getColor(R.color.ans_color));
                    cond++;
                }else{
                    condLD.setBackgroundColor(getResources().getColor(R.color.ans_color));
                    condLD.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
                    cond--;
                }
                if(cond==0)
                {
                    condNone.setVisibility(View.VISIBLE);
                    leftNext.setVisibility(View.GONE);
                }else{
                    condNone.setVisibility(View.GONE);
                    leftNext.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.cond_hd:
                if(condHD.getCurrentTextColor()==getResources().getColor(R.color.PrimaryDarkColor))
                {
                    condHD.setBackgroundColor(getResources().getColor(R.color.PrimaryDarkColor));
                    condHD.setTextColor(getResources().getColor(R.color.ans_color));
                    cond++;
                }else{
                    condHD.setBackgroundColor(getResources().getColor(R.color.ans_color));
                    condHD.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
                    cond--;
                }
                if(cond==0)
                {
                    condNone.setVisibility(View.VISIBLE);
                    leftNext.setVisibility(View.GONE);
                }else{
                    condNone.setVisibility(View.GONE);
                    leftNext.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.cond_none:
                conditionOp.setVisibility(View.GONE);
                condHD.setVisibility(View.GONE);
                condNone.setVisibility(View.GONE);
                condAns.setText("None of the Above");
                condAns.setVisibility(View.VISIBLE);
                appQue.setVisibility(View.VISIBLE);
                appInt.setVisibility(View.VISIBLE);
                appLive.setVisibility(View.VISIBLE);
                appWork.setVisibility(View.VISIBLE);
                appNone.setVisibility(View.VISIBLE);
                cond=0;
                break;
            case R.id.app_int:
                appAns.setText("Traveled internationally in the last 14 days");
                apps="International";
                app++;
                appAns.setVisibility(View.VISIBLE);
                appNone.setVisibility(View.GONE);
                appWork.setVisibility(View.GONE);
                appLive.setVisibility(View.GONE);
                appInt.setVisibility(View.GONE);
                sugg.setText(getSuggestion());
                sugg.setVisibility(View.VISIBLE);
                scrollView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //replace this line to scroll up or down
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                }, 100L);
                break;
            case R.id.app_live:
                appAns.setText("Recently interacted or lived or currently live with someone who has tested positive for COVID-19");
                apps="Interaction";
                app++;
                appAns.setVisibility(View.VISIBLE);
                appNone.setVisibility(View.GONE);
                appWork.setVisibility(View.GONE);
                appLive.setVisibility(View.GONE);
                appInt.setVisibility(View.GONE);
                sugg.setText(getSuggestion());
                sugg.setVisibility(View.VISIBLE);
                scrollView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //replace this line to scroll up or down
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                }, 100L);
                break;
            case R.id.app_worker:
                appAns.setText("Am a healthcare worker");
                apps="Worker";
                app++;
                appAns.setVisibility(View.VISIBLE);
                appNone.setVisibility(View.GONE);
                appWork.setVisibility(View.GONE);
                appLive.setVisibility(View.GONE);
                appInt.setVisibility(View.GONE);
                sugg.setText(getSuggestion());
                sugg.setVisibility(View.VISIBLE);
                scrollView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //replace this line to scroll up or down
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                }, 100L);
                break;
            case R.id.app_none:
                appAns.setText("None of the above");
                apps="None";
                app=0;
                appAns.setVisibility(View.VISIBLE);
                appNone.setVisibility(View.GONE);
                appWork.setVisibility(View.GONE);
                appLive.setVisibility(View.GONE);
                appInt.setVisibility(View.GONE);
                sugg.setText(getSuggestion());
                sugg.setVisibility(View.VISIBLE);
                scrollView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //replace this line to scroll up or down
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                }, 100L);
                break;
            case R.id.left_next:
                if(cond==0)
                {
                    sympt="";
                    if(symCough.getCurrentTextColor()==getResources().getColor(R.color.ans_color))
                        sympt=sympt+" Cough ,";
                    if(symFever.getCurrentTextColor()==getResources().getColor(R.color.ans_color))
                        sympt=sympt+" Fever ,";
                    if(symBreathe.getCurrentTextColor()==getResources().getColor(R.color.ans_color))
                        sympt=sympt+" Difficulty in Breathing ";
                    //Log.d("self_assess",sympt.charAt(sympt.length()-1)+"");
                    if(sympt.charAt(sympt.length()-1)==',')
                    {
                        sympt=sympt.substring(0,sympt.length()-1);
                    }
                    symptomsOp.setVisibility(View.GONE);
                    symNone.setVisibility(View.GONE);
                    symAns.setText(sympt);
                    symAns.setVisibility(View.VISIBLE);
                    condQue.setVisibility(View.VISIBLE);
                    conditionOp.setVisibility(View.VISIBLE);
                    condHD.setVisibility(View.VISIBLE);
                    condNone.setVisibility(View.VISIBLE);
                }else if(cond!=0&&app==0)
                {
                    condt="";
                    if(condDB.getCurrentTextColor()==getResources().getColor(R.color.ans_color))
                        condt=condt+" Diabetes ,";
                    if(condHT.getCurrentTextColor()==getResources().getColor(R.color.ans_color))
                        condt=condt+" Hypertension ,";
                    if(condLD.getCurrentTextColor()==getResources().getColor(R.color.ans_color))
                        condt=condt+" Lung disease ,";
                    if(condHD.getCurrentTextColor()==getResources().getColor(R.color.ans_color))
                        condt=condt+" Heart Disease ";
                    if(condt.charAt(condt.length()-1)==',')
                    {
                        condt=condt.substring(0,condt.length()-1);
                    }
                    conditionOp.setVisibility(View.GONE);
                    condHD.setVisibility(View.GONE);
                    condNone.setVisibility(View.GONE);
                    condAns.setText(condt);
                    condAns.setVisibility(View.VISIBLE);
                    appQue.setVisibility(View.VISIBLE);
                    appInt.setVisibility(View.VISIBLE);
                    appLive.setVisibility(View.VISIBLE);
                    appWork.setVisibility(View.VISIBLE);
                    appNone.setVisibility(View.VISIBLE);
                    //scrollView.scrollTo(View.SCROLL_INDICATOR_BOTTOM,View.S);
                }


                leftNext.setVisibility(View.GONE);
                break;
            case R.id.next:
                 String ag= String.valueOf(ageOp.getText());
                 age=Integer.parseInt(ag);
                 if(!(age>0&&age<=100))
                 {
                        textInputLayout.setError(" ! Value must be less than or equal to 100.");
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                         ageOp.setBackground(getResources().getDrawable(R.drawable.sa_ans_bkg));
                     }
                 }else {
                     textInputLayout.setVisibility(View.GONE);
                     next.setVisibility(View.GONE);
                     ageAns.setText(ag);
                     ageAns.setVisibility(View.VISIBLE);
                     symQue.setVisibility(View.VISIBLE);
                     symptomsOp.setVisibility(View.VISIBLE);
                     symNone.setVisibility(View.VISIBLE);
                     imm.toggleSoftInput(InputMethodManager.RESULT_HIDDEN, 0);
                     textInputLayout.setHintEnabled(false);
                     textInputLayout.setError("");
                 }
                break;
            case R.id.retry:
                genderOp.setVisibility(View.VISIBLE);
                genderAns.setVisibility(View.GONE);
                ageQue.setVisibility(View.GONE);
                ageOp.setVisibility(View.GONE);
                ageAns.setVisibility(View.GONE);
                symAns.setVisibility(View.GONE);
                symQue.setVisibility(View.GONE);
                symptomsOp.setVisibility(View.GONE);
                symNone.setVisibility(View.GONE);
                condQue.setVisibility(View.GONE);
                condAns.setVisibility(View.GONE);
                conditionOp.setVisibility(View.GONE);
                condHD.setVisibility(View.GONE);
                condNone.setVisibility(View.GONE);
                appQue.setVisibility(View.GONE);
                appAns.setVisibility(View.GONE);
                appInt.setVisibility(View.GONE);
                appLive.setVisibility(View.GONE);
                appWork.setVisibility(View.GONE);
                appNone.setVisibility(View.GONE);
                sugg.setVisibility(View.GONE);
                leftNext.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                textInputLayout.setVisibility(View.GONE);
                textInputLayout.setError("");
                textInputLayout.setHintEnabled(false);
                scrollView.scrollTo(0,0);
                sym=0;
                cond=0;
                app=0;
                sympt="";
                condt="";
                apps="";
                reset();
                break;
                default:
                    break;
        }
    }
    public String getSuggestion()
    {
        Log.d("suggest",sym+","+cond+","+app+"\n");
        if(sym>0&&cond>0&&app>0)
        {
            mainActivity.setP(3);
            return getResources().getString(R.string.sugg_high);
        }
        else if(app>0)
        {
            mainActivity.setP(2);
            return getResources().getString(R.string.sugg_moderate);
        }else if(app==0&&(sym>0||cond>0)) {
            mainActivity.setP(1);
            return getResources().getString(R.string.sugg_low_2);
        }
        mainActivity.setP(1);
        return getResources().getString(R.string.sugg_low_1);
    }
    public void reset()
    {
        ageOp.setText("");
        ageOp.setHint("Please type your age.");
        symCough.setBackgroundColor(getResources().getColor(R.color.ans_color));
        symCough.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        symFever.setBackgroundColor(getResources().getColor(R.color.ans_color));
        symFever.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        symBreathe.setBackgroundColor(getResources().getColor(R.color.ans_color));
        symBreathe.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        symNone.setBackgroundColor(getResources().getColor(R.color.ans_color));
        symNone.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        condNone.setBackgroundColor(getResources().getColor(R.color.ans_color));
        condNone.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        condLD.setBackgroundColor(getResources().getColor(R.color.ans_color));
        condLD.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        condHT.setBackgroundColor(getResources().getColor(R.color.ans_color));
        condHT.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        condDB.setBackgroundColor(getResources().getColor(R.color.ans_color));
        condDB.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        condHD.setBackgroundColor(getResources().getColor(R.color.ans_color));
        condHD.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        appLive.setBackgroundColor(getResources().getColor(R.color.ans_color));
        appLive.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        appInt.setBackgroundColor(getResources().getColor(R.color.ans_color));
        appInt.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        appWork.setBackgroundColor(getResources().getColor(R.color.ans_color));
        appWork.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));
        appNone.setBackgroundColor(getResources().getColor(R.color.ans_color));
        appNone.setTextColor(getResources().getColor(R.color.PrimaryDarkColor));

    }
}
