package com.ite.perfumeshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ite.perfumeshop.dto.ProductImportHIstoryDTO;
import com.ite.perfumeshop.entity.Product;
import com.ite.perfumeshop.entity.ProductImportHistory;

@Mapper
public interface ProductHistoryMapper {

	ProductHistoryMapper INSTANCE = Mappers.getMapper(ProductHistoryMapper.class);
	
	@Mapping(target = "product" , source = "product")
	@Mapping(target = "id" , ignore = true)
	ProductImportHistory toProductImportHistory(ProductImportHIstoryDTO dto , Product product);
	

	

}
