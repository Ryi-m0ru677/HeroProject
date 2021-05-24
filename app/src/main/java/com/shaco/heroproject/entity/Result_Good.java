package com.shaco.heroproject.entity;

public class Result_Good {
	private String icon;
	private String id;
	private String name;
	public Result_Good(String icon, String id, String name) {
		super();
		this.icon = icon;
		this.id = id;
		this.name = name;
	}
	public Result_Good() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Result_good [icon=" + icon + ", id=" + id + ", name=" + name
				+ "]";
	}
	
}
