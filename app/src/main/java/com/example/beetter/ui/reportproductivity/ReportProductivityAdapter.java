package com.example.beetter.ui.reportproductivity;

import android.content.Context;
import android.graphics.Color;
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
import com.example.beetter.ui.reportproductivity.adapter.RecyclerViewNotProductiveAdapter;
import com.example.beetter.ui.reportproductivity.adapter.RecyclerViewProductiveAdapter;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<App> arrayListProductive = new ArrayList<>();
        ArrayList<App> arrayListNeutral = new ArrayList<>();
        ArrayList<App> arrayListNotProductive = new ArrayList<>();
//        arrayListProductive.clear();
//        arrayListNeutral.clear();
        holder.name.setText(appsArrayList.get(position).user.getName());
        float productive = appsArrayList.get(position).percentProductivities[0];
        float notProductive = appsArrayList.get(position).percentProductivities[2];
        float neutral = appsArrayList.get(position).percentProductivities[1];
        holder.productive.setText( productive+ "%");
        holder.nonProductive.setText(notProductive + "%");
        holder.neutral.setText(neutral + "%");
        int size1 = appsArrayList.get(position).getApps().getProductives().length;
//        int size2 = appsArrayList.get(position).getApps().getUnproductives().length;
        int size3 = appsArrayList.get(position).getApps().getNetral().length;

        holder.piechart.setUsePercentValues(true);
        List<PieEntry> pieChartModels = new ArrayList<>();
        pieChartModels.add(new PieEntry(productive, "Productive"));
        pieChartModels.add(new PieEntry(notProductive, "Not Productive"));
        pieChartModels.add(new PieEntry(neutral, "Neutral"));

        PieDataSet pieDataSet = new PieDataSet(pieChartModels, "");
        PieData pieData = new PieData(pieDataSet);
        holder.piechart.setData(pieData);
        pieDataSet.setColors(new int[]{Color.parseColor("#fc6483"),
                Color.parseColor("#31a3f3"),
                Color.parseColor("#f3d359")});
        pieDataSet.setVisible(true);
        pieData.setDrawValues(false);
        holder.piechart.setDrawSliceText(false);
        holder.piechart.getDescription().setEnabled(false);

        for(int i = 0; i < size1; i++){
            arrayListProductive.add(appsArrayList.get(position).getApps().getProductivesSatuan(i));
        }
        RecyclerViewProductiveAdapter recyclerViewProductiveAdapter = new RecyclerViewProductiveAdapter(arrayListProductive, context);
        holder.recyclerViewProductive.setAdapter(recyclerViewProductiveAdapter);
        holder.recyclerViewProductive.setLayoutManager(new LinearLayoutManager(context));

        for(int i = 0; i < 1; i++){
            arrayListNotProductive.add(appsArrayList.get(position).getApps().getUnproductivesSatuan(i));
        }

        for(int i = 0; i < size3; i++){
            arrayListNeutral.add(appsArrayList.get(position).getApps().getNetralSatuan(i));
//            Log.e("inilo" + i + " " + appsArrayList.get(position).getUser().getName(), appsArrayList.get(position).getApps().getNetralSatuan(i) + "");
        }

        RecyclerViewNeutralAdapter  RecyclerViewNeutralAdapter = new RecyclerViewNeutralAdapter(arrayListNeutral, context);
        holder.recyclerViewNeutral.setAdapter(RecyclerViewNeutralAdapter);
        holder.recyclerViewNeutral.setLayoutManager(new LinearLayoutManager(context));


        RecyclerViewNotProductiveAdapter recyclerViewNotProductiveAdapter = new RecyclerViewNotProductiveAdapter(arrayListNotProductive, context);
        holder.recyclerViewNotProductivee.setAdapter(recyclerViewNotProductiveAdapter);
        holder.recyclerViewNotProductivee.setLayoutManager(new LinearLayoutManager(context));
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
