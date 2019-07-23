package com.example.sqlitecrudoperations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;

public class RegisterActivity extends AppCompatActivity {

    EditText username;
    EditText pass1;
    EditText pass2;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.login_id_register);
        pass1 = findViewById(R.id.password1);
        pass2 = findViewById(R.id.password2);
        btn_submit = findViewById(R.id.submit_register);

        final DatabaseHandler db = new DatabaseHandler(this);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login_id = username.getText().toString().trim();
                String pass = pass1.getText().toString().trim();
                String re_pass = pass2.getText().toString().trim();

                if(pass.equals(re_pass)){
                    User user = new User(login_id, pass);
                    try {
                        db.addUser(user);
                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    } catch (NoSuchAlgorithmException e) {
                        Toast.makeText(getApplicationContext(), "Some Error Occured", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
