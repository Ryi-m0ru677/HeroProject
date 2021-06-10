package com.shaco.heroproject.entity;

/**
 * Created by dllo on 15/10/31.
 */
public class HeroAgainst {
    private String hid;
    private String img;
    private String name_c;
    private String skill_desc_1;
    private String skill_desc_2;
    private String skill_img_1;
    private String skill_img_2;
    private String title;

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName_c() {
        return name_c;
    }

    public void setName_c(String name_c) {
        this.name_c = name_c;
    }

    public String getSkill_desc_1() {
        return skill_desc_1;
    }

    public void setSkill_desc_1(String skill_desc_1) {
        this.skill_desc_1 = skill_desc_1;
    }

    public String getSkill_desc_2() {
        return skill_desc_2;
    }

    public void setSkill_desc_2(String skill_desc_2) {
        this.skill_desc_2 = skill_desc_2;
    }

    public String getSkill_img_1() {
        return skill_img_1;
    }

    public void setSkill_img_1(String skill_img_1) {
        this.skill_img_1 = skill_img_1;
    }

    public String getSkill_img_2() {
        return skill_img_2;
    }

    public void setSkill_img_2(String skill_img_2) {
        this.skill_img_2 = skill_img_2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "HeroAgainst{" +
                "hid='" + hid + '\'' +
                ", img='" + img + '\'' +
                ", name_c='" + name_c + '\'' +
                ", skill_desc_1='" + skill_desc_1 + '\'' +
                ", skill_desc_2='" + skill_desc_2 + '\'' +
                ", skill_img_1='" + skill_img_1 + '\'' +
                ", skill_img_2='" + skill_img_2 + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
