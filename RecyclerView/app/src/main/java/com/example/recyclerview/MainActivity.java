package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<AndroidVersion> list = Arrays.asList(
            new AndroidVersion(R.drawable.alpha, "Alpha", "1.0", "1", "September 23, 2008"),
            new AndroidVersion(R.drawable.beta, "Beta", "1.1", "2", "February 9, 2009"),
            new AndroidVersion(R.drawable.cupcake, "Cupcake", "1.5", "3", "April 27, 2009"),
            new AndroidVersion(R.drawable.donut, "Donut", "1.6", "4", "September 15, 2009"),
            new AndroidVersion(R.drawable.eclair, "Eclair", "2.0 - 2.1", "5-7", "October 26, 2009"),
            new AndroidVersion(R.drawable.froyo, "Froyo", "2.2", "8", "December 6, 2010"),
            new AndroidVersion(R.drawable.gingerbread, "GingerBread", "2.3", "1", "February 22, 2011"),
            new AndroidVersion(R.drawable.honeycomb, "HoneyComb", "3.0", "9-10", "September 23, 2008"),
            new AndroidVersion(R.drawable.icecreamsandwich, "Ice Cream Sandwich", "14-15", "11-13", "October 18, 2011"),
            new AndroidVersion(R.drawable.jellybean, "Jellybean", "4.1", "16-18", "July 9, 2012"),
            new AndroidVersion(R.drawable.kitkat, "Kitkat", "4.4", "10-20", "October 31, 2013"),
            new AndroidVersion(R.drawable.lollipop, "Lollipop", "5.0", "21-22", "November 12, 2014"),
            new AndroidVersion(R.drawable.marshmallow, "Marshmallow", "6.0", "23", "October 5, 2015"),
            new AndroidVersion(R.drawable.nougat, "Nougat", "7.0", "24-25", "August 22, 2016"),
            new AndroidVersion(R.drawable.oreo, "Oreo", "8.0", "26-27", "August 21, 2017"),
            new AndroidVersion(R.drawable.pie, "pie", "9.0", "28", "August 6, 2018"),
            new AndroidVersion(R.drawable.q, "Q", "10.0", "29", "September 3, 2019"),
            new AndroidVersion(R.drawable.r, "R", "11.0", "30", "Not yet Released")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.contentData);

        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        ItemAdapter adapter = new ItemAdapter(MainActivity.this,  list);
        rv.setAdapter(adapter);



    }


}