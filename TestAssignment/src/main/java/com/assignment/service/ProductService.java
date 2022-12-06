package com.assignment.service;

import java.util.List;

import com.assignment.model.Product;

public interface ProductService {
	
	
	public Product addProduct(Product product)throws Exception;
	public List<Product> getProducts();
	
	public List<Product> getSingleEntry(String keyword) throws Exception ;
	public List<String> getAllCategories();
	public List<String> getHealth();
	
}
