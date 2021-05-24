package com.shaco.heroproject.entity;

/**
 * Created by dllo on 15/10/26.
 */
public class Result_AllSkill {
    private String cd;
    private String description;
    private String direction_of_use;
    private String icon;
    private String id;
    private String img;
    private String level;
    private String name;

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirection_of_use() {
        return direction_of_use;
    }

    public void setDirection_of_use(String direction_of_use) {
        this.direction_of_use = direction_of_use;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Result_AllSkill{" +
                "cd='" + cd + '\'' +
                ", description='" + description + '\'' +
                ", direction_of_use='" + direction_of_use + '\'' +
                ", icon='" + icon + '\'' +
                ", id='" + id + '\'' +
                ", img='" + img + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
