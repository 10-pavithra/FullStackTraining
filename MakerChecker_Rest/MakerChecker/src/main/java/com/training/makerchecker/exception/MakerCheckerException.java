package com.training.makerchecker.exception;

public class MakerCheckerException extends Exception{
	
	private String message;
	private int code;
	
	public MakerCheckerException(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}


	public int getCode() {
		return code;
	}


	
	

}
