package com.education.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.education.bean.Teacher;
import com.education.service.TeacherService;
import com.hazelcast.com.eclipsesource.json.JsonObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("api/teacner")
public class TeacherController {

	@Autowired
	TeacherService  teacherService;
    @RequestMapping(value="list", method= RequestMethod.POST)
	 public void getTeacherList(HttpServletRequest request,HttpServletResponse response) throws IOException{

    }
    
    
    
   //-------------------------GET测试------------------------------------
    
    @RequestMapping(value="list", method= RequestMethod.GET)
	 public void getTeacherList_get(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 1);

		ArrayList<Teacher> teacherslist = (ArrayList<Teacher>) teacherService.getTeacherList(2);
		JSONArray jsonArray = new JSONArray();
		for (Teacher teacher : teacherslist) {
			JSONObject singleJson = new JSONObject();
			singleJson.put("name", teacher.getName());
			singleJson.put("mobile", teacher.getMobile());
			singleJson.put("classAdviser", teacher.getClassAdviser());
			jsonArray.add(singleJson);
		}
		jsonObject.put("data", jsonArray);
		response.getWriter().write(jsonObject.toString());
		response.getWriter().close();
 
    }
}
