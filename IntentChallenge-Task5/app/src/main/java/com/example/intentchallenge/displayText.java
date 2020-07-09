package com.example.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class displayText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text);
        TextView dContent;
        dContent = findViewById(R.id.content);
        Intent intent = getIntent();
        int id = intent.getIntExtra(MainActivity.EXTRA_ID, 0);
        switch (id){
            case 1:{
                dContent.setText(R.string.button_1_text);
                break;
            }
            case 2:{
                dContent.setText(R.string.button_2_text);
                break;
            }
            case 3:{
                dContent.setText(R.string.button_3_text);
                break;
            }
        }
    }
}