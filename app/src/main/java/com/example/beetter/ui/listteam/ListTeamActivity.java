package com.example.beetter.ui.listteam;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beetter.R;

public class ListTeamActivity extends AppCompatActivity implements IListTeamView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_team);
    }

    @Override
    public void moveToHome() {

    }

    @Override
    public void getListTeam() {

    }
}
