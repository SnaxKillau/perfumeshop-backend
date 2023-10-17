package com.ite.perfumeshop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ite.perfumeshop.entity.Category;
import com.ite.perfumeshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> , JpaSpecificationExecutor<Product>{
	
	 List<Product> findByCategoriesIn(List<Category> categories);

}