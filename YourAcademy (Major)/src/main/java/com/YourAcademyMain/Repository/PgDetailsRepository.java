package com.YourAcademyMain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.YourAcademyMain.Model.PgDetails;

public interface PgDetailsRepository extends JpaRepository<PgDetails, Integer>{
	
}
