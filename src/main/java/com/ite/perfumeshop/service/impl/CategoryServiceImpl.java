package com.ite.perfumeshop.service.impl;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ite.perfumeshop.entity.Category;
import com.ite.perfumeshop.exception.ApiException;
import com.ite.perfumeshop.repository.CategoryRepository;

import com.ite.perfumeshop.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category create(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public String delete(Long id) {
		
		categoryRepository.deleteById(id);
		return "Delete Seccessfully";
	}

	@Override
	public Category update(Map<String, String> params) {
		if(params.containsKey("id")) {
			Long id = Long.parseLong(params.get("id"));
			
			Category category = categoryRepository.findById(id).orElseThrow((() -> new ApiException(HttpStatus.NOT_FOUND, "This category isn't found")));
			if(params.containsKey("name")) {	
				category.setName(params.get("name"));
				categoryRepository.save(category);
				return category;
			}
		}
		else {
			throw new ApiException(HttpStatus.BAD_REQUEST, "Id is Null");
		}
		return null;
		
		
	}

	@Override
	public List<Category> findAllCategory(List<Long> id) {
		
		return categoryRepository.findAllById(id);
	}

	@Override
	public List<Category> getAll() {
		
		return categoryRepository.findAll();
	}

}
