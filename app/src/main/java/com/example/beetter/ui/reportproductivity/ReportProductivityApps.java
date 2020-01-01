package com.example.beetter.ui.reportproductivity;

import com.example.beetter.model.Apps;
import com.example.beetter.model.User;
import com.google.gson.annotations.SerializedName;

public class ReportProductivityApps {
    @SerializedName("user")
    User user;

    @SerializedName("value")
    float[] percentProductivities;

    @SerializedName("app")
    Apps apps;

    @SerializedName("time_consumed")
    double timeConsumed;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float[] getPercentProductivities() {
        return percentProductivities;
    }

    public void setPercentProductivities(float[] percentProductivities) {
        this.percentProductivities = percentProductivities;
    }

    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    public double getTimeConsumed() {
        return timeConsumed;
    }

    public void setTimeConsumed(double timeConsumed) {
        this.timeConsumed = timeConsumed;
    }
}
