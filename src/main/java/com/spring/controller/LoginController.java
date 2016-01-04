package com.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.User;
import com.spring.service.LoginService;

@Controller
public class LoginController {
	@Resource(name = "loginService")
	private LoginService loginService;
	
	@RequestMapping("loginIn")
	public ModelAndView loginIn(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		ModelAndView mv = new ModelAndView();
		User user=new User();
		user.setUser_name(username);
		user.setPassword(password);
		User loginUser=new User();
		loginUser=loginService.loginIn(user);
		if(loginUser!=null){
			mv.addObject("username", loginUser.getUser_name());
			mv.setViewName("system/talkroom");
		}else{
			mv.setViewName("login");
		}
		return mv;
	}
}
