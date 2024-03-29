package com.ty.csv.reader.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ty.csv.reader.dto.ResponseStructure;
import com.ty.csv.reader.entity.User;

public interface UserService {

	public ResponseEntity<ResponseStructure<List<User>>> saveUser(MultipartFile file) throws IOException, NumberFormatException;
	
}
