package com.example.beetter.model.response;

import com.example.beetter.ui.home.ReportProductivity;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetListMemberInTeamResponse {
    @SerializedName("success")
    Boolean succes;
    @SerializedName("data")
    ArrayList<ReportProductivity> reportProductivities;

    public Boolean getSucces() {
        return succes;
    }

    public void setSucces(Boolean succes) {
        this.succes = succes;
    }

    public ArrayList<ReportProductivity> getReportProductivities() {
        return reportProductivities;
    }

    public void setReportProductivities(ArrayList<ReportProductivity> reportProductivities) {
        this.reportProductivities = reportProductivities;
    }
}
