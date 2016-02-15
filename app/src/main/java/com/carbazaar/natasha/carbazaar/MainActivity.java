package com.carbazaar.natasha.carbazaar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    public static String buttonClicked = "New Car";
    private Toolbar toolbar;
    private ActionBar mActionBar;
    private Button newCarButton, usedCarButton, searchButton;
    private View usedCarView, newCarView;
    private FrameLayout mFrameLayout;
    private EditText selectCarEditText, selectCityEditText;
    private TextView rangeTextView;
    private int minRange = 1, maxRange = 50;
    private ImageView calculator;
    private String[] cityList = {"Mumbai", "Delhi", "Noida", "Gurgaon", "Ghaziabad", "Meerut", "Varanasi", "Bangalore", "Hyderabad", "Jaipur"};
    private ArrayAdapter<String> cityadapter;
    private TextView mTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);


        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#972D07")));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.custom_header_activity,
                null);
        mTitleTextView = (TextView) mCustomView
                .findViewById(R.id.title_text);
        ImageView back = (ImageView) mCustomView
                .findViewById(R.id.back);
        calculator = (ImageView) mCustomView
                .findViewById(R.id.calculator);
        back.setVisibility(View.GONE);
        back.setOnClickListener(this);
        calculator.setOnClickListener(this);
        mTitleTextView.setText("carBazaar");
        getSupportActionBar().setCustomView(mCustomView);


        newCarButton = (Button) findViewById(R.id.newCars);
        usedCarButton = (Button) findViewById(R.id.usedCars);
        searchButton = (Button) findViewById(R.id.search_btn);
        mFrameLayout = (FrameLayout) findViewById(R.id.frameLayoutContainer);

        newCarView = LayoutInflater.from(this).inflate(R.layout.new_cars_layout, null);
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(newCarView);
        usedCarButton.setBackgroundColor(Color.parseColor("#999999"));
        newCarButton.setBackgroundColor(Color.parseColor("#476C9B"));
        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(1, 50, getApplicationContext());
        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                minRange = minValue;
                maxRange = maxValue;

                if (minValue == 1 && maxValue == 50) {
                    rangeTextView.setText("All Range");
                } else if (minValue > 1 && maxValue == 50) {
                    if (minValue == 1)
                        rangeTextView.setText("Above " + minValue + " Lac");
                    else
                        rangeTextView.setText("Above " + minValue + " Lacs");
                } else if (minValue == 1 && maxValue < 50) {
                    rangeTextView.setText("Below " + maxValue + " Lacs");
                } else if (minValue > 1 && maxValue < 50) {
                    rangeTextView.setText(minValue + " Lacs - " + maxValue + " Lacs");
                }


            }
        });

// add RangeSeekBar to pre-defined layout
        ViewGroup layout = (ViewGroup) newCarView.findViewById(R.id.seekBarLayout);
        layout.addView(seekBar);

        selectCarEditText = (EditText) newCarView.findViewById(R.id.selectCars);
        rangeTextView = (TextView) newCarView.findViewById(R.id.seekBarRange);

        selectCarEditText.setOnClickListener(this);
        newCarButton.setOnClickListener(this);
        usedCarButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == calculator) {
            startActivity(new Intent(getApplicationContext(), CalculateEmi.class));
        }
        if (v == usedCarButton) {
            buttonClicked = "Used Car";
            usedCarButton.setBackgroundColor(Color.parseColor("#476C9B"));
            newCarButton.setBackgroundColor(Color.parseColor("#999999"));
            usedCarView = LayoutInflater.from(this).inflate(R.layout.used_car_layout, null);
            mFrameLayout.removeAllViews();

            mFrameLayout.addView(usedCarView);
            selectCityEditText = (EditText) usedCarView.findViewById(R.id.selectCity);
            rangeTextView = (TextView) usedCarView.findViewById(R.id.seekBarRange);
            selectCityEditText.setOnClickListener(this);


            RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(1, 50, getApplicationContext());
            seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                @Override
                public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                    buttonClicked = "Used Range SeekBar";
                    minRange = minValue;
                    maxRange = maxValue;
                    // handle changed range values
                    if (minValue == 1 && maxValue == 50) {
                        rangeTextView.setText("All Range");
                    } else if (minValue > 1 && maxValue == 50) {
                        if (minValue == 1)
                            rangeTextView.setText("Above " + minValue + " Lac");
                        else
                            rangeTextView.setText("Above " + minValue + " Lacs");
                    } else if (minValue == 1 && maxValue < 50) {
                        rangeTextView.setText("Below " + maxValue + " Lacs");
                    } else if (minValue > 1 && maxValue < 50) {
                        rangeTextView.setText(minValue + " Lacs - " + maxValue + " Lacs");
                    }

                }
            });

// add RangeSeekBar to pre-defined layout
            ViewGroup layout = (ViewGroup) usedCarView.findViewById(R.id.seekBarLayout);
            layout.addView(seekBar);
        }
        if (v == newCarButton) {
            buttonClicked = "New Car";
            usedCarButton.setBackgroundColor(Color.parseColor("#999999"));
            newCarButton.setBackgroundColor(Color.parseColor("#476C9B"));
            newCarView = LayoutInflater.from(this).inflate(R.layout.new_cars_layout, null);
            mFrameLayout.removeAllViews();
            mFrameLayout.addView(newCarView);
            selectCarEditText = (EditText) newCarView.findViewById(R.id.selectCars);
            rangeTextView = (TextView) newCarView.findViewById(R.id.seekBarRange);
            selectCarEditText.setOnClickListener(this);
            RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(1, 50, getApplicationContext());
            seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                @Override
                public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {

                    // handle changed range values

                    buttonClicked = "New Range SeekBar";
                    minRange = minValue;
                    maxRange = maxValue;
                    if (minValue == 1 && maxValue == 50) {
                        rangeTextView.setText("All Range");
                    } else if (minValue > 1 && maxValue == 50) {
                        if (minValue == 1)
                            rangeTextView.setText("Above " + minValue + " Lac");
                        else
                            rangeTextView.setText("Above " + minValue + " Lacs");
                    } else if (minValue == 1 && maxValue < 50) {
                        rangeTextView.setText("Below " + maxValue + " Lacs");
                    } else if (minValue > 1 && maxValue < 50) {
                        rangeTextView.setText(minValue + " Lacs - " + maxValue + " Lacs");
                    }

                }
            });

// add RangeSeekBar to pre-defined layout
            ViewGroup layout = (ViewGroup) newCarView.findViewById(R.id.seekBarLayout);
            layout.addView(seekBar);
        }
        if (v == searchButton) {

//            if (buttonClicked.equalsIgnoreCase("None")) {
//                Intent searchIntent = new Intent(getApplicationContext(), Search.class);
//                searchIntent.putExtra("minRange", minRange);
//                searchIntent.putExtra("maxRange", maxRange);
//                startActivity(searchIntent);
//            }else
            if (buttonClicked.equalsIgnoreCase("New Range SeekBar")){
                Intent searchIntent = new Intent(getApplicationContext(), Search.class);
                searchIntent.putExtra("minRange", minRange);
                searchIntent.putExtra("maxRange", maxRange);
                startActivity(searchIntent);
            }else if(buttonClicked.equalsIgnoreCase("Old range SeekBar")){
                Intent searchIntent = new Intent(getApplicationContext(), Search.class);
                searchIntent.putExtra("minRange", minRange);
                searchIntent.putExtra("maxRange", maxRange);
                startActivity(searchIntent);
            }else if(buttonClicked.equalsIgnoreCase("New Car")){
                Intent searchIntent = new Intent(getApplicationContext(), NewCar.class);
                startActivity(searchIntent);
            }else if(buttonClicked.equalsIgnoreCase("Used Car")){
                Intent searchIntent = new Intent(getApplicationContext(), Search.class);
                startActivity(searchIntent);
            }


        }
        if (v == selectCarEditText) {

                startActivity(new Intent(getApplicationContext(), Select.class));

        }
        if (v == selectCityEditText) {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT));
            dialog.setContentView(R.layout.activity_city);
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;
            lp.dimAmount = 0.8f;
            EditText searchCityEditText = (EditText) dialog.findViewById(R.id.inputSearch);
            searchCityEditText.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                    // When user changed the Text
                    MainActivity.this.cityadapter.getFilter().filter(cs);
                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub
                }
            });
            ListView cityListView = (ListView) dialog.findViewById(R.id.list_view);
            cityadapter = new ArrayAdapter<String>(this, R.layout.city_row, R.id.cityName, cityList);

            cityListView.setAdapter(cityadapter);

            cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(), "" + position + " " + cityList[position], Toast.LENGTH_SHORT).show();
                    selectCityEditText.setText(cityList[position]);
                    selectCityEditText.setTextColor(Color.parseColor("#000000"));
                    dialog.dismiss();
                }
            });


            dialog.setCancelable(true);
            dialog.show();
            dialog.getWindow().setAttributes(lp);


        }

    }


}
