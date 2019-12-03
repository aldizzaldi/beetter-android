package com.example.beetter.model.dummy;

public class Member {

    private String name;
    private double percentproductivity;

    public Member(String name, double percentproductivity) {
        this.name = name;
        this.percentproductivity = percentproductivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentproductivity() {
        return percentproductivity;
    }

    public void setPercentproductivity(double percentproductivity) {
        this.percentproductivity = percentproductivity;
    }
}
