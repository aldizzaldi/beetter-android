package com.example.beetter.model.response;

import com.example.beetter.ui.home.HomeReportProductivity;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetListMemberInTeamResponse {
    @SerializedName("success")
    Boolean succes;
    @SerializedName("data")
    ArrayList<HomeReportProductivity> reportProductivities;

    public Boolean getSucces() {
        return succes;
    }

    public void setSucces(Boolean succes) {
        this.succes = succes;
    }

    public ArrayList<HomeReportProductivity> getReportProductivities() {
        return reportProductivities;
    }

    public void setReportProductivities(ArrayList<HomeReportProductivity> reportProductivities) {
        this.reportProductivities = reportProductivities;
    }
}