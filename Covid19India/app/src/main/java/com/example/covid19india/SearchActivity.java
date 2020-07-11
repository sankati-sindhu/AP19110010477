package com.example.covid19india;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {
    public static final String EXTRA_COUNTRYNAME = "com.example.android.twoactivities.extra.COUNTRYNAME";

    private EditText etSearchCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        etSearchCountry = findViewById(R.id.editTextSearchCountry);


    }

    public void SearchSubmit(View view) {
        Intent intent = new Intent();
        String itemName = etSearchCountry.getText().toString();

        intent.putExtra(EXTRA_COUNTRYNAME, itemName);
        setResult(RESULT_OK, intent);
        finish();

    }
}