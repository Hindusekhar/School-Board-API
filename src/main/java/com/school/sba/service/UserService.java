package com.school.sba.service;

import org.springframework.http.ResponseEntity;

import com.school.requestdto.UserRequest;
import com.school.responsedto.UserResponse;
import com.school.sba.util.ResponseStructure;

public interface UserService 
{

	ResponseEntity<ResponseStructure<UserResponse>> registerUser(UserRequest userRequest);

	ResponseEntity<ResponseStructure<UserResponse>> deletUser(int userId);

	ResponseEntity<ResponseStructure<UserResponse>> findUniqueUser(int userId);
	
	

}
