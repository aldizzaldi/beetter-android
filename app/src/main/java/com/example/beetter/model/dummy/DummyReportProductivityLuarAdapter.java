package com.example.beetter.model.dummy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;

import java.util.ArrayList;

public class DummyReportProductivityLuarAdapter extends RecyclerView.Adapter<DummyReportProductivityLuarAdapter.DummyReportProductiveLuarViewHolder> {
    private ArrayList<DummyReportProductivityLuar> dataList;
    @NonNull
    @Override
    public DummyReportProductiveLuarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.report_productivity_item, parent, false);
        return new DummyReportProductiveLuarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DummyReportProductiveLuarViewHolder holder, int position) {
        holder.nama.setText(dataList.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DummyReportProductiveLuarViewHolder extends RecyclerView.ViewHolder{
        private TextView nama;

        public DummyReportProductiveLuarViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.name_report_productivity);
        }
    }
}
