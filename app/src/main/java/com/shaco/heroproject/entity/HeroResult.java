package com.shaco.heroproject.entity;

/**
 * Infor的总类
 * Created by dllo on 15/10/29.
 */
public class HeroResult {
    private int error_code;
    private HeroInforResult result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public HeroInforResult getResult() {
        return result;
    }

    public void setResult(HeroInforResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HeroResult{" +
                "error_code=" + error_code +
                ", result=" + result +
                '}';
    }
}
