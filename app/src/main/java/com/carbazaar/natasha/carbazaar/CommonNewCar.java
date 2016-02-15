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
 * Created by RU!NS on 11-05-2015.
 */
public class CommonNewCar extends ActionBarActivity {


    private ArrayList<String> carModel = new ArrayList<>();
    private ArrayList<String> carModelPrice = new ArrayList<>();
    private ArrayList<Integer> carModelImage = new ArrayList<>();
    public static String car,price;
    public static Integer carImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
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
        ImageView calculator = (ImageView) mCustomView
                .findViewById(R.id.calculator);
        calculator.setVisibility(View.GONE);
        mTitleTextView.setText(Select.carCliked);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setCustomView(mCustomView);

        if(!carModel.isEmpty()){
            carModel.clear();
            carModelPrice.clear();
            carModelImage.clear();
        }
        //now i checked the car Company selected by the user and displayed its model
        //you have to simply add
        // 3 car models was added in each section with name image and price
        if (Select.carCliked.equalsIgnoreCase("audi")) {
            if(!carModel.isEmpty()){
                carModel.clear();
                carModelPrice.clear();
                carModelImage.clear();
            }
            carModel.add("A3");//Name
            carModelPrice.add("Rs.23-30 lacs");//Price
            carModelImage.add(R.drawable.a3);//image
            carModel.add("Q4");
            carModelImage.add(R.drawable.q3_c);
            carModelPrice.add("Rs.23-30 lacs");
            carModel.add("TT");
            carModelImage.add(R.drawable.tt);
            carModelPrice.add("Rs.23-30 lacs");

        }else if(Select.carCliked.equalsIgnoreCase("Maruti Suzuki")){
            //do not forget to write this if code
            if(!carModel.isEmpty()){
                carModel.clear();
                carModelPrice.clear();
            }
            carModel.add("Alto");
            carModelPrice.add("Rs.2-3 lacs");
            carModelImage.add(R.drawable.a3);
            carModel.add("Ciaz");
            carModelImage.add(R.drawable.tt);
            carModelPrice.add("Rs.3-7 lacs");
            carModel.add("Swift");
            carModelImage.add(R.drawable.tt);
            carModelPrice.add("Rs.5-8 lacs");
        }

        SearchNewCarAdapter carCompanyAdapter = new SearchNewCarAdapter(this, carModel, carModelImage, carModelPrice);

        ListView theListView = (ListView) findViewById(R.id.listView1);
        theListView.setAdapter(carCompanyAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String carPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(getApplicationContext(), carPicked, Toast.LENGTH_SHORT).show();

                Constant.car = carModel.get(i);
                Constant.carPrice = carModelPrice.get(i);
                Constant.carImage =carModelImage.get(i);

//                try {
                //Class myClass = Class.forName("com.carbazaar.natasha.carbazaar." + s);
                Intent myIntent = new Intent(getApplicationContext(), DisplayNewCar.class);
//                imageView.buildDrawingCache();
//                Bitmap _bitmap= imageView.getDrawingCache();

//                ByteArrayOutputStream _bs = new ByteArrayOutputStream();
//                _bitmap.compress(Bitmap.CompressFormat.PNG, 50, _bs);
                myIntent.putExtra("byteArray", carImage);
                myIntent.putExtra("carPrice",price);
                myIntent.putExtra("carName", car);


                startActivity(myIntent);
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }

            }
        });


    }
}
