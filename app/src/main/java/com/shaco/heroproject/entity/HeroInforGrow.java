package com.shaco.heroproject.entity;

/**
 * Created by dllo on 15/10/30.
 */
public class HeroInforGrow {
    private String base;//基础
    private String rate;//成长

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "HeroInforGrow{" +
                "base='" + base + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
