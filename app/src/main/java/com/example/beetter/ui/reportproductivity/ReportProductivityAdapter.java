package com.example.beetter.ui.reportproductivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;
import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportProductivityAdapter extends RecyclerView.Adapter<ReportProductivityAdapter.ReportProductivityViewHolder> {
    private final ArrayList<ReportProductivityApps> appsArrayList;
    private final Context context;

    public ReportProductivityAdapter(ArrayList<ReportProductivityApps> appsArrayList, Context context){

        this.appsArrayList = appsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ReportProductivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.report_productivity_item, parent, false);
        return new ReportProductivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportProductivityViewHolder holder, int position) {
        holder.name.setText(appsArrayList.get(position).user.getName());
        holder.productive.setText(appsArrayList.get(position).percentProductivities[0] + "%");
        holder.nonProductive.setText(appsArrayList.get(position).percentProductivities[1] + "%");
        holder.neutral.setText(appsArrayList.get(position).percentProductivities[2] + "%");
    }

    @Override
    public int getItemCount() {
        return (appsArrayList != null) ? appsArrayList.size() : 0;
    }

    public class ReportProductivityViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.name_report_productivity)
        TextView name;

        @BindView(R.id.non_productive_percentage)
        TextView productive;

        @BindView(R.id.productive_percentage)
        TextView nonProductive;

        @BindView(R.id.neutral_percentage)
        TextView neutral;

        @BindView(R.id.piechart)
        PieChart piechart;

        public ReportProductivityViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
