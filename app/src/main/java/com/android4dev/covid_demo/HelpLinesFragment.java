package com.android4dev.covid_demo;

import android.annotation.SuppressLint;
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

@SuppressLint("ValidFragment")
public class HelpLinesFragment extends Fragment {

    ArrayList<String> contacts=new ArrayList<String>(
            Arrays.asList("0866-2410978","9436055743","6913347770","104","104","104","104","8558893911","104","104","104","0471-2552056","104","020-26127394","3852411668","108","102","7005539653","9439994859","104","0141-2225624","104","044-29510500","104","0381-2315879","104","18001805145","03323412600","03192-232102","9779558282","104","011-22307145","01912520982","01982256462","104","104","+91-11-23978046"));
    ArrayList<String> states=new ArrayList<String>(
            Arrays.asList("Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chattisgarh","Goa","Gujrat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal","Andaman and NicobarIslands","Chandigarh","Dadra and Nagar Haveli and Daman & Diu","Delhi","Jammu & Kashmir","Ladakh","Lakshadweep","Puducherry","Central"));

    private MainActivity mainActivity;

    @SuppressLint("ValidFragment")
    public HelpLinesFragment(MainActivity m)
    {
        this.mainActivity=m;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(
                R.layout.fragment_help_lines, container, false);

        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvContacts = (RecyclerView) view.findViewById(R.id.hl_rview);
        // Create adapter passing in the sample user data
        HelpLineAdapter adapter = new HelpLineAdapter(states,contacts,mainActivity);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
