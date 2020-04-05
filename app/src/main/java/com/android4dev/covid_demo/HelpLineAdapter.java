package com.android4dev.covid_demo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HelpLineAdapter extends
        RecyclerView.Adapter<HelpLineAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView stateTextView;
        public TextView contactTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            stateTextView = (TextView) itemView.findViewById(R.id.state_tv);
            contactTextView = (TextView) itemView.findViewById(R.id.contact_tv);
        }
    }

    private ArrayList<String> mStates;
    private ArrayList<String> mContacts;
    private MainActivity mainActivity;

    // Pass in the contact array into the constructor
    public HelpLineAdapter(ArrayList<String> states,ArrayList<String> contacts,MainActivity m) {
        this.mStates=states;
        this.mContacts = contacts;
        this.mainActivity=m;
    }
    @Override
    public HelpLineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.help_line_adapter_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final HelpLineAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        String state=mStates.get(position);
        final String contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.stateTextView;
        textView.setText(state);
        TextView textView1= viewHolder.contactTextView;
        textView1.setText(contact);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mainActivity.callNumber(contact);
            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mStates.size();
    }
}
