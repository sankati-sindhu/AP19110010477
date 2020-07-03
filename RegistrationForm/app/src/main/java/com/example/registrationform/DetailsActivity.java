package com.example.registrationform;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    TextView roll, name, phone, email, password,gender, branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        roll = findViewById(R.id.rollNo);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.editTextTextPassword);
        branch = findViewById(R.id.branch);
        gender = findViewById(R.id.gender);


        roll.setText(getIntent().getStringExtra("roll"));
        name.setText(getIntent().getStringExtra("name"));
        phone.setText(getIntent().getStringExtra("phone"));
        email.setText(getIntent().getStringExtra("email"));
        password.setText(getIntent().getStringExtra("password"));
        gender.setText(getIntent().getStringExtra("gender"));
        branch.setText(getIntent().getStringExtra("branch"));


    }

}
