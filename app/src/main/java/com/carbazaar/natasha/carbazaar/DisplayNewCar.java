package com.carbazaar.natasha.carbazaar;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayNewCar extends ActionBarActivity implements View.OnClickListener {

    public static Bitmap _bitmap;
    public static String car, price;
    public static int carImage;
    private Toolbar toolbar;
    private ActionBar mActionBar;
    private  ImageView  calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_car_layout);


//            carImage = getIntent().getIntExtra("byteArray",0);
//
//
//           car = getIntent().getStringExtra("carName");
//
//            price = getIntent().getStringExtra("carPrice");

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
         calculator = (ImageView) mCustomView
                .findViewById(R.id.calculator);
        calculator.setVisibility(View.VISIBLE);//GONE means i have omiited the view
       //add click funtionality to calculator
        calculator.setOnClickListener(this);//now we have implemet OnClickListener Interface

        mTitleTextView.setText(NewCar.car);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setCustomView(mCustomView);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CommonCarModel ls_fragment = new CommonCarModel();
        fragmentTransaction.replace(R.id.content_frame, ls_fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//this method is defined in that class
    @Override
    public void onClick(View v) {
        if(v==calculator)
        startActivity(new Intent(getApplicationContext(),CalculateEmi.class));

    }
}
