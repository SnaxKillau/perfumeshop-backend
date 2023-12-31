package com.ite.perfumeshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ite.perfumeshop.entity.Image;





public interface ImageRepository extends JpaRepository<Image, Long>, JpaSpecificationExecutor<Image>{
		Optional<Image> findByName(String name);
}
