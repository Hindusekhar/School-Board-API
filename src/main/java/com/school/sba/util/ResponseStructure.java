package com.school.sba.util;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T>
{
	private int status;
	private String mesaage;
	private T data;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMesaage() {
		return mesaage;
	}
	public void setMesaage(String mesaage) {
		this.mesaage = mesaage;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
}
