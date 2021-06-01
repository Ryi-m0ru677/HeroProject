package com.shaco.heroproject.entity;

/**
 * Infor的子类
 * Created by dllo on 15/10/29.
 */
public class HeroInforResult {
    private String name_c;
    private String price_score;
    private String price_rmb;
    private String img;   //头像
    private String img_top;   //顶部背景图
    private String title;  //外号
    private String tags;  //英雄定位
    private String physical_p; //物理伤害系数
    private String skill_attack_p;   //法术伤害系数
    private String life_p;   //防御系数
    private String operate_p;//难度系数

    public String getName_c() {
        return name_c;
    }

    public void setName_c(String name_c) {
        this.name_c = name_c;
    }

    public String getPrice_score() {
        return price_score;
    }

    public void setPrice_score(String price_score) {
        this.price_score = price_score;
    }

    public String getPrice_rmb() {
        return price_rmb;
    }

    public void setPrice_rmb(String price_rmb) {
        this.price_rmb = price_rmb;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg_top() {
        return img_top;
    }

    public void setImg_top(String img_top) {
        this.img_top = img_top;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPhysical_p() {
        return physical_p;
    }

    public void setPhysical_p(String physical_p) {
        this.physical_p = physical_p;
    }

    public String getSkill_attack_p() {
        return skill_attack_p;
    }

    public void setSkill_attack_p(String skill_attack_p) {
        this.skill_attack_p = skill_attack_p;
    }

    public String getLife_p() {
        return life_p;
    }

    public void setLife_p(String life_p) {
        this.life_p = life_p;
    }

    public String getOperate_p() {
        return operate_p;
    }

    public void setOperate_p(String operate_p) {
        this.operate_p = operate_p;
    }

    @Override
    public String toString() {
        return "HeroInforResult{" +
                "name_c='" + name_c + '\'' +
                ", price_score='" + price_score + '\'' +
                ", price_rmb='" + price_rmb + '\'' +
                ", img='" + img + '\'' +
                ", img_top='" + img_top + '\'' +
                ", title='" + title + '\'' +
                ", tags='" + tags + '\'' +
                ", physical_p='" + physical_p + '\'' +
                ", skill_attack_p='" + skill_attack_p + '\'' +
                ", life_p='" + life_p + '\'' +
                ", operate_p='" + operate_p + '\'' +
                '}';
    }
}
