package com.education.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @author tianyun chen
 * 有关登录的class，包括登录，注册
 */
@RequestMapping("api/login")
public class LoginController {
     //
	//TODO 老师登录
	@RequestMapping(value="login_as_teacher",method = RequestMethod.POST)
	public void loginAsTeacher(HttpServletRequest request,HttpServletResponse response){
		 
	}
	
	//TODO 家长登录
	@RequestMapping(value="login_as_parent",method = RequestMethod.POST)
	public void loginAsPartent(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	//TODO 老师注册
	@RequestMapping(value="sign_as_teacher",method = RequestMethod.POST)
	public void signUpAsTeacher(HttpServletRequest request,HttpServletResponse response){
	
		
	}
	
	//TODO 家长登录
	@RequestMapping(value="sign_as_parent",method = RequestMethod.POST)
	public void signUpAsParent(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	
	
}
