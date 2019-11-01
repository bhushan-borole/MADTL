package com.example.allprograms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Factorial extends AppCompatActivity {

    private Button submit;
    private EditText inp;
    private TextView op;

    public static int fact(int i){
        if(i == 0)
            return 1;
        else
            return i*fact(i-1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        submit = findViewById(R.id.submit_fact);
        inp = findViewById(R.id.inp_fact);
        op = findViewById(R.id.op_fact);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.valueOf(inp.getText().toString().trim());
                int factorial = fact(num);
                System.out.println(factorial);
                op.setText(String.valueOf(factorial));
            }
        });
    }
}
