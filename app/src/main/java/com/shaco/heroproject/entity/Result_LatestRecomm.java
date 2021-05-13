package com.shaco.heroproject.entity;

/**
 * Created by dllo on 15/10/26.
 */
public class Result_LatestRecomm {
    private String article_id;
    private String ban_img;
    private int comment_count;
    private String name;

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getBan_img() {
        return ban_img;
    }

    public void setBan_img(String ban_img) {
        this.ban_img = ban_img;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Result_LatestRecomm{" +
                "article_id='" + article_id + '\'' +
                ", ban_img='" + ban_img + '\'' +
                ", comment_count=" + comment_count +
                ", name='" + name + '\'' +
                '}';
    }
}
