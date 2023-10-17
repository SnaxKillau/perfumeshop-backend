package com.ite.perfumeshop.serailiz;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ite.perfumeshop.entity.Product;

public class ProductSerializer extends JsonSerializer<Product> {
	@Override
	public void serialize(Product value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		
		gen.writeStartObject();
		gen.writeNumberField("id", value.getId());
		gen.writeStringField("name", value.getName());
		gen.writeStringField("imagePath", value.getImagePath());
		gen.writeNumberField("availableUnit", value.getAvailableUnit());
		gen.writeStringField("brandName", value.getBrand().getName());
		gen.writeEndObject();
		
	}

	

}
