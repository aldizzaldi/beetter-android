package com.example.beetter.ui.listteam;

import com.example.beetter.model.DetailsTeam;
import com.example.beetter.model.User;
import com.google.gson.annotations.SerializedName;

public class DataTeam {
    @SerializedName("details")
    DetailsTeam[] detailsTeam;
    @SerializedName("manager")
    User[] user;

    public DetailsTeam getDetailsTeam() {
        return detailsTeam[0];
    }

    public void setDetailsTeam(DetailsTeam[] detailsTeam) {
        this.detailsTeam = detailsTeam;
    }

    public User getUser() {
        return user[0];
    }

    public void setUser(User[] user) {
        this.user = user;
    }
}
