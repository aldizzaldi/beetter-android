package com.example.beetter.model;

import com.google.gson.annotations.SerializedName;

public class App {
    @SerializedName("name")
    String name;

    @SerializedName("duration")
    String duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
