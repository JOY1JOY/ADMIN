package com.manager.www.domain;


/**
 * 前台JSON页面数据
 * @author cookie
 *
 */
public class JsonMessage {

	private boolean success;
	private String message;
	private int errorCode;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
