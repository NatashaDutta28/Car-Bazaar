package com.carbazaar.natasha.carbazaar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Natasha on 5/9/2015.
 */
public class MercedesBenz extends ActionBarActivity {
    private Toolbar toolbar;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audi);
        final String[] mercedesCars = {"S-Class"};//Please place mercedes car name
        final Integer[] mercedesCarImages = {R.drawable.s};
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
        mTitleTextView.setText("Audi");
        getSupportActionBar().setCustomView(mCustomView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        CarCompanyAdapter carCompanyAdapter = new CarCompanyAdapter(this, mercedesCars, mercedesCarImages);

        ListView theListView = (ListView) findViewById(R.id.listView1);
        theListView.setAdapter(carCompanyAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String carPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(getApplicationContext(), carPicked, Toast.LENGTH_SHORT).show();
                String s = mercedesCars[i];


                //Class myClass = Class.forName("com.carbazaar.natasha.carbazaar." + s);
                if (s.equalsIgnoreCase("C class")) {
                    Intent myIntent = new Intent(getApplicationContext(), Mercedes_C.class);
                    startActivity(myIntent);
                }


            }
        });
    }
}