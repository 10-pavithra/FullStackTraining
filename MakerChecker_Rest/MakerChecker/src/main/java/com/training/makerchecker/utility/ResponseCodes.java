package com.training.makerchecker.utility;

public enum ResponseCodes {
	
	Success(200),
	Error(500);

	private int responseCode;

	public int getResponseCode() {
		return responseCode;
	}

	private ResponseCodes(int responseCode) {
		this.responseCode = responseCode;
	}
	
}
