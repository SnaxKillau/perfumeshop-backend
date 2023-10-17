package com.ite.perfumeshop.dto;


import lombok.Data;

@Data
public class ProductResponeDTO {


	private Long id;
	private String name;
	private String imagePath;
	private Integer availableUnit;
	private String brandName;
	

}
