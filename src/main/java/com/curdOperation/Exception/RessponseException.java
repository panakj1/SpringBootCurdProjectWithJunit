package com.curdOperation.Exception;

public class RessponseException {
	
	private String text;
	private String error;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public RessponseException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RessponseException(String text, String error) {
		super();
		this.text = text;
		this.error = error;
	}

}
