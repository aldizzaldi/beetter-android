package com.example.beetter.model.response;

import com.example.beetter.model.User;
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
