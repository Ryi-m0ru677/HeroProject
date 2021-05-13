package com.shaco.heroproject.entity;

/**
 * Created by dllo on 15/10/26.
 */
public class Result_LatestNews {
    private int comment_count;
    private String icon;
    private String id;
//    private String short;
    private String source;
    private String title;

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Result_LatestNews{" +
                "comment_count=" + comment_count +
                ", icon='" + icon + '\'' +
                ", id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
