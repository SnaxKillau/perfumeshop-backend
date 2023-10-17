package com.ite.perfumeshop.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ite.perfumeshop.dto.BrandDTO;
import com.ite.perfumeshop.entity.Brand;



@Mapper
public interface MappingBrand {

	MappingBrand INSTANCE = Mappers.getMapper(MappingBrand.class);
	@Mapping(target = "id" , ignore = true)
	Brand toBrand(BrandDTO dto);
	BrandDTO toBrandDTO(Brand brand);
}