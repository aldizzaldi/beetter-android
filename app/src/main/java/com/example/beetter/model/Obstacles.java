package com.example.beetter.model;

import com.google.gson.annotations.SerializedName;

public class Obstacles {
    @SerializedName("id")
    int id;
    @SerializedName("id_daily_scrum_report")
    int idDailyReport;
    @SerializedName("content")
    String masalah;
    @SerializedName("created_at")
    String tanggalDibuat;
    @SerializedName("updated_at")
    String tanggalDiupdate;

    public String getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(String tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public String getTanggalDiupdate() {
        return tanggalDiupdate;
    }

    public void setTanggalDiupdate(String tanggalDiupdate) {
        this.tanggalDiupdate = tanggalDiupdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDailyReport() {
        return idDailyReport;
    }

    public void setIdDailyReport(int idDailyReport) {
        this.idDailyReport = idDailyReport;
    }

    public String getMasalah() {
        return masalah;
    }

    public void setMasalah(String masalah) {
        this.masalah = masalah;
    }
}
