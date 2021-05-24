package com.shaco.heroproject.entity;

import java.util.List;

/**
 * Created by dllo on 15/10/26.
 */
public class AllSkillResult {
    private List<Result_AllSkill> result;
    private int error_code;

    public List<Result_AllSkill> getResult() {
        return result;
    }

    public void setResult(List<Result_AllSkill> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "AllSkillResult{" +
                "result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
