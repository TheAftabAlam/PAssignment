package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.model.Product;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	
	@Query(value="select * from Product where title like %:keyword% or description like %:keyword% or auth like %:keyword%",nativeQuery = true)
	public List<Product> getProduct(@Param("keyword") String keyword);
	
	@Query("select Distinct(category) From Product")
	public List<String> getAllCategories();
	
	
	

}
