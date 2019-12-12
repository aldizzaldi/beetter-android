package com.example.beetter.ui.reportproductivity;

import com.example.beetter.model.Apps;
import com.example.beetter.model.User;
import com.google.gson.annotations.SerializedName;

public class ReportProductivityApps {
    @SerializedName("user")
    User user;

    @SerializedName("values")
    double[] percentProductivities;

    @SerializedName("app")
    Apps apps;

    @SerializedName("time_consumed")
    int timeConsumed;
}
