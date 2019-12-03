package com.example.beetter.ui.home;

import com.example.beetter.model.User;
import com.example.beetter.model.Value;
import com.google.gson.annotations.SerializedName;

public class ReportProductivity {
    @SerializedName("user")
    User user;
    @SerializedName("value")
    Value value;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
