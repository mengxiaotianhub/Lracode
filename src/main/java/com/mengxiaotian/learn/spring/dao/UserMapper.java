package com.mengxiaotian.learn.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mengxiaotian.learn.spring.meta.User;

public interface UserMapper {
	
	@Select("SELECT id,userName FROM User")
	public List<User> getUser();

}
