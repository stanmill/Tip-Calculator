package com.example.stanleypena.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.EditText;
import android.util.Log;


import java.text.NumberFormat;



public class MainActivity extends AppCompatActivity implements TextWatcher, SeekBar.OnSeekBarChangeListener {

    private EditText editTextBillAmount;
    private TextView textViewBillAmount,tipTextView,totalTextView,textViewPercent;
    private SeekBar seek;

    private double billAmount = 0.0;
    private double percent =0.00;


    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getPercentInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = (EditText) findViewById(R.id.enter_amount);
        editTextBillAmount.addTextChangedListener((TextWatcher) this);
        textViewBillAmount = (TextView) findViewById(R.id.view_amount);
        tipTextView = (TextView) findViewById(R.id.tip_amount);
        totalTextView = (TextView) findViewById(R.id.total_after_tax);
        seek = (SeekBar) findViewById(R.id.tip_bar);
        seek.setMax(100);

        textViewPercent = (TextView) findViewById(R.id.tip_label1);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                percent = progress / 100.0; //calculate percent based on seeker value
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        // get bill amount and display currency formatted value
        try { 
            billAmount = Double.parseDouble(s.toString()) / 100.0;
            textViewBillAmount.setText(currencyFormat.format(billAmount));
                      }
                  catch (NumberFormatException e) { // if  is empty
                      textViewBillAmount.setText("");
                         billAmount = 0.0;
                      }

        //perform tip and total calculation and update UI by calling calculate*/
        calculate();


    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void calculate() {
        Log.d("MainActivity", "inside calculate method");

        //format percent and display in percentTextView
        textViewPercent.setText(percentFormat.format(percent));

       // calculate the tip and total
       double tip = billAmount * percent;

       // display tip and total formatted as currency
       tipTextView.setText(currencyFormat.format(tip));

        //display total
        double total = tip + billAmount;
        totalTextView.setText(currencyFormat.format(total));

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


}



