package com.example.beetter.ui.reportproductivity;

import java.util.ArrayList;

public interface IReportProductivityView {
    void getReportProductivity(ArrayList<ReportProductivityApps> reportProductivityApps);
    void showError(String message);
}
