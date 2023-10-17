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
import org.springframework.web.bind.annotation.RestController;

import com.ite.perfumeshop.dto.BrandDTO;
import com.ite.perfumeshop.entity.Brand;
import com.ite.perfumeshop.mapper.MappingBrand;
import com.ite.perfumeshop.service.BrandService;



@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<Brand> allBrands = brandService.getAllBrands();
		return ResponseEntity.ok(allBrands);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBrand(@PathVariable Long id){
		Brand brand = brandService.getBrand(id);
		return ResponseEntity.ok(brand);
		
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO dto){
		Brand brand = MappingBrand.INSTANCE.toBrand(dto);
		Brand create = brandService.create(brand);
		BrandDTO brandDTO = MappingBrand.INSTANCE.toBrandDTO(create);
		return ResponseEntity.ok(brandDTO);
	}
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Map<String, String> param){
		Brand update = brandService.update(param);
		BrandDTO brandDTO = MappingBrand.INSTANCE.toBrandDTO(update);
		return ResponseEntity.ok(brandDTO);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		String delete = brandService.delete(id);
		return ResponseEntity.ok(delete);
	}
	
	
}
