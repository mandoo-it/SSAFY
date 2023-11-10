package com.ssafy.book;

public class DuplicateException extends Exception {
	public DuplicateException() {
		this("Duplication");
	}

	public DuplicateException(String msg) {
		super(msg);
	}
}
