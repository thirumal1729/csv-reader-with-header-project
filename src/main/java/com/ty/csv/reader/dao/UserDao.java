package com.ty.csv.reader.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.csv.reader.entity.User;
import com.ty.csv.reader.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> saveAllUsers(List<User> users) {
		return this.userRepository.saveAll(users);
	}
	
}
