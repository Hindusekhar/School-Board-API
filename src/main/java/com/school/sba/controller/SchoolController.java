package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.entity.School;
import com.school.sba.serviceImpl.SchoolServiceImpl;

@RestController
@RequestMapping(value="/school")
public class SchoolController
{
	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	

	@PostMapping
	public School save(@RequestParam String schoolName,@RequestParam long contactNo,@RequestParam String emailId,@RequestParam String address) 
	{
		return schoolServiceImpl.save(schoolName,contactNo,emailId,address);
	}
	
	@GetMapping
	public School findById(@RequestParam int schoolId) 
	{
		return schoolServiceImpl.findById(schoolId);
	}
	@DeleteMapping
	public String delet(@RequestParam int schoolId)
	{
		return schoolServiceImpl.delet(schoolId);
	
	}
	
	@PutMapping
	public School update(@RequestBody School school,@RequestParam int schoolId) 
	{
		return schoolServiceImpl.update(school, schoolId) ;
		
	
	}

}
