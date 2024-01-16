package com.school.sba.exception;

public class SQLDataIntegretyViolationException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public SQLDataIntegretyViolationException(String message) 
	{
		this.message = message;
	}
	
}
