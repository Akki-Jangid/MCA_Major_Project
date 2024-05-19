package com.Service;

import com.Model.User;

public interface UserService {
	
	public User saveUser(User user);

	public boolean checkEmail(String email);
	
	public boolean checkMobile(String mobile);
	
	public User getByEmail(String email);
	
	public void removeSessionMessage();

}

