package com.example.resepmakanan.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.resepmakanan.model.DataModel;
import com.example.resepmakanan.R;
import com.example.resepmakanan.activities.DetailActivity;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataModel> dataModelArrayList;
    private Activity activity;

    public DataAdapter(Activity activity, ArrayList<DataModel> dataModelArrayList) {
        this.activity = activity;
        this.dataModelArrayList = dataModelArrayList != null ? dataModelArrayList : new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ItemHolder(view);
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {
        public TextView txtJudul;

        public ItemHolder(View view) {
            super(view);
            txtJudul = view.findViewById(R.id.txtJudul);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        ItemHolder holder = (ItemHolder) viewHolder;
        DataModel currentItem = getItem(position);
        holder.txtJudul.setText(currentItem.getJudul());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("dataModel", currentItem);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public DataModel getItem(int position) {
        return dataModelArrayList.get(position);
    }
}