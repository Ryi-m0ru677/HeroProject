package com.shaco.heroproject.entity;


import java.util.List;

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

    private List<HeroSkill> skill;

    private HeroInforGrow v1;//血量与成长
    private HeroInforGrow v2;//蓝量
    private HeroInforGrow v3;//物攻
    private HeroInforGrow v4;//攻速
    private HeroInforGrow v5;//物防
    private String v6;//暴击
    private String v7;
    private String v8;//移动速度
    private String v9;//物理减免
    private HeroInforGrow v10;//生命恢复
    private HeroInforGrow v11;//魔法恢复
    private String v12;
    private HeroInforGrow v13;//魔抗
    private String v14;
    private String v15;//暴击加成
    private String v16;
    private String v17;//攻击范围
    private String v18;//法术减免

    private String analyse;//英雄定位

    public HeroInforGrow getV1() {
        return v1;
    }

    public void setV1(HeroInforGrow v1) {
        this.v1 = v1;
    }

    public HeroInforGrow getV2() {
        return v2;
    }

    public void setV2(HeroInforGrow v2) {
        this.v2 = v2;
    }

    public HeroInforGrow getV3() {
        return v3;
    }

    public void setV3(HeroInforGrow v3) {
        this.v3 = v3;
    }

    public HeroInforGrow getV4() {
        return v4;
    }

    public void setV4(HeroInforGrow v4) {
        this.v4 = v4;
    }

    public HeroInforGrow getV5() {
        return v5;
    }

    public void setV5(HeroInforGrow v5) {
        this.v5 = v5;
    }

    public String getV6() {
        return v6;
    }

    public void setV6(String v6) {
        this.v6 = v6;
    }

    public String getV7() {
        return v7;
    }

    public void setV7(String v7) {
        this.v7 = v7;
    }

    public String getV8() {
        return v8;
    }

    public void setV8(String v8) {
        this.v8 = v8;
    }

    public String getV9() {
        return v9;
    }

    public void setV9(String v9) {
        this.v9 = v9;
    }

    public HeroInforGrow getV10() {
        return v10;
    }

    public void setV10(HeroInforGrow v10) {
        this.v10 = v10;
    }

    public HeroInforGrow getV11() {
        return v11;
    }

    public void setV11(HeroInforGrow v11) {
        this.v11 = v11;
    }

    public String getV12() {
        return v12;
    }

    public void setV12(String v12) {
        this.v12 = v12;
    }

    public HeroInforGrow getV13() {
        return v13;
    }

    public void setV13(HeroInforGrow v13) {
        this.v13 = v13;
    }

    public String getV14() {
        return v14;
    }

    public void setV14(String v14) {
        this.v14 = v14;
    }

    public String getV15() {
        return v15;
    }

    public void setV15(String v15) {
        this.v15 = v15;
    }

    public String getV16() {
        return v16;
    }

    public void setV16(String v16) {
        this.v16 = v16;
    }

    public String getV17() {
        return v17;
    }

    public void setV17(String v17) {
        this.v17 = v17;
    }

    public String getV18() {
        return v18;
    }

    public void setV18(String v18) {
        this.v18 = v18;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
    }

    public List<HeroSkill> getSkill() {
        return skill;
    }

    public void setSkill(List<HeroSkill> skill) {
        this.skill = skill;
    }

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



}
