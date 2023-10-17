package com.ite.perfumeshop.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.ite.perfumeshop.dto.ProductDTO;
import com.ite.perfumeshop.dto.ProductDetailDTO;
import com.ite.perfumeshop.dto.ProductResponeDTO;
import com.ite.perfumeshop.entity.Product;
import com.ite.perfumeshop.mapper.ProductMapper;
import com.ite.perfumeshop.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<Product> products = productService.all();
		List<ProductResponeDTO> productsDtos = products.stream()
		.map(t -> productMapper.toProductResponeDTO(t))
		.collect(Collectors.toList());
		return ResponseEntity.ok(productsDtos);
	}
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductDTO dto){
		Product product = productMapper.toProduct(dto);
		Product create = productService.create(product);
		
		return ResponseEntity.ok(create);
	}
	@PutMapping
	public ResponseEntity<?> update(@RequestParam Map<String, String> param){
		Product update = productService.update(param);
		return ResponseEntity.ok(update);
	}
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam Long id){
		String delete = productService.delete(id);
		return ResponseEntity.ok(delete);	
	}
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getByCategory(@PathVariable Long id){
		List<Product> products = productService.findByCategory(id);
		return ResponseEntity.ok(products);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Product product = productService.getId(id);
		ProductDetailDTO productDetailDTO = productMapper.toProductDetailDTO(product);
		return ResponseEntity.ok(productDetailDTO);
	}
	


	

}
