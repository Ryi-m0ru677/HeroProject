package com.shaco.heroproject.entity;

import java.util.List;

public class VideoResult {
	private int error_code;
	private List<Results> result;

	public VideoResult(int error_code, List<Results> result) {
		super();
		this.error_code = error_code;
		this.result = result;
	}

	public VideoResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public List<Results> getResult() {
		return result;
	}

	public void setResult(List<Results> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "VideoResult [error_code=" + error_code + "]";
	}

}
