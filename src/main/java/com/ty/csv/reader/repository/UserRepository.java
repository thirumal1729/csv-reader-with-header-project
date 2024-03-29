package com.ty.csv.reader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.csv.reader.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
