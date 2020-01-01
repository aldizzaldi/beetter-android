package com.example.beetter.model.response;

import com.example.beetter.ui.home.HomeReportProductivity;
import com.example.beetter.ui.reportproductivity.ReportProductivityApps;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetTrackingReport {
    @SerializedName("success")
    Boolean success;

    @SerializedName("data")
    ArrayList<ReportProductivityApps> reportProductivityApps;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<ReportProductivityApps> getReportProductivityApps() {
        return reportProductivityApps;
    }

    public void setReportProductivityApps(ArrayList<ReportProductivityApps> reportProductivityApps) {
        this.reportProductivityApps = reportProductivityApps;
    }
}
