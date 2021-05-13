package com.shaco.heroproject.entity;

import java.util.List;

public class AllHeroResult {
	private int error_code;
	private List<Result_AllHero> result;

	public AllHeroResult(int error_code, List<Result_AllHero> result) {
		super();
		this.error_code = error_code;
		this.result = result;
	}

	public AllHeroResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public List<Result_AllHero> getResult() {
		return result;
	}

	public void setResult(List<Result_AllHero> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "AllHeroResult [error_code=" + error_code + "]";
	}

}
