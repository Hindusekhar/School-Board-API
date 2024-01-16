package com.school.sba.exception;

public class UserNotFoundById extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public UserNotFoundById(String message)
	{	
		this.message = message;
	}
	
	

}
