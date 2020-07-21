package com.exercise.auction.exception;

import java.util.List;

public class AuctionExceptionResponse {

	private String message;
	private List<String> details;

	public AuctionExceptionResponse(String msg, List<String> details) {
		this.message= msg;		
	}
	public String getMessage() {
		return message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}
