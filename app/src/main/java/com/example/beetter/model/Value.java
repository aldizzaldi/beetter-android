package com.example.beetter.model;

import com.google.gson.annotations.SerializedName;

public class Value {
    @SerializedName("productive_value")
    double productiveValue;
    @SerializedName("netral_value")
    double netralValue;
    @SerializedName("non_productive_value")
    double nonProductiveValue;

    public double getProductiveValue() {
        return productiveValue;
    }

    public void setProductiveValue(double productiveValue) {
        this.productiveValue = productiveValue;
    }

    public double getNetralValue() {
        return netralValue;
    }

    public void setNetralValue(double netralValue) {
        this.netralValue = netralValue;
    }

    public double getNonProductiveValue() {
        return nonProductiveValue;
    }

    public void setNonProductiveValue(double nonProductiveValue) {
        this.nonProductiveValue = nonProductiveValue;
    }
}
