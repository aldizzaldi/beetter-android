package com.example.beetter.model;

import com.google.gson.annotations.SerializedName;

public class DetailsTeam {
    @SerializedName("id")
    int id;
    @SerializedName("room_code")
    String roomCode;
    @SerializedName("room_name")
    String roomName;
    @SerializedName("bussiness_hour_start")
    String bussinessHourStart;
    @SerializedName("bussiness_hour_end")
    String bussinessHourEnd;
    @SerializedName("created_at")
    String createdAt;
    @SerializedName("updated_at")
    String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBussinessHourStart() {
        return bussinessHourStart;
    }

    public void setBussinessHourStart(String bussinessHourStart) {
        this.bussinessHourStart = bussinessHourStart;
    }

    public String getBussinessHourEnd() {
        return bussinessHourEnd;
    }

    public void setBussinessHourEnd(String bussinessHourEnd) {
        this.bussinessHourEnd = bussinessHourEnd;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
