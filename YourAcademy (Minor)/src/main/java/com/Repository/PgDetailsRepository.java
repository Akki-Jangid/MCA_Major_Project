package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Model.PgDetails;

public interface PgDetailsRepository extends JpaRepository<PgDetails, Integer>{
	
}
