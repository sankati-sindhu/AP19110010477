package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LoggedPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_page);
        String s= getIntent().getStringExtra ("name" );
        TextView tv = (TextView) findViewById ( R.id.textview );
        tv.setText ( "Welcome ".concat(s+"!!!") );
    }
}