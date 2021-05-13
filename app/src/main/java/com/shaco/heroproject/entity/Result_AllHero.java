package com.shaco.heroproject.entity;

public class Result_AllHero {
	private String id;
	private String img;
	private String name_c;
	private String tags;
	private String title;

	public Result_AllHero(String id, String img, String name_c, String tags,
			String title) {
		super();
		this.id = id;
		this.img = img;
		this.name_c = name_c;
		this.tags = tags;
		this.title = title;
	}

	public Result_AllHero() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getName_c() {
		return name_c;
	}

	public void setName_c(String name_c) {
		this.name_c = name_c;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Result_AllHero [id=" + id + ", img=" + img + ", name_c="
				+ name_c + ", tags=" + tags + ", title=" + title + "]";
	}

}
