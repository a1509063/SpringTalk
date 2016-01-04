package com.spring.dao;

import com.spring.entity.User;

public interface LoginDao {
	public User findUser(String str,User user) throws Exception;
}
