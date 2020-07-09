package com.example.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "com.example.android.twoactivities.extra.ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButton1, mButton2, mButton3;
        mButton1 = findViewById(R.id.button_main_1);
        mButton2 = findViewById(R.id.button_main_2);
        mButton3 = findViewById(R.id.button_main_3);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDisplay(1);
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDisplay(2);
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDisplay(3);
            }
        });
    }

    public void startDisplay(int id ){
        Intent intent = new Intent(this, displayText.class);
        intent.putExtra(EXTRA_ID, id);
        startActivity(intent);

    }
}