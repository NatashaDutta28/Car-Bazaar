package com.carbazaar.natasha.carbazaar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RU!NS on 08-05-2015.
 */
public class CalculateEmi extends ActionBarActivity {
    private TextView roi = null;
    private TextView noofinstallments = null;
    private TextView loanAmt = null;
    private Button ok = null;
    private Toolbar toolbar;
    private ActionBar mActionBar;
    private SeekBar month,interest,loan;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_emi);
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
        mTitleTextView.setText("Loan Info");
        getSupportActionBar().setCustomView(mCustomView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initializeControls();
    }

    private void initializeControls() {
        roi = (TextView) findViewById(R.id.interestrate);
        noofinstallments = (TextView)
                findViewById(R.id.installments);
        loanAmt = (TextView) findViewById(R.id.loanAmount);
        ok = (Button) findViewById(R.id.btn_ok);
        month = (SeekBar)findViewById(R.id.seekBar1);
        interest = (SeekBar)findViewById(R.id.seekBa2);
        loan = (SeekBar)findViewById(R.id.seekBar3);


        //this.cancel = (Button)findViewById(R.id.btn_cancel);
        //Create event handlers
        this.ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOkClick(view);
            }
        });
        month.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                noofinstallments.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                loanAmt.setText("" + progress);
            }
        });

        interest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                roi.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                loanAmt.setText("" + progress);
            }
        });



        loan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                loanAmt.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                loanAmt.setText(""+progress);
            }
        });


    }


    private void onOkClick(View view) {
        //Validate fields
        try {
            double droi = Double.parseDouble(
                    roi.getText().toString());
            int inoofinst = Integer.parseInt(
                    noofinstallments.getText().toString());
            double principle = Double.parseDouble(
                    loanAmt.getText().toString());
            if (droi < 0.001 || droi > 99.99) {
                showAlert("ROI not in range 0.001-99.99");
                roi.requestFocus();
                return;
            }

            if (inoofinst < 1 || inoofinst > 480) {
                showAlert("No of monthly installment not in range 1-480");
                noofinstallments.requestFocus();
                return;
            }

            if (principle < 100 || inoofinst > 100000000) {
                showAlert("Loan amount not in range 100-100000000");
                loanAmt.requestFocus();
                return;
            }

            //Start Calculation
            if (droi > 1.0) {
                droi = droi / 100.0;
            }
            droi /= 12.0;

            double pow = 1.0;
            for (int j = 0; j < inoofinst; j++) {
                pow = pow * (1.0 + droi);
            }

            double emi = 0.01 * Math.round(100.0 * (principle * pow * droi) / (pow - 1));
            //Show emi per month
            showAlert("Your Emi : " + String.valueOf(emi));
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please fill the required fields.", Toast.LENGTH_SHORT).show();

        }
    }

    //Method to show alert
    private void showAlert(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg)
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }


}