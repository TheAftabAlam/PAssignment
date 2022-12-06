package com.assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer product_Id;
	
	private String title;
	
	private String description;
	
	private Boolean https;
	
	private String cors;
	
	private String auth;
	
	private String category;

}
