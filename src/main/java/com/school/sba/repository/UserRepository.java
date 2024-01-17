package com.school.sba.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.school.enums.UserRole;
import com.school.sba.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>
{
	boolean existsByUserRole(UserRole userRole);
   
}
