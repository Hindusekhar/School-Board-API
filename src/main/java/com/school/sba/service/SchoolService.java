package com.school.sba.service;

import com.school.sba.entity.School;

public interface SchoolService 
{
	School save(String schoolName,long contactNo, String emailId,String address);
	
	School findById(int schoolId);
	
	String delet(int schoolId);
	
	School update(School school,int schoolId);

}
