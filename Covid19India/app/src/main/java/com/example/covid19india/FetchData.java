package com.example.covid19india;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class FetchData extends AsyncTask<String, Void, String> {

    WeakReference<Context> ct;
    WeakReference<RecyclerView> rv;
    WeakReference<List<DayData>>  dataList;
    public FetchData(List<DayData> dd, Context ct, RecyclerView rv){
        this.dataList = new WeakReference<>(dd);
        this.rv = new WeakReference<>(rv);
        this.ct = new WeakReference<>(ct);
    }
    @Override
    protected String doInBackground(String... queryString) {
        return NetworkUtils.getCovidInfo(queryString[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("outputs", ""+s);
        super.onPostExecute(s);

        try{
            JSONArray itemsArray = new JSONArray(s);

            int i =itemsArray.length()-1;

            while(i>=0){
                JSONObject jsonObject = itemsArray.getJSONObject(i);
                String date = jsonObject.getString("Date");
                String casesActive = jsonObject.getString("Active");
                String casesRecovered = jsonObject.getString("Recovered");
                String Deceased = jsonObject.getString("Deaths");
                DayData dd = new DayData(date,casesActive,casesRecovered,Deceased);
                dataList.get().add(dd);
                i--;
            }
            rv.get().setLayoutManager(new LinearLayoutManager(ct.get()));
            rv.get().setAdapter(new MyAdapter(ct.get(), dataList.get()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
