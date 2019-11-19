package com.example.beetter.model;

import com.google.gson.annotations.SerializedName;

public class GetUserResponse {
    @SerializedName("user")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
