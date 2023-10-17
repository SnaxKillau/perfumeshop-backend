package com.ite.perfumeshop.dto;

import java.util.List;
import lombok.Data;

@Data
public class ProductDTO {

	
    private String name;
    private List<Long> category_id;
    private Long brand_id;
    private String detail;
    private Integer price;
    

}
