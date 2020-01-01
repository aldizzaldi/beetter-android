package com.example.beetter.ui.home;

import java.util.ArrayList;

public interface IHomeView {
    void getTeamMember(ArrayList<HomeReportProductivity> reportProductivities);
    void showError(String message);
    void showOverallProductivitiesTeam(String value);
    void sendPoke(int idTeam, int idUser);
}
