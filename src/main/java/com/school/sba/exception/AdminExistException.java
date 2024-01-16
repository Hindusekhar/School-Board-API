package com.school.sba.exception;

public class AdminExistException extends RuntimeException 
{
	private String message;

	public AdminExistException(String message) 
	{
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
