package com.ite.perfumeshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ite.perfumeshop.dto.CategoryDTO;
import com.ite.perfumeshop.entity.Category;

@Mapper
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	@Mapping(target = "id" , ignore =true)
	Category toCategory(CategoryDTO dto);
	CategoryDTO tCategoryDTO(Category category);
	
}
