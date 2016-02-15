package com.carbazaar.natasha.carbazaar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Natasha on 5/9/2015.
 */
public class DealerInfo extends ActionBarActivity {
    private TextView nameTextView, numberTextView, emailaddressTextView;
    private ActionBar mActionBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the layout you want to show
        setContentView(R.layout.dealer_info);

        //fetching name, mobile and email
        String name  = getIntent().getStringExtra("Name");// fetching name through the key which was used to pass the name value;
        String mobile  = getIntent().getStringExtra("Mobile");
                String email  = getIntent().getStringExtra("Email");
        // now initialize all the views you have created in the xml file
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);

        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#972D07")));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.custom_header_activity,
                null);
        TextView mTitleTextView = (TextView) mCustomView
                .findViewById(R.id.title_text);
        ImageView back = (ImageView) mCustomView
                .findViewById(R.id.back);
        ImageView calculator = (ImageView) mCustomView
                .findViewById(R.id.calculator);
        calculator.setVisibility(View.GONE);
        mTitleTextView.setText("Dealer");
        getSupportActionBar().setCustomView(mCustomView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        nameTextView = (TextView) findViewById(R.id.dealerName);
        numberTextView = (TextView) findViewById(R.id.dealerNumber);
        emailaddressTextView = (TextView) findViewById(R.id.DealerEmail);

        nameTextView.setText("Dealer's Name:- "+name);
        numberTextView.setText("Dealer's Mobile:- "+mobile);
        emailaddressTextView.setText("Dealer's Email Address:- "+email);

    }
}