package com.lbs.vo;

import java.util.List;

public class BootStrapResult {
	
	private int total;
	private List<Object> rows;
	private String messages;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}

	
	
}
