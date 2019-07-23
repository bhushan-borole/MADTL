package com.example.sqlitecrudoperations;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String DB_NAME = "myempdb";

    TextView viewEmployees;
    EditText editTextName, editTextSalary;
    Spinner department;
    Button add;

    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewEmployees = findViewById(R.id.viewEmployees);
        editTextName = findViewById(R.id.editTextName);
        editTextSalary = findViewById(R.id.editTextSalary);
        department = findViewById(R.id.department);
        add = findViewById(R.id.addEmployee);

        //creating a database
        mDatabase = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
        createEmployeeTable();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
            }
        });

        viewEmployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), EmployeeActivity.class));
            }
        });
    }

    private void addEmployee() {
        String name = editTextName.getText().toString().trim();
        String sal = editTextSalary.getText().toString().trim();
        String dept = department.getSelectedItem().toString();

        // adding joining data
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.US);
        String join = simpleDateFormat.format(cal.getTime());



        if(checkInputs(name, sal)){
            String insertSQL = "INSERT INTO employees \n" +
                    "(name, department, joiningdate, salary)\n" +
                    "VALUES \n" +
                    "(?, ?, ?, ?);";

            mDatabase.execSQL(insertSQL, new String[]{name, dept, join, sal});

            Toast.makeText(this, "Employee Added Successfully", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean checkInputs(String name, String sal){
        if(name.isEmpty()){
            editTextName.setError("Please Enter a Name");
            editTextName.requestFocus();
            return false;
        }
        if(sal.isEmpty() || Integer.parseInt(sal) <= 0){
            editTextSalary.setError("Please Enter a Name");
            editTextSalary.requestFocus();
            return false;
        }
        return  true;
    }

    //this method will create the table
    //as we are going to call this method everytime we will launch the application
    //I have added IF NOT EXISTS to the SQL
    //so it will only create the table when the table is not already created
    private void createEmployeeTable() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS employees (\n" +
                        "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "    name varchar(200),\n" +
                        "    department varchar(200),\n" +
                        "    joiningdate datetime,\n" +
                        "    salary double\n" +
                        ");"
        );
    }
}
