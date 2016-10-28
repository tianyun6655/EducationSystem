package com.education.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.education.bean.Teacher;
import com.education.service.TeacherService;
import com.education.untils.FinalValues;
import com.education.untils.SHA1Util;

import net.sf.json.JSONObject;


/**
 * 
 * @author tianyun chen
 * 有关登录的class，包括登录，注册
 */
@Controller
@RequestMapping("api/sys")
public class SysController {
	@Autowired
	TeacherService teacherService;
	
	
	//TODO 老师登录
	@RequestMapping(value="login_as_teacher",method = RequestMethod.POST)
	public void loginAsTeacher(HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
        String mobile  = request.getParameter("mobile");
        String password  =  request.getParameter("password");
		String appSign = request.getParameter("sign");
	    String timeStamp = request.getParameter("time_stamp");
	    String  sign = SHA1Util.hex_sha1(timeStamp+FinalValues.PUBLIC_KEY);        

        Teacher teacher = teacherService.getTeacherByMobile(mobile);
        if(!sign.equals(appSign)){
        	jsonObject.put("code",-1);

        }else{
        if(teacher==null||!(teacher.getPassword().equals(password))){
        	jsonObject.put("code",0);
        }else{
        	jsonObject.put("code",1);
        	JSONObject teachJson = new JSONObject();
        	teachJson.put("mobile", teacher.getMobile());
        	teachJson.put("tie", teacher.getTid());
        	teachJson.put("password", teacher.getPassword());
        	teachJson.put("status",teacher.getStatus());
        	teachJson.put("classAdviser",teacher.getClassAdviser());
        	teachJson.put("name", teacher.getName());
        	jsonObject.put("teacher", teachJson);
        }
       }
        try {
			response.getWriter().write(jsonObject.toString());
            response.getWriter().close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}
	
	//TODO 家长登录
	@RequestMapping(value="login_as_parent",method = RequestMethod.POST)
	public void loginAsPartent(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	//TODO 老师注册
	@RequestMapping(value="sign_as_teacher",method = RequestMethod.POST)
	public void signUpAsTeacher(HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
		String appSign = request.getParameter("sign");
	    String timeStamp = request.getParameter("time_stamp");
		String name = request.getParameter("name");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        int cid = Integer.parseInt(request.getParameter("cid"));
        int status = Integer.parseInt(request.getParameter("status"));
        int classAdviser = Integer.parseInt(request.getParameter("classAdviser"));
	    String  sign = SHA1Util.hex_sha1(timeStamp+FinalValues.PUBLIC_KEY);        
        Teacher tempTeacher = initTeacher(name, password, mobile, status, classAdviser);

        if(!appSign.equals(sign)){
        	jsonObject.put("code",-1);
        }else{
            int result = teacherService.signUpForTeacher(tempTeacher, cid);
        	System.out.println(result);
            if(result==0){
        		jsonObject.put("code",0);
        	}else{
        		jsonObject.put("code",1);
        		jsonObject.put("tid",tempTeacher.getTid());
        	}
        }
        try {
			response.getWriter().write(jsonObject.toString());
	        response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TODO 家长登录
	@RequestMapping(value="sign_as_parent",method = RequestMethod.POST)
	public void signUpAsParent(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	private Teacher initTeacher(String name,String password,String mobile,int status,int classAdviser){
		 Teacher teacher = new Teacher();
		 teacher.setName(name);
		 teacher.setPassword(password);
		 teacher.setMobile(mobile);
		 teacher.setMobile(mobile);
		 teacher.setStatus(status);
		 teacher.setClassAdviser(classAdviser);
		 return teacher;
	}
	
	//-------------------------------GET 测试-------------------------------
	
	
	
	//TODO 老师注册 get测试
	@RequestMapping(value="sign_as_teacher",method = RequestMethod.GET)
	public void signUpAsTeacher_get(HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
		String appSign = request.getParameter("sign");
	    //String timeStamp = request.getParameter("time_stamp");
		String name = request.getParameter("name");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        int cid = Integer.parseInt(request.getParameter("cid"));
        int status = Integer.parseInt(request.getParameter("status"));
        int classAdviser = Integer.parseInt(request.getParameter("classAdviser"));
	    //  String  sign = SHA1Util.hex_sha1(timeStamp+FinalValues.PUBLIC_KEY);        
        Teacher tempTeacher = initTeacher(name, password, mobile, status, classAdviser);
        
        if(!appSign.equals("123")){
        	jsonObject.put("code",-1);
        }else{
            int result = teacherService.signUpForTeacher(tempTeacher, cid);
        	System.out.println(result);
            if(result==0){
        		jsonObject.put("code",0);
        	}else{
        		jsonObject.put("code",1);
        		jsonObject.put("tid",tempTeacher.getTid());
        	}
        }
        try {
			response.getWriter().write(jsonObject.toString());
	        response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TODO 老师登录Get
		@RequestMapping(value="login_as_teacher",method = RequestMethod.GET)
		public void loginAsTeacherGet(HttpServletRequest request,HttpServletResponse response){
	        JSONObject jsonObject = new JSONObject();
            String mobile  = request.getParameter("mobile");
            String password  =  request.getParameter("password");
            Teacher teacher = teacherService.getTeacherByMobile(mobile);
            if(teacher==null||!(teacher.getPassword().equals(password))){
            	jsonObject.put("code",0);
            }else{
            	jsonObject.put("code",1);
            	JSONObject teachJson = new JSONObject();
            	teachJson.put("mobile", teacher.getMobile());
            	teachJson.put("tie", teacher.getTid());
            	teachJson.put("password", teacher.getPassword());
            	teachJson.put("status",teacher.getStatus());
            	teachJson.put("classAdviser",teacher.getClassAdviser());
            	teachJson.put("name", teacher.getName());
            	jsonObject.put("teacher", teachJson);
            }
                
            try {
				response.getWriter().write(jsonObject.toString());
	            response.getWriter().close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		}
	
	
	
}
