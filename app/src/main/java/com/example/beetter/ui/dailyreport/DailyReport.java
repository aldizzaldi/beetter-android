package com.example.beetter.ui.dailyreport;

import com.example.beetter.model.Daily;
import com.example.beetter.model.Obstacles;
import com.example.beetter.model.User;
import com.google.gson.annotations.SerializedName;

public class DailyReport {
    @SerializedName("user")
    User user;
    @SerializedName("daily")
    Daily daily;
    @SerializedName("obstacle")
    Obstacles[] obstacles;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public Obstacles getObstacles() {
        return obstacles[0];
    }

    public void setObstacles(Obstacles[] obstacles) {
        this.obstacles = obstacles;
    }
}
