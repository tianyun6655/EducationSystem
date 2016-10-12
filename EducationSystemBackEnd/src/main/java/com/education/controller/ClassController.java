package com.education.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/class")
public class ClassController {

	//TODO 获取班级信息
	@RequestMapping(value="getinform",method=RequestMethod.POST)
	public void getClassInformation(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	
	
}
