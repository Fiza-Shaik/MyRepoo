package com.cg.exception;

import java.util.Date;

public class ErrorDetail {
	private Date timeStramp;
	private String message;
	private String details;
	public ErrorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetail(Date timeStramp, String message, String details) {
		super();
		this.timeStramp = timeStramp;
		this.message = message;
		this.details = details;
	}
	public Date getTimeStramp() {
		return timeStramp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	

}
