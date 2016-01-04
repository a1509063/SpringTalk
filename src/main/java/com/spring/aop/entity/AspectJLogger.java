package com.spring.aop.entity;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJLogger {
	/**
	 * 必须为final String类型的,注解里要使用的变量只能是静态常量类型的
	 */
	public static final String EDP = "execution(* com.spring.controller..*(..)) && args(request,response)";

	@Around(EDP) // spring中Around通知
	public Object logAround(ProceedingJoinPoint joinPoint,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("logAround开始:现在时间是:" + new Date()); // 方法执行前的代理处理
		Object[] args = joinPoint.getArgs();
//		System.out.println(args.length);
//		HttpServletRequest request=(HttpServletRequest)args[0];
		System.out.println(request.getParameter("username"));
		Object obj = null;
		try {
			joinPoint.getArgs();
			obj = joinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("logAround结束:现在时间是:" + new Date()); // 方法执行后的代理处理
		return obj;
	}
}
