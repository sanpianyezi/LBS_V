package com.lbs.vo;

import java.util.List;

import com.lbs.model.UserTrajectory;


public class TrajListResult {
	
	private String code;
	private String message;
	private List<UserTrajectory> trajList;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<UserTrajectory> getTrajList() {
		return trajList;
	}
	public void setTrajList(List<UserTrajectory> trajList) {
		this.trajList = trajList;
	}

	
}
