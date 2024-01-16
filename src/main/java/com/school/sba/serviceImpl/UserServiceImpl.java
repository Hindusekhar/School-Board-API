package com.school.sba.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.enums.UserRole;
import com.school.requestdto.UserRequest;
import com.school.responsedto.UserResponse;
import com.school.sba.entity.User;
import com.school.sba.exception.AdminExistException;
import com.school.sba.repository.UserRepository;
import com.school.sba.service.UserService;
import com.school.sba.util.ResponseStructure;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userRepository;
	@Autowired
	private ResponseStructure<UserResponse> responseStructure;

	private User mapToUser(UserRequest userRequest)
	{
		User user=new User();
		user.setUserRole(userRequest.getUserRole());
		user.setUserName(userRequest.getUserName());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setContactNo(userRequest.getContactNo());
		return user;
	}

	private UserResponse mapToUserResponse(User user) 
	{
		UserResponse userResponse= new UserResponse();
		userResponse.setUserId(user.getUserId());
		userResponse.setUserRole(user.getUserRole());
		userResponse.setUserName(user.getUserName());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setEmail(user.getEmail());
		userResponse.setContactNo(user.getContactNo());

		return userResponse;
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(UserRequest userRequest) 
	{
		if(userRequest.getUserRole().equals(UserRole.ADMIN))
		{
			if(userRepository.existsByUserRole(userRequest.getUserRole())==false)
			{
				
				User user = userRepository.save(mapToUser(userRequest));

				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setMesaage("user Details Registered Successfully");
				responseStructure.setData(mapToUserResponse(user));
			}else {
				throw new AdminExistException("Admin Already Exist");
			}
		}else
		{
			User user = userRepository.save(mapToUser(userRequest));

			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMesaage("user Details Registered Successfully");
			responseStructure.setData(mapToUserResponse(user));
		}
		return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.CREATED);
	}

}
