package com.school.sba.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.school.sba.exception.DuplicateEntryFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler
{
	private ResponseEntity<Object> responseStructure(HttpStatus status, String message, Object rootCause )
	{
		return new ResponseEntity<Object>(Map.of("status",status.value(),"message", message,"rootCause",rootCause),status);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) 
	{
		List<ObjectError> allErrors = ex.getAllErrors();
		
		Map<String, String> errors= new HashMap<String, String>();
		allErrors.forEach(error ->
		{FieldError fieldError= (FieldError) error;
		errors.put(fieldError.getField(),fieldError.getDefaultMessage());
		});
		return  responseStructure(HttpStatus.BAD_REQUEST,"failed to save the userdate", errors);
	}
	
	
	@ExceptionHandler(DuplicateEntryFoundException.class)
	public ResponseEntity<Object> handlerOfDuplicateEntryFoundException(DuplicateEntryFoundException ex)
	{
		
		return responseStructure(HttpStatus.NOT_FOUND, ex.getMessage(),"Duplicate entry found ");
		
	}
	

}
