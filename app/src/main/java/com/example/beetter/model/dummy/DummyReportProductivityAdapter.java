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

public class DummyReportProductivityAdapter {
    public class DummyReportViewHolder extends RecyclerView.ViewHolder {
        private ArrayList<DummyReportProductivity> dataList;

        public DummyReportViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @NonNull
        public DummyDailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.report_productivity_item, parent, false);
            return new DummyDailyViewHolder(view);

        }
        private String name;
        private String timeConsume;
        private ImageView application;

        public void onBindViewHolder(@NonNull DummyDailyViewHolder holder, int position) {
            holder.txtName.setText(dataList.get(position).getName());
            holder.txtTimeConsume.setText(dataList.get(position).getTimeConsume());
//            holder.application.setImageResource();
        }

        public int getItemCount() {
            return 0;
        }

        public class DummyDailyViewHolder extends RecyclerView.ViewHolder{
            private TextView txtName;
            private TextView txtTimeConsume;
            private ImageView application;

            public DummyDailyViewHolder(@NonNull View itemView) {
                super(itemView);
                txtName = itemView.findViewById(R.id.memberName);
                txtTimeConsume = itemView.findViewById(R.id.report1);
            }
        }
    }
}
