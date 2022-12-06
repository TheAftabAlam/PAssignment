package com.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Product;
import com.assignment.repository.ProductDao;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;

	@Override
	public Product addProduct(Product product) throws Exception {
		Optional<Product> pOptional= productDao.findById(product.getProduct_Id());
		if(pOptional.isPresent())
		{
			return pOptional.get();
		}
		else {
			throw new Exception("Product already exist");
		}
	}
	
	@Override
	public List<Product> getProducts() {
	 List<Product> products=productDao.findAll();
		
		return products;
	}
	
	@Override
	public List<Product> getSingleEntry(String keyword) throws Exception {
		List<Product> products= productDao.getProduct(keyword);
		if(products.size()<=0)
		{
			throw new Exception("Not found");
		}
		
		return products;
	}

	@Override
	public List<String> getAllCategories() {
	List<String> categories=productDao.getAllCategories();
		return categories;
	}

	@Override
	public List<String> getHealth() {
	List<String> list=productDao.getAllhealth();
		return list;
	}

	

	
	

}
