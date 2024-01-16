package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.requestdto.UserRequest;
import com.school.responsedto.UserResponse;
import com.school.sba.service.UserService;
import com.school.sba.util.ResponseStructure;

@RestController
@RequestMapping(value="/users")
public class UserController
{
	@Autowired
	UserService userService;
	
	@PostMapping(value="/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody UserRequest userRequest)
	{
		return userService.registerUser(userRequest);
			
	}
	
	@DeleteMapping(value="/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> deletUser(@PathVariable int userId)
	{
		return userService.deletUser(userId);
	}
	

}
