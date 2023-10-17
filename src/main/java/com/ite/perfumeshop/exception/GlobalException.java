package com.ite.perfumeshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<?>handleApiException(ApiException e){
		ErrorRespone erorrRespone = new ErrorRespone(e.getStatus(), e.getMessage());
		return ResponseEntity.status(e.getStatus())
				.body(erorrRespone);
	}
	@ExceptionHandler(value = MethodArgumentNotValidException.class)

	public ResponseEntity<?>handleApiException(MethodArgumentNotValidException e){
		
		String message = e.getFieldError().getDefaultMessage();
		
		return ResponseEntity.status(400).body(message);
				
	}
	

}

