package com.ite.perfumeshop.service;

import java.util.List;
import java.util.Map;


import com.ite.perfumeshop.entity.Brand;

public interface BrandService {
	
	Brand getBrand(Long id);
	Brand create(Brand brand);
	Brand update(Map<String, String> param);
	String delete(Long id);
	List<Brand> getAllBrands();
	
	

}
