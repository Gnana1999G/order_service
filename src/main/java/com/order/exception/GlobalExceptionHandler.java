package com.order.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleOrderNotFound(OrderNotFoundException ex, HttpServletRequest req){
		ErrorResponse errorResponse=new com.order.exception.ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Order not found", ex.getMessage(), req.getRequestURI());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}

}
