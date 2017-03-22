package uk.co.valma.model;

import uk.co.valma.exception.PrimeException;

public class ErrorMessage {
	private int code;
	private String message;
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public ErrorMessage(PrimeException e) {
		super();
		this.code = e.getStatusCode();
		this.message = e.getMessage();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
