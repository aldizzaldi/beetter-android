package com.example.beetter.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{
    private ArrayList<HomeReportProductivity> reportProductivities;
    private final Context context;

    public HomeAdapter(ArrayList<HomeReportProductivity> reportProductivities, Context context) {
        this.reportProductivities = reportProductivities;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.member_item, parent, false);
        return new HomeViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.homeMemberName.setText(reportProductivities.get(position).getUser().getName());
        holder.homeProductivities.setText(reportProductivities.get(position).getValue().getProductiveValue() + "%");
        if(reportProductivities.get(position).getValue().getProductiveValue() > 70){
            holder.homeProductivities.setTextColor(R.color.colorGreen);
        }
        else if(reportProductivities.get(position).getValue().getProductiveValue() > 50){
            holder.homeProductivities.setTextColor(R.color.colorYellow);
        }
        else{
            holder.homeProductivities.setTextColor(R.color.colorRed);
        }
//        holder.homeProductivities.setTextColor(R.color.design_default_color_primary);
//        holder.homeMemberName.setTextColor(R.color.colorRed);
    }

    @Override
    public int getItemCount() {
        return (reportProductivities != null) ? reportProductivities.size() : 0;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.home_member_name)
        TextView homeMemberName;

        @BindView(R.id.home_percent_productivities)
        TextView homeProductivities;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
