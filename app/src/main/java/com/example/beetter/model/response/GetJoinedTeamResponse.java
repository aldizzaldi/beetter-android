package com.example.beetter.model.response;

import com.example.beetter.ui.listteam.DataTeam;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetJoinedTeamResponse {
    @SerializedName("success")
    Boolean success;
    @SerializedName("dataTeam")
    ArrayList<DataTeam> dataTeams;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<DataTeam> getDataTeams() {
        return dataTeams;
    }

    public void setDataTeams(ArrayList<DataTeam> dataTeams) {
        this.dataTeams = dataTeams;
    }
}
