package com.ite.perfumeshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ite.perfumeshop.dto.ProductDetailDTO;
import com.ite.perfumeshop.entity.Category;
import com.ite.perfumeshop.entity.Product;
import com.ite.perfumeshop.exception.ApiException;
import com.ite.perfumeshop.repository.CategoryRepository;
import com.ite.perfumeshop.repository.ProductRepository;
import com.ite.perfumeshop.service.ProductService;
import com.ite.perfumeshop.service.util.PageUtil;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product create(Product product) {
		product.setAvailableUnit(0);
		return productRepository.save(product);
	}

	@Override
	public String delete(Long id) {
		productRepository.deleteById(id);
		return "Product Delete Successfully";
	}

	@Override
	public Product update(Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product saveImage(Long id, String name) {
		
		Product product = productRepository.findById(id).orElseThrow((() -> new ApiException(HttpStatus.NOT_FOUND, String.format("Product %s isn't found", id))));
		product.setImagePath(name);	
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> findByCategory(Long id) {
		List<Category> categories = new ArrayList<>();
	    Category category = categoryRepository.findById(id).orElseThrow((() -> new ApiException(HttpStatus.NOT_FOUND,String.format("Category %s isn't found", id) )));
	    categories.add(category);
		return productRepository.findByCategoriesIn(categories);
	}

	@Override
	public Page<Product> getAll(Map<String, String> params) {
		
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit  = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		int pageNum = PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNum = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
	
		Pageable pageable = PageUtil.getPageable(pageNum, pageLimit);
		
		
		return productRepository.findAll(pageable);
	}

	@Override
	public List<Product> all() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getId(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("Product %s isn't found", id)));
		return product;
	}


}
