package com.YourAcademyMain.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.YourAcademyMain.Model.PgDetails;
import com.YourAcademyMain.Repository.PgDetailsRepository;
import com.YourAcademyMain.Service.PgServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PgController {

	private PgDetailsRepository pgRepo;
	
	private PgServiceImpl pgImpl;
	
	public PgController(PgDetailsRepository pgRepo, PgServiceImpl pgImpl) {
		this.pgRepo = pgRepo;
		this.pgImpl = pgImpl;
	}
	
//	@RequestMapping("/getReviews")
//	public String getPgReviews(Model model) {
//		model.addAttribute("reviews", pgRepo.findAll());
//		return ""
//	}
	
	@RequestMapping("pg")
	public String pg(Model model) throws Exception{
		List<PgDetails> list = pgImpl.getReview();
		model.addAttribute("reviews", list);
		return "PG/pg";
	}

	@GetMapping("addReview")
	public String ShowReview() {
		return "PG/addReview";
	}
	
	@PostMapping("reviewPost")
	public String addReview(HttpServletRequest http) {

		String userName = http.getParameter("userName");
		String pgName = http.getParameter("pgName");
		String userReview = http.getParameter("userReview");
		
		PgDetails details = new PgDetails(new Random().nextInt(100), userName, pgName, userReview);
		pgRepo.save(details);
		
//		System.out.println("Username is "+userName+"\nPgName is "+pgName+"\nReview is : "+userReview);
		
		return "redirect:/pg";
	}

	// This is for
	@GetMapping("/Map/")
	public String home() {
		return "map";
	}
	
	
	@RequestMapping("ManglamPg")
	public String pg_1() {
		return "PG/ManglamPg";
	}

	@RequestMapping("review")
	public String pgReview() {
		return "PG/review";
	}
}
