package com.example.beetter.model;

import com.google.gson.annotations.SerializedName;

public class Daily {
    @SerializedName("id")
    int id;
    @SerializedName("id_team")
    int idTeam;
    @SerializedName("id_user")
    int iduser;
    @SerializedName("last_24_hour_activities")
    String yangSudahDikerjakan;
    @SerializedName("next_24_hour_activities")
    String yangAkanDikerjakan;
    @SerializedName("created_at")
    String tanggalDibuat;
    @SerializedName("updated_at")
    String tanggalDiupdate;

    public String getTanggalDiupdate() {
        return tanggalDiupdate;
    }

    public void setTanggalDiupdate(String tanggalDiupdate) {
        this.tanggalDiupdate = tanggalDiupdate;
    }

    public String getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(String tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getYangSudahDikerjakan() {
        return yangSudahDikerjakan;
    }

    public void setYangSudahDikerjakan(String yangSudahDikerjakan) {
        this.yangSudahDikerjakan = yangSudahDikerjakan;
    }

    public String getYangAkanDikerjakan() {
        return yangAkanDikerjakan;
    }

    public void setYangAkanDikerjakan(String yangAkanDikerjakan) {
        this.yangAkanDikerjakan = yangAkanDikerjakan;
    }
}
