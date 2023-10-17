package com.ite.perfumeshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.ite.perfumeshop.dto.ProductDetailDTO;
import com.ite.perfumeshop.entity.Product;

public interface ProductService {
	
	Product create(Product product);
	String delete(Long id);
	Product update(Map<String, String>param);
	Product saveImage(Long id , String name);
	Page<Product> getAll(Map<String, String> params);
	List<Product>findByCategory(Long id);
	List<Product>all();
	Product getId(Long id);
	
	

}
