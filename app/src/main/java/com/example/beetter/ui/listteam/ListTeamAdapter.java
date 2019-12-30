package com.example.beetter.ui.listteam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.NavigationActivity;
import com.example.beetter.R;
import com.example.beetter.SharedPrefUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;

public class ListTeamAdapter extends RecyclerView.Adapter<ListTeamAdapter.ListTeamViewHolder> {
    private ArrayList<DataTeam> dataTeamsList;
    private final Context context;

    public ListTeamAdapter(ArrayList<DataTeam> dataTeamsList, Context context){
        this.dataTeamsList = dataTeamsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_team_item, parent, false);
        return new ListTeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTeamViewHolder holder, int position) {
        holder.listTeamNameTeam.setText(dataTeamsList.get(position).getDetailsTeam().getRoomName());
        holder.listTeamNamePM.setText("Project Manager : " + dataTeamsList.get(position).getUser().getName());
        holder.itemView.setOnClickListener(view -> {
            int idTeam = dataTeamsList.get(position).getDetailsTeam().getId();
            SharedPrefUtils.setIntSharedPref("id_team", idTeam);
            Intent intent = new Intent(context, NavigationActivity.class);
            context.startActivity(intent);
            ((Activity)context).finish();
        });
    }

    @Override
    public int getItemCount() {
        return (dataTeamsList != null) ? dataTeamsList.size() : 0;
    }

    public class ListTeamViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.list_team_name_team)
        TextView listTeamNameTeam;

        @BindView(R.id.list_team_name_pm)
        TextView listTeamNamePM;

        public ListTeamViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
