package com.example.beetter.ui.home;

import com.example.beetter.model.User;
import com.google.gson.annotations.SerializedName;

public class DataMembers {
    @SerializedName("manager")
    User manager;

    @SerializedName("frontend")
    User[] frontend;

    @SerializedName("backend")
    User[] backend;

    @SerializedName("uiux")
    User[] uiux;

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User[] getFrontend() {
        return frontend;
    }

    public void setFrontend(User[] frontend) {
        this.frontend = frontend;
    }

    public User[] getBackend() {
        return backend;
    }

    public void setBackend(User[] backend) {
        this.backend = backend;
    }

    public User[] getUiux() {
        return uiux;
    }

    public void setUiux(User[] uiux) {
        this.uiux = uiux;
    }
}
