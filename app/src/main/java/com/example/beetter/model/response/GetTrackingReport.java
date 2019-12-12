package com.example.beetter.model.response;

import com.example.beetter.ui.home.HomeReportProductivity;
import com.example.beetter.ui.reportproductivity.ReportProductivityApps;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetTrackingReport {
    @SerializedName("success")
    Boolean success;

    public ArrayList<ReportProductivityApps> getReportProductivitiesApps() {
        return reportProductivitiesApps;
    }

    public void setReportProductivitiesApps(ArrayList<ReportProductivityApps> reportProductivitiesApps) {
        this.reportProductivitiesApps = reportProductivitiesApps;
    }

    @SerializedName("data")
    ArrayList<ReportProductivityApps> reportProductivitiesApps;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
