package com.school.sba.exception;

public class DuplicateEntryFoundException extends RuntimeException
{
	private String message;

	public DuplicateEntryFoundException(String message) 
	{	
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	
	
	
	

}
