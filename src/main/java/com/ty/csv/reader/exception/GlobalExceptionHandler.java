package com.ty.csv.reader.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.csv.reader.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IOException.class)
	public ResponseEntity<ResponseStructure<String>> catchIOException(IOException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatucCode(HttpStatus.BAD_GATEWAY.value());
		responseStructure.setMessage("Bad Request");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(CsvValidationException.class)
//	public ResponseEntity<ResponseStructure<String>> catchCsvValidationException(CsvValidationException exception) {
//		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
//		responseStructure.setStatucCode(HttpStatus.BAD_GATEWAY.value());
//		responseStructure.setMessage("Invalid Csv file");
//		responseStructure.setData(exception.getMessage());
//		
//		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ResponseStructure<String>> catchCsvValidationException(NumberFormatException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatucCode(HttpStatus.BAD_GATEWAY.value());
		responseStructure.setMessage("Invalid data format");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
}
