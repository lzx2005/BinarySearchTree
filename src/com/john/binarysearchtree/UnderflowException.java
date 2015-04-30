package com.john.binarysearchtree;

public class UnderflowException extends Exception {
	private String message;

	public UnderflowException(String message) {
		super();
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
