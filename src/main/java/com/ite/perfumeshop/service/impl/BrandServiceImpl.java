package com.ite.perfumeshop.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ite.perfumeshop.entity.Brand;
import com.ite.perfumeshop.exception.ApiException;
import com.ite.perfumeshop.repository.BrandRepository;
import com.ite.perfumeshop.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;


	@Override
	public Brand getBrand(Long id) {	
		return brandRepository.findById(id).orElseThrow((() -> new ApiException(HttpStatus.NOT_FOUND, String.format("Brand %s not found", id))));
	}

	@Override
	public Brand update(Map<String, String> param) {
		if(param.containsKey("id")) {
			
				Long id = Long.parseLong(param.get("id"));			
				Brand brand = brandRepository.findById(id).orElseThrow((() -> new ApiException(HttpStatus.NOT_FOUND, "This brand isn't found")));
				if(param.containsKey("name")) {
					brand.setName(param.get("name"));
					 Brand save = brandRepository.save(brand);
					 return save;
					 
				}	
		}
		else {
			throw new ApiException(HttpStatus.BAD_REQUEST, "Id is Null");
		}
		return null;
	}

	@Override
	public String delete(Long id) {
		brandRepository.deleteById(id);
		return "Delete Seccessfully";
	}

	@Override
	public Brand create(Brand brand) {

		return brandRepository.save(brand);
	}

	@Override
	public List<Brand> getAllBrands() {

		return brandRepository.findAll();
	}



	

}
