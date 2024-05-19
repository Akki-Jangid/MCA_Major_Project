package com.YourAcademyMain.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PgDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userName;
	private String pgName;
	private String reviews;

	public PgDetails(String userName, String pgName, String reviews) {
		this.userName = userName;
		this.pgName = pgName;
		this.reviews= reviews;
	}
}
