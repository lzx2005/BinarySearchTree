package com.john.binarysearchtree;

public class UnderflowException extends Exception {
	private String message;

	public UnderflowException(String message) {
		super();
		this.message = message;
	}
}
