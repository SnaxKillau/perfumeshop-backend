package com.ite.perfumeshop.service;

import java.util.List;
import java.util.Map;


import com.ite.perfumeshop.entity.Category;

public interface CategoryService {
	
	 Category create(Category category);
	 String delete(Long id);
	 Category update(Map<String, String> params);
	 List<Category> findAllCategory(List<Long>id);
	 List<Category> getAll();
	 


}
