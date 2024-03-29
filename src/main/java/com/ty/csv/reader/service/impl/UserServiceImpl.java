package com.ty.csv.reader.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ty.csv.reader.dao.UserDao;
import com.ty.csv.reader.dto.ResponseStructure;
import com.ty.csv.reader.entity.User;
import com.ty.csv.reader.service.UserService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<ResponseStructure<List<User>>> saveUser(MultipartFile file)
			throws IOException, NumberFormatException {

		List<User> users = new ArrayList<User>();

		CsvParserSettings settings = new CsvParserSettings();
		settings.setHeaderExtractionEnabled(true);
		CsvParser csvParser = new CsvParser(settings);
		List<Record> records = csvParser.parseAllRecords(file.getInputStream());

		records.forEach(record -> {
			User user = User.builder().name(record.getString("name")).email(record.getString("email"))
					.phone(Long.parseLong(record.getString("phone"))).password(record.getString("password")).build();
			users.add(user);
		});

		this.userDao.saveAllUsers(users);
		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
		responseStructure.setStatucCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(users);

		return new ResponseEntity<ResponseStructure<List<User>>>(responseStructure, HttpStatus.CREATED);
	}

}
