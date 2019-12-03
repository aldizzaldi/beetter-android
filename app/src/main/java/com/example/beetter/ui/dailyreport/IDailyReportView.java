package com.example.beetter.ui.dailyreport;

import java.util.ArrayList;

public interface IDailyReportView {
    void getDailyReport(ArrayList<DailyReport> dailyReports);
    void showError(String message);
}
