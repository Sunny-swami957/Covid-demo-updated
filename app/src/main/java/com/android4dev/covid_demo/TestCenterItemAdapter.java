package com.android4dev.covid_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestCenterItemAdapter extends
        RecyclerView.Adapter<TestCenterItemAdapter.ViewHolder>{
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView cTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            cTextView = (TextView) itemView.findViewById(R.id.tcitem1);
        }
    }

    private List<String> mCenters;

    // Pass in the contact array into the constructor
    public TestCenterItemAdapter(List<String> c) {
        this.mCenters=c;
    }
    @Override
    public TestCenterItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.test_center_items_adapter, parent, false);

        // Return a new holder instance
        TestCenterItemAdapter.ViewHolder viewHolder = new TestCenterItemAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final TestCenterItemAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        String state=mCenters.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.cTextView;
        textView.setText(state);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mCenters.size();
    }
}
