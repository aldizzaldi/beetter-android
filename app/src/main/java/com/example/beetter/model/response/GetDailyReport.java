package com.example.beetter.model.response;

import com.google.gson.annotations.SerializedName;

public class GetDailyReport {
    @SerializedName("id")
    int id;

    @SerializedName("date")
    String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
