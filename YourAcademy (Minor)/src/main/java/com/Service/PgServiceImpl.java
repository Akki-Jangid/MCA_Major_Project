package com.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Model.PgDetails;
import com.Repository.PgDetailsRepository;

@Service
public class PgServiceImpl  implements PgService{

	private PgDetailsRepository pgRepo;
	
	public PgServiceImpl(PgDetailsRepository pgRepo) {
		this.pgRepo = pgRepo;
	}
	
	@Override
	public List<PgDetails> getReview() throws Exception{
		List<PgDetails> list =  pgRepo.findAll();
		return list;
	}
	
	
}
