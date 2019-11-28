package com.example.beetter.ui.listteam;

import java.util.ArrayList;

public interface IListTeamView {
    void getListTeam(ArrayList<DataTeam> dataTeams);
    void showError(String message);
}
