package com.ite.perfumeshop.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ite.perfumeshop.entity.Image;
import com.ite.perfumeshop.repository.ImageRepository;
import com.ite.perfumeshop.service.ProductService;
import com.ite.perfumeshop.service.util.ImageUtility;


@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private ProductService productService;
	

	
	
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file , @RequestParam("product_id") Long id) throws IOException {
		
        imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        productService.saveImage(id, file.getOriginalFilename());
        return ResponseEntity.status(HttpStatus.OK)
                .body(file.getOriginalFilename());
	}
	  @GetMapping(path = {"/{name}"})
	    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

	        final Optional<Image> dbImage = imageRepository.findByName(name);

	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.valueOf(dbImage.get().getType()))
	                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
	    }
	
	
}
