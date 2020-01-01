package com.example.beetter.ui.reportproductivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;
import com.example.beetter.model.App;
import com.example.beetter.ui.reportproductivity.adapter.RecyclerViewNeutralAdapter;
import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportProductivityAdapter extends RecyclerView.Adapter<ReportProductivityAdapter.ReportProductivityViewHolder> {
    private final ArrayList<ReportProductivityApps> appsArrayList;
    private final ArrayList<App> arrayListProductive = new ArrayList<>();
    private final ArrayList<App> arrayListNotProductive = new ArrayList<>();
    private final ArrayList<App> arrayListNeutral = new ArrayList<>();
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
        holder.nonProductive.setText(appsArrayList.get(position).percentProductivities[2] + "%");
        holder.neutral.setText(appsArrayList.get(position).percentProductivities[1] + "%");
//        int size1 = appsArrayList.get(position).getApps().getProductives().length;
//        int size2 = appsArrayList.get(position).getApps().getUnproductives().length;
        int size3 = appsArrayList.get(position).getApps().getNetral().length;

//        for(int i = 0; i < size1; i++){
//            arrayListProductive.add(appsArrayList.get(position).getApps().getProductivesSatuan(i));
//        }
//
//        for(int i = 0; i < size2; i++){
//            arrayListProductive.add(appsArrayList.get(position).getApps().getUnproductives(i));
//        }

        for(int i = 0; i < size3; i++){
            arrayListProductive.add(appsArrayList.get(position).getApps().getNetralSatuan(i));
            Log.e("inilo" + i + " " + appsArrayList.get(position).getUser().getName(), appsArrayList.get(position).getApps().getNetralSatuan(i) + "");
        }
        RecyclerViewNeutralAdapter  RecyclerViewNeutralAdapter = new RecyclerViewNeutralAdapter(arrayListNeutral, context);
        holder.recyclerViewNeutral.setAdapter(RecyclerViewNeutralAdapter);
        holder.recyclerViewNeutral.setLayoutManager(new LinearLayoutManager(context));
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

        @BindView(R.id.recyclerViewProductive)
        RecyclerView recyclerViewProductive;

        @BindView(R.id.recyclerViewNotProductive)
        RecyclerView recyclerViewNotProductivee;

        @BindView(R.id.recyclerViewNeutral)
        RecyclerView recyclerViewNeutral;


        public ReportProductivityViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
