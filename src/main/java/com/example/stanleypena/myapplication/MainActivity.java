package com.example.stanleypena.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView number_view;
    int counter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number_view =(TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        counter =0;
        number_view.setText(Integer.toString(counter));


       // Toast toast = Toast.makeText(this, R.string.button_label_toast, Toast.LENGTH_LONG);
        //toast.show();
    }

    public void countUp(View view) {
        counter++;

        if(number_view != null){
            number_view.setText(Integer.toString(counter));
        }

    }
}
