package com.example.beetter.model.dummy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;

import java.util.ArrayList;

public class DummyReportProductivityAdapter extends RecyclerView.Adapter<DummyReportProductivityAdapter.DummyProductivitiesViewHolder>{
    private ArrayList<DummyReportProductivity> dataList;

    @NonNull
    @Override
    public DummyProductivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.report_productivity_item, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DummyProductivitiesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DummyProductivitiesViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaApps;
        private TextView txtJam;

        public DummyProductivitiesViewHolder(@NonNull View itemView, TextView txtNamaApps, TextView txtJam) {
            super(itemView);
            this.txtNamaApps = txtNamaApps;
            this.txtJam = txtJam;
        }
    }
}
