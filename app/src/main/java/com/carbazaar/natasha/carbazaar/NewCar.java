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

public class NewCar extends ActionBarActivity implements View.OnClickListener {
    String[] Cars;
    String[] carPrice;
    int[] CarImages;
    ArrayList<String> carNameArrayList;
    ArrayList<String> carPriceArrayList;
    ArrayList<Integer> carImageArrayList;
    public static String car,price;
    public static int carImage;
    private ImageView calculator;

    public NewCar() {

        //add your new cars with their prices and name
        CarImages = new int[]{R.drawable.r8, R.drawable.a3, R.drawable.q3, R.drawable.q3_c, R.drawable.tt,R.drawable.ciaz,R.drawable.celerio,R.drawable.swift,R.drawable.brio,R.drawable.amaze,R.drawable.crv,R.drawable.city};
        Cars = new String[]{"R8", "A3", "Q3", "Q3 Cabriolet", "TT","Ciaz","Celerio","Swift","Brio","Amaze","CR-V","City"};
        carPrice = new String[]{"80-90", "25-40", "40-60", "60-80", "50-70","7-11","3-5","5-7","4-7","5-8","21-25","8-12"};
        carNameArrayList = new ArrayList<>();
        carPriceArrayList = new ArrayList<>();
        carImageArrayList = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        ActionBar mActionBar = getSupportActionBar();
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
         calculator = (ImageView) mCustomView
                .findViewById(R.id.calculator);
        calculator.setVisibility(View.VISIBLE);
        calculator.setOnClickListener(this);
        mTitleTextView.setText("Search");
        getSupportActionBar().setCustomView(mCustomView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for (int i = 0; i < carPrice.length; i++) {

            carNameArrayList.add(Cars[i]);
            carPriceArrayList.add(carPrice[i]);
            carImageArrayList.add(CarImages[i]);
        }


        SearchNewCarAdapter carCompanyAdapter = new SearchNewCarAdapter(this, carNameArrayList, carImageArrayList, carPriceArrayList);

        ListView theListView = (ListView) findViewById(R.id.listView1);
        theListView.setAdapter(carCompanyAdapter);



        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String carPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(getApplicationContext(), carPicked, Toast.LENGTH_SHORT).show();

                // when u click particular row the image ,name and price are saved in a static variable
                 Constant.car = Cars[i];
                 Constant.carPrice = carPrice[i];
                Constant.carImage =CarImages[i];

//                try {
                //Class myClass = Class.forName("com.carbazaar.natasha.carbazaar." + s);
                Intent myIntent = new Intent(getApplicationContext(), DisplayNewCar.class);
//                imageView.buildDrawingCache();
//                Bitmap _bitmap= imageView.getDrawingCache();

//                ByteArrayOutputStream _bs = new ByteArrayOutputStream();
//                _bitmap.compress(Bitmap.CompressFormat.PNG, 50, _bs);
                myIntent.putExtra("byteArray", CarImages[i]);
                myIntent.putExtra("carPrice",price);
                myIntent.putExtra("carName", car);


                startActivity(myIntent);
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == calculator) {
            startActivity(new Intent(getApplicationContext(), CalculateEmi.class));
        }
    }
}