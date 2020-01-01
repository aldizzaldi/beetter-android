package com.example.beetter.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    int idUser;

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

//    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        idUser = reportProductivities.get(position).getUser().getId();
        holder.homeMemberName.setText(reportProductivities.get(position).getUser().getName());
        holder.homeProductivities.setText(reportProductivities.get(position).getValue().getProductiveValue() + "%");
        if(reportProductivities.get(position).getValue().getProductiveValue() > 70){
            holder.homeProductivities.setTextColor(context.getResources().getColor(R.color.colorGreen));
            Log.e("IJO", "tetew - " + reportProductivities.get(position).getUser().getName() + reportProductivities.get(position).getValue().getProductiveValue());
        }
        else if(reportProductivities.get(position).getValue().getProductiveValue() > 50){
            holder.homeProductivities.setTextColor(context.getResources().getColor(R.color.colorYellow));
            Log.e("KUNING", "tetew - " + reportProductivities.get(position).getUser().getName() + reportProductivities.get(position).getValue().getProductiveValue());
        }
        else{
            holder.homeProductivities.setTextColor(context.getResources().getColor(R.color.colorRed));
            Log.e("MERAH", "tetew - " + reportProductivities.get(position).getUser().getName() + reportProductivities.get(position).getValue().getProductiveValue());
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

        @BindView(R.id.rocket)
        ImageView boost;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
