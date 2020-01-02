package com.example.beetter.ui.reportproductivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;
import com.example.beetter.model.App;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewProductiveAdapter extends RecyclerView.Adapter<RecyclerViewProductiveAdapter.RecyclerViewProductiveViewHolder> {
    private ArrayList<App> arrayList;
    private final Context context;

    public RecyclerViewProductiveAdapter(ArrayList<App> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewProductiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_app_item, parent, false);
        return new RecyclerViewProductiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewProductiveViewHolder holder, int position) {
        holder.appName.setText(arrayList.get(position).getName());
        holder.timeConsume.setText(arrayList.get(position).getDuration());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null) ? arrayList.size() : 0;
    }

    public class RecyclerViewProductiveViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.namaApps)
        TextView appName;

        @BindView(R.id.timeConsume)
        TextView timeConsume;
        public RecyclerViewProductiveViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
