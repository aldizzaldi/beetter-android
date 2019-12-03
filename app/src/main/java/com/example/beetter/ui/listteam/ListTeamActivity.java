package com.example.beetter.ui.listteam;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListTeamActivity extends AppCompatActivity implements IListTeamView{

    @BindView(R.id.recyclerViewListTeam)
    RecyclerView recyclerView;

    private ListTeamPresenter presenter;
    private ListTeamAdapter ListTeamAdapter;
//    private ArrayList dataTeams = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_team);
        ButterKnife.bind(this, this);

        presenter = new ListTeamPresenter(this);
        presenter.getListTeam();
    }

    @Override
    public void getListTeam(ArrayList<DataTeam> dataTeams) {
        ListTeamAdapter = new ListTeamAdapter(dataTeams, ListTeamActivity.this);
        Log.e("wqwq", dataTeams.size() + "!");

        recyclerView.setAdapter(ListTeamAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListTeamActivity.this));

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
