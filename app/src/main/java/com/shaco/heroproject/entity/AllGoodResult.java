package com.shaco.heroproject.entity;

import java.util.List;

public class AllGoodResult {
	private String error_code;
	private List<Result_Good> result;
	public AllGoodResult(String error_code, List<Result_Good> result) {
		super();
		this.error_code = error_code;
		this.result = result;
	}
	public AllGoodResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public List<Result_Good> getResult() {
		return result;
	}
	public void setResult(List<Result_Good> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "AllGoodResult [error_code=" + error_code + "]";
	}
	
}
