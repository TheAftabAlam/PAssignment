package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Product;
import com.assignment.service.ProductService;

@RestController
@CrossOrigin(origins = "https://api.publicapis.org/")
public class ProductController {
		
	@Autowired
	private ProductService productService;
	
	@PostMapping("ADD/entry")
	public ResponseEntity<Product> addProductEntity (@RequestBody Product product) throws Exception
	{
		Product products= productService.addProduct(product);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	
	
	@GetMapping("GET/entries")
	public ResponseEntity<List<Product>> getAllProductHandler()
	{
		List<Product> products= productService.getProducts();
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@GetMapping("GET/random")
	public ResponseEntity<List<Product>> getSingleEntity(@RequestParam(required = false) String keyword) throws Exception
	{
		if(keyword.contains("&"))
		{
			String[] strings= keyword.split("&");
			List<Product> products= productService.getSingleEntry(strings[0]);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}
		if(keyword.contains(" "))
		{
			String[] strings= keyword.split(" ");
			List<Product> products= productService.getSingleEntry(strings[0]);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}
		
		List<Product> products= productService.getSingleEntry(keyword);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@GetMapping("GET/categories")
	public ResponseEntity<List<String>> getAllCategoriesHandler() 
	{
		List<String> categories= productService.getAllCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	


}
