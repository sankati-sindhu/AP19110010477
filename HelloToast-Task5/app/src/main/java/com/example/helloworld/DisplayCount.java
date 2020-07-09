package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayCount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_count);
        TextView tv;
        tv = findViewById(R.id.tvHelloCount);
        Intent intent = getIntent();
        int count = intent.getIntExtra(MainActivity.EXTRA_COUNT, 0);
        tv.setText("Hello!\n" + count);
    }
}