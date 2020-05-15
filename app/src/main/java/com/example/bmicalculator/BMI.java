package com.example.bmicalculator;

public class BMI {
    private int ID;
    private long dateWeighed;
    private double weight;
    private double index;

    public BMI(int ID, long dateWeighed, double weight, double index) {
        this.ID = ID;
        this.dateWeighed = dateWeighed;
        this.weight = weight;
        this.index = index;
    }

    public long getDateWeighed() {
        return dateWeighed;
    }

    public double getWeight() {
        return weight;
    }

    public double getIndex() {
        return index;
    }
}
