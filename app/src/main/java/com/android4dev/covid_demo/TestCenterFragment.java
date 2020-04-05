package com.android4dev.covid_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestCenterFragment extends Fragment {
    ArrayList<String> states=new ArrayList<String>(
            Arrays.asList("Andhra Pradesh","Andaman and NicobarIslands","Assam","Bihar","Chandigarh","Chattisgarh","Delhi-NCR","Gujrat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Meghalaya","Maharashtra","Manipur","Odisha","Puducherry","Punjab","Rajasthan","Tamil Nadu","Tripura","Telangana","Uttar Pradesh","Uttarakhand","West Bengal"));
            ArrayList<String> centers=new ArrayList<String>(

             Arrays.asList("Sri Venkateswara Institute of Medical Sciences, Tirupati"
            ,"Regional Medical Research Centre, Port Blair, Andaman and Nicobar"
            ,"Gauhati Medical College, Guwahati"
            ,"Rajendra Memorial Research Institute of Medical Sciences, Patna"
            ,"Post Graduate Institute of Medical Education & Research, Chandigarh"
            ,"All India Institute Medical Sciences, Raipur"
            ,"All India Institute Medical Sciences, Delhi"
            ,"BJ Medical College, Ahmedabad"
            ,"Pt. B.D. Sharma Post Graduate Inst. of Med. Sciences, Rohtak, Haryana"
            ,"Indira Gandhi Medical College, Shimla, Himachal Pradesh"
            ,"Sher‐e‐Kashmir Institute of Medical Sciences, Srinagar"
            ,"MGM Medical College, Jamshedpur"
            ,"Bangalore Medical College & Research Institute, Bangalore"
            ,"National Institute of Virology Field Unit, Kerala"
            ,"All India Institute Medical Sciences, Bhopal"
            ,"NEIGRI of Health and Medical Sciences, Shillong, Meghalaya"
            ,"Indira Gandhi Government Medical College, Nagpur"
            ,"J N Inst. of Med. Sciences Hospital, Imphal‐East, Manipur"
            ,"Regional Medical Research Center, Bhubaneswar"
            ,"Jawaharlal Institute of Postgraduate Medical Education & Research, Puducherry"
            ,"Government Medical College, Patiala, Punjab"
            ,"Sawai Man Singh, Jaipur"
            ,"King’s Institute of Preventive Medicine & Research, Chennai"
            ,"Government Medical College, Agartala"
            ,"Gandhi Medical College, Secunderabad"
            ,"King’s George Medical University, Lucknow"
            ,"Government Medical College, Haldwani"
            ,"National Institute of Cholera and Enteric Diseases, Kolkata"
             ));

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(
                R.layout.fragment_test_center, container, false);

        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvContacts = (RecyclerView) view.findViewById(R.id.tc_rview);
        // Create adapter passing in the sample user data
        TestCenterAdapter adapter = new TestCenterAdapter(states,centers);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
