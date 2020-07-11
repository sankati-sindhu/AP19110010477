package com.example.covid19india;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static final int TEXT_REQUEST = 1;
    private RecyclerView rv;
    private Switch theme;
    private List<DayData> dd = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.contentData);
        theme = findViewById(R.id.switch1);
        String queryString = "INDIA";
        //rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        AsyncTask<String, Void, String> fd = new FetchData(dd,MainActivity.this, rv).execute(queryString);


        // TODO: figure how to add set theme
        /*theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Log.d("theme","Set to dark");

                }
                else
                {
                    Log.d("them","set to light");
                }

            }
        });*/

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                dd.clear();
                String queryString = data.getStringExtra(SearchActivity.EXTRA_COUNTRYNAME).toString();
                //AsyncTask<String, Void, String> fd = new FetchData(dd).execute(queryString);


            }
        }
    }
    public void StartSearch(View view) {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}