package com.ite.perfumeshop.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.ite.perfumeshop.dto.ProductDTO;
import com.ite.perfumeshop.dto.ProductDetailDTO;
import com.ite.perfumeshop.dto.ProductResponeDTO;
import com.ite.perfumeshop.entity.Product;
import com.ite.perfumeshop.service.BrandService;
import com.ite.perfumeshop.service.CategoryService;





@Mapper(componentModel = "spring" ,uses = {CategoryService.class, BrandService.class})
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	@Mapping(target = "categories" , source = "category_id")
	@Mapping(target = "brand" , source = "brand_id")
	@Mapping(target = "id" , ignore = true)
	Product toProduct(ProductDTO dto);
	
	@Mapping(target = "brandName" , source = "brand.name")
	ProductResponeDTO toProductResponeDTO(Product product);

	@Mapping(target = "brandName" , source = "brand.name")
	ProductDetailDTO toProductDetailDTO(Product product);
	
	
}