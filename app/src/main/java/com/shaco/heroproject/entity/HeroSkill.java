package com.shaco.heroproject.entity;

import java.io.Serializable;

/**
 * Created by dllo on 15/10/30.
 */
public class HeroSkill implements Serializable{
    private String cd;
    private String cost;
    private String desc;
    private String dist;
    private String hid;
    private String id;
    private String img;
    private String key;
    private String name;
    private String use_of_experience;

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUse_of_experience() {
        return use_of_experience;
    }

    public void setUse_of_experience(String use_of_experience) {
        this.use_of_experience = use_of_experience;
    }

    @Override
    public String toString() {
        return "HeroSkill{" +
                "cd='" + cd + '\'' +
                ", cost='" + cost + '\'' +
                ", desc='" + desc + '\'' +
                ", dist='" + dist + '\'' +
                ", hid='" + hid + '\'' +
                ", id='" + id + '\'' +
                ", img='" + img + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", use_of_experience='" + use_of_experience + '\'' +
                '}';
    }
}
