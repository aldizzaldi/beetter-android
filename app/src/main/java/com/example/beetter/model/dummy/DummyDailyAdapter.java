package com.example.beetter.model.dummy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;
import com.example.beetter.ui.dailyreport.DailyReport;

import java.util.ArrayList;

public class DummyDailyAdapter extends  RecyclerView.Adapter<DummyDailyAdapter.DummyDailyViewHolder>{
    private ArrayList<DummyDailyReport> dataList;

    public DummyDailyAdapter(ArrayList<DummyDailyReport> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DummyDailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.daily_report_item, parent, false);
        return new DummyDailyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DummyDailyViewHolder holder, int position) {
        holder.txtName.setText(dataList.get(position).getName());
        holder.txtLastWork.setText(dataList.get(position).getLastWork());
        holder.txtObstacle.setText(dataList.get(position).getObstacle());
        holder.txtNextWork.setText(dataList.get(position).getNextWork());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class DummyDailyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName;
        private TextView txtLastWork;
        private TextView txtNextWork;
        private TextView txtObstacle;

        public DummyDailyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.memberName);
            txtLastWork = itemView.findViewById(R.id.valueReport1);
            txtObstacle = itemView.findViewById(R.id.valueReport3);
            txtNextWork = itemView.findViewById(R.id.valueReport2);
        }
    }
}
