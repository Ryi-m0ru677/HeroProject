package com.shaco.heroproject.entity;

public class Results {
	private String btn_text;
	private String comment_count;
	private String content;
	private String img;
	private String img_big;
	private String obj_name;
	private String obj_url;
	private String title;
	private String url;
	private String view_count;

	public Results(String btn_text, String comment_count, String content,
			String img, String img_big, String obj_name, String obj_url,
			String title, String url, String view_count) {
		super();
		this.btn_text = btn_text;
		this.comment_count = comment_count;
		this.content = content;
		this.img = img;
		this.img_big = img_big;
		this.obj_name = obj_name;
		this.obj_url = obj_url;
		this.title = title;
		this.url = url;
		this.view_count = view_count;
	}

	public Results() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBtn_text() {
		return btn_text;
	}

	public void setBtn_text(String btn_text) {
		this.btn_text = btn_text;
	}

	public String getComment_count() {
		return comment_count;
	}

	public void setComment_count(String comment_count) {
		this.comment_count = comment_count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg_big() {
		return img_big;
	}

	public void setImg_big(String img_big) {
		this.img_big = img_big;
	}

	public String getObj_name() {
		return obj_name;
	}

	public void setObj_name(String obj_name) {
		this.obj_name = obj_name;
	}

	public String getObj_url() {
		return obj_url;
	}

	public void setObj_url(String obj_url) {
		this.obj_url = obj_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getView_count() {
		return view_count;
	}

	public void setView_count(String view_count) {
		this.view_count = view_count;
	}

	@Override
	public String toString() {
		return "Results [btn_text=" + btn_text + ", comment_count="
				+ comment_count + ", content=" + content + ", img=" + img
				+ ", img_big=" + img_big + ", obj_name=" + obj_name
				+ ", obj_url=" + obj_url + ", title=" + title + ", url=" + url
				+ ", view_count=" + view_count + "]";
	}

}
