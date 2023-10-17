package com.ite.perfumeshop.controller;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ite.perfumeshop.dto.CategoryDTO;
import com.ite.perfumeshop.entity.Category;
import com.ite.perfumeshop.mapper.CategoryMapper;
import com.ite.perfumeshop.service.CategoryService;


@RestController
@RequestMapping("/category")
public class CategoryController {


	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<Category> categories = categoryService.getAll();
		return ResponseEntity.ok(categories);
	}
	
	@PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryDTO dto) {
    	Category category = CategoryMapper.INSTANCE.toCategory(dto);
    	Category create = categoryService.create(category);
    	CategoryDTO CategoryDTO = CategoryMapper.INSTANCE.tCategoryDTO(create);
    	return ResponseEntity.ok(CategoryDTO);	
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestParam Map<String, String> param){
		
		Category update = categoryService.update(param);
		CategoryDTO CategoryDTO = CategoryMapper.INSTANCE.tCategoryDTO(update);
		return ResponseEntity.ok(CategoryDTO);		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		String delete = categoryService.delete(id);
		return ResponseEntity.ok(delete);
	}
    
}
