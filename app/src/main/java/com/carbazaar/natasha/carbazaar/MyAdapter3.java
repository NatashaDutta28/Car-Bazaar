package com.carbazaar.natasha.carbazaar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// We can create custom adapters
class MyAdapter3 extends ArrayAdapter<String> {

    public MyAdapter3(Context context, String[] values){

        super(context, R.layout.layout_row1, values);

    }

    // Override getView which is responsible for creating the rows for our list
    // position represents the index we are in for the array.

    // convertView is a reference to the previous view that is available for reuse. As
    // the user scrolls the information is populated as needed to conserve memory.

    // A ViewGroup are invisible containers that hold a bunch of views and
    // define their layout properties.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // The LayoutInflator puts a layout into the right View
        LayoutInflater theInflater = LayoutInflater.from(getContext());

        // inflate takes the resource to load, the parent that the resource may be
        // loaded into and true or false if we are loading into a parent view.
        View theView = theInflater.inflate(R.layout.layout_row1, parent, false);

        // We retrieve the text from the array
        String cars = getItem(position);

        // Get the TextView we want to edit
        TextView theTextView = (TextView) theView.findViewById(R.id.tvCity);

        // Put the next TV Show into the TextView
        theTextView.setText(cars);

        // Get the ImageView in the layout
        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView1);

        // We can set a ImageView like this
        //theImageView.setImageResource(R.drawable.logo_audi);


        return theView;

    }
}