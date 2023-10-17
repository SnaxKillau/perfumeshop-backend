package com.ite.perfumeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.perfumeshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	

}
