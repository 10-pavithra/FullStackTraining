package com.training.makerchecker.exception;

public class MakerCheckerResponse {
	
	private int statusCodes;
	private String message;
	private Object data;
	
	
	public MakerCheckerResponse(int statusCodes, String message, Object data) {
		super();
		this.statusCodes = statusCodes;
		this.message = message;
		this.data = data;
	}
	
	
	public int getStatusCodes() {
		return statusCodes;
	}
	public void setStatusCodes(int statusCodes) {
		this.statusCodes = statusCodes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
