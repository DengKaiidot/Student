package com.studentTest.bean;

public class Struct {
    private String name;
    private double precent;

    @Override
    public String toString() {
        return "Struct{" +
                "name='" + name + '\'' +
                ", precent=" + precent +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecent() {
        return precent;
    }

    public void setPrecent(double precent) {
        this.precent = precent;
    }
}
