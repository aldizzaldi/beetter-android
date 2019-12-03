package com.example.beetter.model.response;

import com.example.beetter.ui.home.ReportProductivity;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetTrackingReport {
    @SerializedName("success")
    Boolean success;
    @SerializedName("data")
    ArrayList<ReportProductivity> reportProductivities;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<ReportProductivity> getReportProductivities() {
        return reportProductivities;
    }

    public void setReportProductivities(ArrayList<ReportProductivity> reportProductivities) {
        this.reportProductivities = reportProductivities;
    }
}
