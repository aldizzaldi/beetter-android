package com.example.beetter.ui.home;

import java.util.ArrayList;

public interface IHomeView {
    void getTeamMember(ArrayList<ReportProductivity> reportProductivities);
    void showError(String message);
}
