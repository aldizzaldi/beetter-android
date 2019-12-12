package com.example.beetter.model;

import com.example.beetter.model.App;
import com.google.gson.annotations.SerializedName;

public class Apps {
    @SerializedName("productive")
    App[] productives;

    @SerializedName("netral")
    App[] netral;

    @SerializedName("not_prodductive")
    App[] unproductives;

    public App[] getProductives() {
        return productives;
    }

    public void setProductives(App[] productives) {
        this.productives = productives;
    }

    public App[] getNetral() {
        return netral;
    }

    public void setNetral(App[] netral) {
        this.netral = netral;
    }

    public App[] getUnproductives() {
        return unproductives;
    }

    public void setUnproductives(App[] unproductives) {
        this.unproductives = unproductives;
    }
}
