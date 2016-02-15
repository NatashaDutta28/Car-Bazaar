package com.carbazaar.natasha.carbazaar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Natasha on 07-05-2015.
 */
public class Search_used extends ActionBarActivity {

    String[] Cars = {"Ciaz","Brio","Amaze","CR-V","City","R8", "A3", "Q3","TT","S-Class"};
    int[] carPrice = {4, 1, 3, 18, 7,19,23, 54,80};
    Integer[] audiCarImages = {R.drawable.ciaz,R.drawable.brio,R.drawable.amaze,R.drawable.crv,R.drawable.city,R.drawable.r8, R.drawable.a3, R.drawable.q3, R.drawable.tt,R.drawable.s};
    ArrayList<String> carNameArrayList = new ArrayList<>();
    ArrayList<Integer> carPriceArrayList = new ArrayList<>();
    ArrayList<Integer> carImageArrayList = new ArrayList<>();
    private ActionBar mActionBar;
    private Toolbar toolbar;
    private int minPrice,maxPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        minPrice = getIntent().getIntExtra("minRange",1);
        maxPrice = getIntent().getIntExtra("maxRange",100);
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
        mTitleTextView.setText("Search");
        getSupportActionBar().setCustomView(mCustomView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for (int i = 0; i < carPrice.length; i++) {
            if (carPrice[i]>=minPrice && carPrice[i]<=maxPrice){
                carNameArrayList.add(Cars[i]);
                carPriceArrayList.add(carPrice[i]);
                carImageArrayList.add(audiCarImages[i]);
            }

        }


        SearchAdapter carCompanyAdapter = new SearchAdapter(this, carNameArrayList, carImageArrayList, carPriceArrayList);

        ListView theListView = (ListView) findViewById(R.id.listView1);
        theListView.setAdapter(carCompanyAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String carPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(getApplicationContext(), carPicked, Toast.LENGTH_SHORT).show();
                String s = Cars[i];

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