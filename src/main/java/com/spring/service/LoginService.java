package com.spring.service;

import com.spring.entity.User;

public interface LoginService {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User loginIn(User user);
}
