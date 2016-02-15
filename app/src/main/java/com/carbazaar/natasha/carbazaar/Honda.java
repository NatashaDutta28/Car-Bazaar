package com.carbazaar.natasha.carbazaar;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Honda extends ActionBarActivity {

    private Toolbar toolbar;private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audi);
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
        mTitleTextView.setText("Honda");
        getSupportActionBar().setCustomView(mCustomView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final String[] hondaCars = {"Brio","Amaze","CR-V","City"};
        final Integer[] hondaCarImages = {R.drawable.brio,R.drawable.amaze,R.drawable.crv,R.drawable.city};

        CarCompanyAdapter carCompanyAdapter = new CarCompanyAdapter(this, hondaCars,hondaCarImages);

        ListView theListView = (ListView) findViewById(R.id.listView1);
        theListView.setAdapter(carCompanyAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String carPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(getApplicationContext(), carPicked, Toast.LENGTH_SHORT).show();
                String s = hondaCars[i];

                try {
                    Class myClass = Class.forName("com.carbazaar.natasha.carbazaar." + s);
                    Intent myIntent = new Intent(getApplicationContext(), myClass);
                    startActivity(myIntent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}