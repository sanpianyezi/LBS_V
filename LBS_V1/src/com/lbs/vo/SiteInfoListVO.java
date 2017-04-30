package com.lbs.vo;

import java.util.List;

public class SiteInfoListVO {
    
	private String code;

	private String message;
	
	private List<SiteList> siteList;

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

	public List<SiteList> getSiteList() {
		return siteList;
	}

	public void setSiteList(List<SiteList> siteList) {
		this.siteList = siteList;
	}
	

	
}



