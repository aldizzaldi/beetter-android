package com.example.beetter.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {

    private ArrayList<Member> dataList;

    public MemberAdapter(ArrayList<Member> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.member_item, parent, false);
        return new MemberViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        holder.txtName.setText(dataList.get(position).getName());
        holder.txtPercent.setText(dataList.get(position).getPercentproductivity() + "% productivities");
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtPercent;

        public MemberViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.home_member_name);
            txtPercent = (TextView) itemView.findViewById(R.id.home_percent_productivities);
        }

    }

}
