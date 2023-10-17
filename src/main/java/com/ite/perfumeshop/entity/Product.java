package com.ite.perfumeshop.entity;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ite.perfumeshop.serailiz.ProductSerializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
//@JsonSerialize(using = ProductSerializer.class)
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "available_unit" , columnDefinition = "integer default 0")
	private Integer availableUnit;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "detail")
	private String detail;
	
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	
	@ManyToMany
	@JoinColumn(name = "category_id")
	private List<Category>categories;



}