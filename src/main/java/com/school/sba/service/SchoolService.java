package com.school.sba.service;

import org.springframework.http.ResponseEntity;

import com.school.requestdto.UserRequest;
import com.school.responsedto.UserResponse;
import com.school.sba.entity.School;
import com.school.sba.entity.User;
import com.school.sba.util.ResponseStructure;

public interface SchoolService 
{
	School save(String schoolName,long contactNo, String emailId,String address);
	
	School findById(int schoolId);
	
	String delet(int schoolId);
	
	School update(School school,int schoolId);

}
