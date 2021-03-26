package com.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.domain.User;
import com.graduation.mapper.UserMapper;

@Service
public class UserService {

	@Autowired(required = false)
	private UserMapper mapper;
	
	public User queryUserByUserId(int userId){
		User user=mapper.queryUserByUserId(userId);
		return user;
	}
	
	public User queryUserByEmail(String email){
		User user=mapper.queryUserByEmail(email);
		return user;
	}
	
	public void insertUser(String email, String password) {
		mapper.insertUser(email, password);
	}
	
	public User queryUserByEmailAndPassword(String email, String password) {
		User user=mapper.queryUserByEmailAndPassword(email,password);
		return user;
	}
	
	public void updateUserPasswordByEmail(String password, String email) {
		mapper.updateUserPasswordByEmail(password, email);
	}
	
	public void updateNameById(int userId, String userName) {
		mapper.updateNameById(userId, userName);
	}

}
