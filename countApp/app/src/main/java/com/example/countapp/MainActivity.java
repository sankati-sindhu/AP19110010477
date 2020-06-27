package com.example.countapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            String s = savedInstanceState.getString("akey");
            assert s != null;
            count = Integer.parseInt(s);
            update();
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        tv = findViewById(R.id.displayCnt);
        outState.putString("akey",tv.getText().toString());
    }

    public void update(){
        tv = findViewById(R.id.displayCnt);
        tv.setText(""+count);
    }

    public void plus(View view) {
        count++;
        update();
    }
    public void minus(View view){
        count--;
        update();
    }
    public void reset(View view){
        count = 0;
        update();
    }
    public void toast(View view){
        Toast.makeText(this,"Your count is "+count, Toast.LENGTH_SHORT).show();
    }


}