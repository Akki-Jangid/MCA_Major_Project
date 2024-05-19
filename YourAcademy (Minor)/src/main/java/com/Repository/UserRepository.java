package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Model.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	public boolean existsByEmail(String email);
	
	public boolean existsByMobile(String mobile);
	
	public User findByEmail(String email);
}
