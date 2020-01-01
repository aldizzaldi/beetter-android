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

    public DummyReportProductivityAdapter(ArrayList<DummyReportProductivity> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DummyProductivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_app_item, parent, false);
        return new DummyProductivitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DummyProductivitiesViewHolder holder, int position) {
        holder.txtJam.setText(dataList.get(position).getTimeConsume());
        holder.txtNamaApps.setText(dataList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DummyProductivitiesViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaApps;
        private TextView txtJam;

        public DummyProductivitiesViewHolder(@NonNull View itemView) {
            super(itemView);
//            txtNamaApps = itemView.findViewById(R.id.textView7);
//            txtJam = itemView.findViewById(R.id.textView9);

        }
    }
}
