package com.mengxiaotian.learn.spring.service.impi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mengxiaotian.learn.spring.dao.UserMapper;
import com.mengxiaotian.learn.spring.meta.User;
import com.mengxiaotian.learn.spring.servlet.SelectUser;

public class SelectUserImpi implements SelectUser {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public List<User> Select(){
		
		return userMapper.getUser();
	}

}
