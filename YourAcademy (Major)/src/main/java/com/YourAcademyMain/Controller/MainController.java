package com.YourAcademyMain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.YourAcademyMain.Model.User;
import com.YourAcademyMain.Repository.UserRepository;
import com.YourAcademyMain.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/about")
	public String viewAbout() {
		return "about";
	}

	
	@RequestMapping("/facilities")
	public String viewFacilities() {
		return "facilities";
	}

	@RequestMapping("/notes")
	public String viewNotes() {
		return "notes";
	}

	@RequestMapping("/BuySell")
	public String viewBuySell() {
		return "/buy/BuySell";
	}

	@RequestMapping("/events")
	public String viewEvents() {
		return "events";
	}

	@RequestMapping("/contact")
	public String viewcontact() {
		return "contact";
	}

	@RequestMapping("/login")
	public String login() {
		return "Register/login";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "Register/register";
	}
	
	@GetMapping("/register")
	public String register() {
		return "Register/register";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session, Model m) {

		boolean checkMail = userService.checkEmail(user.getEmail());
		boolean checkMobile = userService.checkMobile(user.getMobile());
		User u = userService.saveUser(user);
		
		if(!(checkMail && checkMobile)) {
			System.out.println("Email/Mobile is already Exist...");
//			session.setAttribute("msg", "Email/Mobile is already Exist...");
//			return "redirect:/signup";
		} else if (user != null){
				session.setAttribute("msg", "Register Successfully");
		}
		else 
		{
				session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/signup";
	}
	
	
	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute User user, HttpSession session, Model m) {
		
		User getUser = userService.getByEmail(user.getEmail());
		String pass = user.getPass();
		
		
		if(user==null || getUser==null) {
			session.setAttribute("msg", "Wrong Details...");
		} else if(getUser.getPass().equals(pass)){
				session.setAttribute("msg", "Login Successfully");
			}else {
				session.setAttribute("msg", "Wrong Email or Password");
			}
		return "redirect:/login";
	}
}
