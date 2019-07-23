package com.example.emi_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button submit = findViewById(R.id.submit);
        final EditText principal = findViewById(R.id.principal);
        final EditText rate = findViewById(R.id.rate);
        final EditText time = findViewById(R.id.time);
        final TextView emi = findViewById(R.id.emi);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double p = Double.valueOf(principal.getText().toString());
                float r = Float.valueOf(rate.getText().toString())/100;
                float t = Float.valueOf(time.getText().toString());

                double temp = Math.pow(1+(r/12), t);
                double emi_val = p * (((r/12)*temp) / (temp-1));
                emi.setText("The EMI is: " + String.valueOf(emi_val));
            }
        });
    }
}
