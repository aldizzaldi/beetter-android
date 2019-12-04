package com.example.beetter.model.response;

import com.example.beetter.ui.dailyreport.DailyReport;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetDailyReportResponse {
    @SerializedName("success")
    Boolean success;
    @SerializedName("data")
    ArrayList<DailyReport> dailyReports;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<DailyReport> getDataDailyReport() {
        return dailyReports;
    }

    public void setDataDailyReport(ArrayList<DailyReport> dataDailyReport) {
        this.dailyReports = dataDailyReport;
    }

    @Override
    public String toString() {
        return "GetDailyReportResponse{" +
                "success=" + success +
                ", dailyReports=" + dailyReports +
                '}';
    }
}