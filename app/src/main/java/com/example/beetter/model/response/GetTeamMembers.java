package com.example.beetter.model.response;


import com.example.beetter.ui.home.DataMembers;
import com.google.gson.annotations.SerializedName;

public class GetTeamMembers {
    @SerializedName("success")
    Boolean success;

    @SerializedName("data")
    DataMembers dataMembersMembersTeam;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DataMembers getDataMembersMembersTeam() {
        return dataMembersMembersTeam;
    }

    public void setDataMembersMembersTeam(DataMembers dataMembersMembersTeam) {
        this.dataMembersMembersTeam = dataMembersMembersTeam;
    }
}
