package com.example.covid19india;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context myCt;
    List<DayData> myList;

    public MyAdapter(Context ct, List<DayData>dataList) {
        myCt = ct;
        myList = dataList;

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(myCt).inflate(R.layout.activity_content_main,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MyViewHolder holder, int position) {
        DayData d = myList.get(position);
        holder.date.setText(d.getDate());
        holder.casesActive.setText(d.getCasesActive());
        holder.casesRecovered.setText(d.getCasesRecovered());
        holder.Deceased.setText(d.getDeceased());

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date, casesActive, casesRecovered, Deceased;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            casesActive = itemView.findViewById(R.id.caseActive);
            casesRecovered = itemView.findViewById(R.id.caseRecover);
            Deceased = itemView.findViewById(R.id.deaths);


        }
    }
}