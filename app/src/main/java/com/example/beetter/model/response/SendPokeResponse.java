package com.example.beetter.model.response;

import com.example.beetter.model.Poke;
import com.google.gson.annotations.SerializedName;

public class SendPokeResponse {
    @SerializedName("succces")
    Boolean success;

    @SerializedName("data")
    Poke poke;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Poke getPoke() {
        return poke;
    }

    public void setPoke(Poke poke) {
        this.poke = poke;
    }
}
