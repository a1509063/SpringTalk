package com.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.dao.LoginDao;
import com.spring.entity.User;
import com.spring.service.LoginService;

@Component
@Repository("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name = "LoginDao")
	private LoginDao dao;
	
	public User loginIn(User user) {
		User users=null;
		try {
			users=dao.findUser("UserMap.findUserBylogin", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(users!=null){
			return users;
		}
		return null;
	}

}
