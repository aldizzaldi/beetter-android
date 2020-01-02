package com.example.beetter.model;

import com.example.beetter.model.App;
import com.google.gson.annotations.SerializedName;

public class Apps {
    @SerializedName("productive")
    App[] productives;

    @SerializedName("netral")
    App[] netral;

    @SerializedName("not_productive")
    App[] unproductives;

    public App[] getProductives() {
        return productives;
    }

    public App getProductivesSatuan(int i) {
        return productives[i];
    }

    public void setProductives(App[] productives) {
        this.productives = productives;
    }

    public App[] getNetral() {
        return netral;
    }

    public App getNetralSatuan(int i) {
        return netral[i];
    }


    public void setNetral(App[] netral) {
        this.netral = netral;
    }

    public App[] getUnproductives() {
        return unproductives;
    }

    public App getUnproductivesSatuan(int i) {
        return unproductives[i];
    }

    public void setUnproductives(App[] unproductives) {
        this.unproductives = unproductives;
    }
}
