package com.ty.csv.reader.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ty.csv.reader.dto.ResponseStructure;
import com.ty.csv.reader.entity.User;
import com.ty.csv.reader.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<ResponseStructure<List<User>>> saveUser(@PathVariable("file") MultipartFile file)
			throws NumberFormatException, IOException {
		return this.userService.saveUser(file);
	}

}
