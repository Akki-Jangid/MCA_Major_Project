package com.YourAcademyMain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.YourAcademyMain.Model.User;
import com.YourAcademyMain.Repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {

		String password=(user.getPass());
		user.setPass(password);
		User newuser = userRepo.save(user);

		return newuser;
	}

	
	@Override
	public boolean checkEmail(String email) {
		
		return userRepo.existsByEmail(email);
	}
	
	
	@Override
	public User getByEmail(String email) {
		return userRepo.findByEmail(email);
	}


	@Override
	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}


	@Override
	public boolean checkMobile(String mobile) {
		return userRepo.existsByMobile(mobile);
	}

}
