package com.example.recyclerview;

import com.example.recyclerview.R.string.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.MessageFormat;
import java.util.List;

import static androidx.core.content.res.TypedArrayUtils.getString;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    List<AndroidVersion> list;
    Context ct;
    ItemAdapter(Context ct, List<AndroidVersion> list){
        this.list =list;
        this.ct = ct;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.my_item, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        AndroidVersion a= list.get(position);
        holder.iv.setImageResource(a.getImage());
        holder.tv1.setText(MessageFormat.format(" : {0}",  a.getName()));
        holder.tv2.setText(MessageFormat.format(" : {0}", a.getVersionNo()));
        holder.tv3.setText(MessageFormat.format(" : {0}", a.getApiLevel()));
        holder.tv4.setText(MessageFormat.format(" : {0}",  a.getReleaseDate()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1, tv2, tv3, tv4;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView);
            tv1 = itemView.findViewById(R.id.cName);
            tv2 = itemView.findViewById(R.id.cVersionNumber);
            tv3 = itemView.findViewById(R.id.cApiLevel);
            tv4 = itemView.findViewById(R.id.cReleaseDate);


        }
    }
}
