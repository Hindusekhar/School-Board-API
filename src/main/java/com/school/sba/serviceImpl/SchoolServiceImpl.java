package com.school.sba.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.requestdto.UserRequest;
import com.school.responsedto.UserResponse;
import com.school.sba.entity.School;
import com.school.sba.entity.User;
import com.school.sba.repository.SchoolRepository;
import com.school.sba.service.SchoolService;
import com.school.sba.util.ResponseStructure;


@Service
public  class SchoolServiceImpl implements SchoolService 
{
	@Autowired	
	private SchoolRepository schoolRepository;
	
	@Override
	public School save(String schoolName, long contactNo, String emailId, String address) {
		School school=new School();
		school.setSchoolName(schoolName);
		school.setContactNo(contactNo);
		school.setEmailId(emailId);
		school.setAddress(address);
		
		return schoolRepository.save(school);
		
		
		
	}
	
	@Override
	public School findById(int schoolId) 
	{
		
		Optional<School> optional = schoolRepository.findById(schoolId);
		if(optional.isPresent())
		{
			School school = optional.get();
			return school;
		}
		else 
			return null;
	}

	@Override
	public String delet(int schoolId)
	{
		schoolRepository.deleteById(schoolId);
		return "deleted details of id "+schoolId;
	}

	@Override
	public School update(School school, int schoolId) 
	{
		Optional<School> optional = schoolRepository.findById(schoolId);
		if(optional.isPresent())
		{
			School existingschool = optional.get();
			school.setSchoolId(existingschool.getSchoolId());
			return schoolRepository.save(school);
		}else
		return null;
	}

	

	
	
	
	

	

	
	
	
	

}
