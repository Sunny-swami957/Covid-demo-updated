package com.android4dev.covid_demo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestCenterAdapter extends
        RecyclerView.Adapter<TestCenterAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView stateTextView;
        public TextView tcTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            stateTextView = (TextView) itemView.findViewById(R.id.state_tv_tc);
            tcTextView = (TextView) itemView.findViewById(R.id.tc_rview_item);
        }
    }

    private ArrayList<String> mStates;
    private ArrayList<String> mCenters;

    // Pass in the contact array into the constructor
    public TestCenterAdapter(ArrayList<String> states,ArrayList<String> contacts) {
        this.mStates=states;
        this.mCenters = contacts;
    }
    @Override
    public TestCenterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.test_center_adapter_item, parent, false);

        // Return a new holder instance
        TestCenterAdapter.ViewHolder viewHolder = new TestCenterAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final TestCenterAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        String state=mStates.get(position);
        String center = mCenters.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.stateTextView;
        textView.setText(state);
        TextView textView1= viewHolder.tcTextView;
        textView1.setText(center);
        //TestCenterItemAdapter adapter = new TestCenterItemAdapter(centers);
        // Attach the adapter to the recyclerview to populate items
        //textView1.setAdapter(adapter);
        // Set layout manager to position the items
        //textView1.setLayoutManager(new LinearLayoutManager(viewHolder.itemView.getContext()));

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mStates.size();
    }
}
