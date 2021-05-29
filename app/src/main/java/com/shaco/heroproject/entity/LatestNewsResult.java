package com.shaco.heroproject.entity;

import java.util.List;

/**
 * Created by dllo on 15/10/26.
 */
public class LatestNewsResult {

    private int cid_rel;
    private String error_code;
    private List<Result_LatestNews> result;
    private List<Result_LatestRecomm> recomm;

    public int getCid_rel() {
        return cid_rel;
    }

    public void setCid_rel(int cid_rel) {
        this.cid_rel = cid_rel;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public List<Result_LatestNews> getResult() {
        return result;
    }

    public void setResult(List<Result_LatestNews> result) {
        this.result = result;
    }

    public List<Result_LatestRecomm> getRecomms() {
        return recomm;
    }

    public void setRecomms(List<Result_LatestRecomm> recomms) {
        this.recomm = recomms;
    }

    @Override
    public String toString() {
        return "LatestNewsResult{" +
                "cid_rel=" + cid_rel +
                ", error_code='" + error_code + '\'' +
                ", result=" + result +
                ", recomms=" + recomm +
                '}';
    }
}
