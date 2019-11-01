package com.example.allprograms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button calculator, factorial, prime, palin_str, reverse, si_ci, circle, rect_sq;
    private Button fact_recur, largest, armstrong_check, arm_print, palin_num, fibo, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = findViewById(R.id.calculator);
        factorial = findViewById(R.id.factorial);
        prime = findViewById(R.id.prime);
        palin_str = findViewById(R.id.str_palindrome);
        palin_num = findViewById(R.id.num_palindrome);
        reverse = findViewById(R.id.reverse);
        si_ci = findViewById(R.id.interest);
        circle = findViewById(R.id.circle);
        rect_sq = findViewById(R.id.rect_square);
        fact_recur = findViewById(R.id.fact_recur);
        largest = findViewById(R.id.largest);
        armstrong_check = findViewById(R.id.armstrong);
        arm_print = findViewById(R.id.display_armstrong);
        fibo = findViewById(R.id.fibo);
        date = findViewById(R.id.date);

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Factorial.class);
                startActivity(intent);
            }
        });

        fact_recur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Factorial.class);
                startActivity(intent);
            }
        });

        prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Prime.class);
                startActivity(intent);
            }
        });

        palin_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Palindrome.class);
                startActivity(intent);
            }
        });

        palin_str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Palindrome.class);
                startActivity(intent);
            }
        });
    }
}
