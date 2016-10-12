package com.education.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/teacner")
public class TeacherController {

    @RequestMapping("test")
	 public void tester(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String tester = request.getParameter("test");
		response.getWriter().write("Server set up successfully!");
		response.getWriter().close();
    	}
    
    
	
}
