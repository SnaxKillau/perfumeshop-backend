package com.ite.perfumeshop.dto;

import lombok.Data;

@Data
public class ProductDetailDTO {

	
	private Long id;
	private String name;
	private String imagePath;
	private Integer availableUnit;
	private String brandName;
	private String detail;

}
