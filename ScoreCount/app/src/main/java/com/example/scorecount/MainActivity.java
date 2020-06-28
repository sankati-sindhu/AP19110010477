package com.example.scorecount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.scorecount.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    Button aPoint1, aPoint2, aPoint3, bPoint1, bPoint2, bPoint3, reset;
    TextView aScore, bScore;
    int aCount=0, bCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        aScore = findViewById(R.id.aScore);
        bScore = findViewById(R.id.bScore);
        aPoint1 = findViewById(R.id.aPoint1);
        aPoint2 = findViewById(R.id.aPoint2);
        aPoint3 = findViewById(R.id.aPoint3);
        bPoint1 = findViewById(R.id.bPoint1);
        bPoint2 = findViewById(R.id.bPoint2);
        bPoint3 = findViewById(R.id.bPoint3);
        reset = findViewById(R.id.reset);
        aPoint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aCount++;
                aScore.setText(""+aCount);
            }
        });
        aPoint2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aCount+=2;
                aScore.setText(""+aCount);
            }
        });
        aPoint3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aCount+=3;
                aScore.setText(""+aCount);
            }
        });
        bPoint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bCount++;
                bScore.setText(""+bCount);
            }
        });
        bPoint2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bCount+=2;
                bScore.setText(""+bCount);
            }
        });
        bPoint3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bCount+=3;
                bScore.setText(""+bCount);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bCount = 0;
                aCount = 0;
                aScore.setText(""+aCount);
                bScore.setText(""+bCount);
            }
        });


    }


}