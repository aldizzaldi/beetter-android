package com.example.beetter.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetJoinedTeamResponse {
    @SerializedName("success")
    Boolean success;
    @SerializedName("dataTeam")
    List<DataTeam> dataTeams;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<DataTeam> getDataTeams() {
        return dataTeams;
    }

    public void setDataTeams(List<DataTeam> dataTeams) {
        this.dataTeams = dataTeams;
    }
}
