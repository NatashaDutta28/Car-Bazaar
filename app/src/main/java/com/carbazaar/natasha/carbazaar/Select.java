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


public class Select extends ActionBarActivity {

    public static String carCliked = null;
    private Integer[] imgid = {R.drawable.audi, R.drawable.maruti_suzuki, R.drawable.honda, R.drawable.hyundai, R.drawable.tata, R.drawable.chevrolet,
            R.drawable.ford, R.drawable.toyota, R.drawable.volkswagen, R.drawable.skoda, R.drawable.bmw, R.drawable.ferrari, R.drawable.fiat,
            R.drawable.jaguar, R.drawable.lambhorgini, R.drawable.mercedes, R.drawable.mini, R.drawable.mitsubishi, R.drawable.porchse, R.drawable.renault,
            R.drawable.volvo};
    private String[] carCompanyArray = {"Audi", "Maruti Suzuki", "Honda", "Hyundai", "Tata", "Chevrolet", "Ford", "Toyota",
            "Volkswagen", "Skoda", "BMW", "Ferrari", "Fiat", "Jaguar", "Lamborghini", "Mercedes-Benz", "Mini",
            "Mitsubishi", "Porsche", "Renault", "Volvo"};
    private Toolbar toolbar;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
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
        mTitleTextView.setText("Select Car");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setCustomView(mCustomView);
        CarCompanyAdapter carCompanyAdapter = new CarCompanyAdapter(this, carCompanyArray, imgid);

        ListView theListView = (ListView) findViewById(R.id.listView1);
        theListView.setAdapter(carCompanyAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String carPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(Select.this, carPicked, Toast.LENGTH_SHORT).show();
                String s = carCompanyArray[i];
                carCliked = carCompanyArray[i];//saved the car company you selected audi ,maruti etc
//checked which button was clicked
                if (MainActivity.buttonClicked.equalsIgnoreCase("New Car")) {
                    startActivity(new Intent(getApplicationContext(), CommonNewCar.class));

                } else {
                    try {
                        Class myClass = Class.forName("com.carbazaar.natasha.carbazaar." + s);
                        Intent myIntent = new Intent(Select.this, myClass);
                        startActivity(myIntent);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}