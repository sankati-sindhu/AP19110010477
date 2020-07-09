package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    public static final String EXTRA_COUNT = "com.example.helloworld.EXTRA.count";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Hello World");
        mShowCount = findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Intent intent = new Intent(this, DisplayCount.class);
        intent.putExtra(EXTRA_COUNT, mCount);
        startActivity(intent);
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }

    }
}