package com.example.beetter.model;

import com.google.gson.annotations.SerializedName;

public class Poke {

    @SerializedName("content")
    String content;

    @SerializedName("id_user")
    int idUser;

    @SerializedName("id_team")
    int idTeam;

    @SerializedName("updated_at")
    String updatedAt;

    @SerializedName("created_at")
    String createdAt;

    @SerializedName("id")
    int id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
