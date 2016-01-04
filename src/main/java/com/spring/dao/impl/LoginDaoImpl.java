package com.spring.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.spring.dao.DaoSupport;
import com.spring.dao.LoginDao;
import com.spring.entity.User;

@Repository("LoginDao")
public class LoginDaoImpl implements LoginDao {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	public User findUser(String str,User user) throws Exception {
		return (User) dao.findForObject(str, user);
	}

}
