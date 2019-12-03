package com.example.beetter.ui.dailyreport;

import android.content.Context;
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

public class DailyReportAdapter extends RecyclerView.Adapter<DailyReportAdapter.DailyReportViewHolder> {
    private ArrayList<DailyReport> dailyReportList;
    private final Context context;

    public DailyReportAdapter(ArrayList<DailyReport> dailyReportList, Context context) {
        this.dailyReportList = dailyReportList;
        this.context = context;
    }

    @NonNull
    @Override
    public DailyReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.daily_report_item, parent, false);
        return new DailyReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyReportViewHolder holder, int position) {
        holder.memberName.setText(dailyReportList.get(position).getUser().getName());
        holder.submitionTime.setText(dailyReportList.get(position).getDaily().getTanggalDibuat());
        holder.reportLast24hr.setText(dailyReportList.get(position).getDaily().getYangSudahDikerjakan());
        holder.reportProblem.setText(dailyReportList.get(position).getObstacles().getMasalah());
        holder.reportNext24hr.setText(dailyReportList.get(position).getDaily().getYangAkanDikerjakan());
    }

    @Override
    public int getItemCount() {
        return (dailyReportList != null) ? dailyReportList.size() : 0;
    }

    public class DailyReportViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.submitionTime)
        TextView submitionTime;

        @BindView(R.id.valueReport1)
        TextView reportLast24hr;

        @BindView(R.id.valueReport2)
        TextView reportNext24hr;

        @BindView(R.id.valueReport3)
        TextView reportProblem;

        @BindView(R.id.memberName)
        TextView memberName;

        public DailyReportViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
