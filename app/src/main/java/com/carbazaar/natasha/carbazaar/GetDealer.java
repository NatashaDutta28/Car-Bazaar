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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by Natasha on 5/9/2015.
 */
public class GetDealer extends ActionBarActivity {
    //now override onCreate method of Activity Class
    private EditText nameEditText,mobileEditText,emailAddressEditText;
    private Button getDetailsButton;
    private ActionBar mActionBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the layout you want to show
        setContentView(R.layout.get_dealer_details);
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
        mTitleTextView.setText("Audi");
        getSupportActionBar().setCustomView(mCustomView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        nameEditText = (EditText)findViewById(R.id.Name);
        mobileEditText = (EditText)findViewById(R.id.number);
        emailAddressEditText = (EditText)findViewById(R.id.emailid);
        getDetailsButton = (Button)findViewById(R.id.getDetailsButton);

       //now if you have to perform some action on button click
        getDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //you can perform any action
                //you need to check whether you have filled all the edit text

//                String name = nameEditText.getText().toString();//fetching the text u enterd in tne name field and converting it to string
                String mobile = mobileEditText.getText().toString();
               String email = emailAddressEditText.getText().toString();
                if(nameEditText.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Please enter your name!",Toast.LENGTH_SHORT).show();
                }else if(!validatePhone(mobile)){
                    Toast.makeText(getApplicationContext(),"Please enter your mobile number!",Toast.LENGTH_SHORT).show();
                }else if(!checkEmail(email)){
                    Toast.makeText(getApplicationContext(),"Please enter your email address!",Toast.LENGTH_SHORT).show();
                }else{
                    String name = "Girish Tyagi";//fetching the text u enterd in tne name field and converting it to string
                    String mobilenumber = "+91956062334";
                    String email_address = "girish.tyagi@gmail.com";
                    //creating an intent
                    Intent intent = new Intent(getApplicationContext(),DealerInfo.class);
                    intent.putExtra("Name",name);//passing name  Name--> key
                    intent.putExtra("Mobile",mobilenumber);// mobile
                    intent.putExtra("Email",email_address);

                    startActivity(intent);
                }


            }
        });


    }

    private boolean validatePhone(String phone2) {
        // TODO Auto-generated method stub
        return phone2.matches("^[0-9]{10}$");
    }

    private boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    public final Pattern EMAIL_ADDRESS_PATTERN = Pattern
            .compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
                            + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
                            + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"

            );
}
