package com.shaco.heroproject.entity;

import java.util.List;

/**
 * Created by dllo on 15/10/31.
 */
public class HeroTeam {
    private List<HeroParter> parter;
    private List<HeroAgainst > against;

    public List<HeroParter> getParter() {
        return parter;
    }

    public void setParter(List<HeroParter> parter) {
        this.parter = parter;
    }

    public List<HeroAgainst> getAgainst() {
        return against;
    }

    public void setAgainst(List<HeroAgainst> against) {
        this.against = against;
    }

    @Override
    public String toString() {
        return "HeroTeam{" +
                "parter=" + parter +
                ", against=" + against +
                '}';
    }
}
