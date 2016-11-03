package com.education.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.education.bean.SchoolAndAddress;
import com.education.service.SchoolService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("api/school")
public class SchoolController {

	@Autowired
	SchoolService schoolService;
	
	@RequestMapping(value="/list",method = RequestMethod.POST)
    public void getList(HttpServletRequest request,HttpServletResponse response){
		String time = request.getParameter("timetamp");
		String sign = request.getParameter("sign");
		System.out.println(time+sign);
		List<SchoolAndAddress> list = schoolService.getSchoolAndAddressList();
		 JSONObject jsonObject = new JSONObject();
		 if(list!=null){
			 jsonObject.put("code",1);
			 JSONArray jsonArray = new JSONArray();
			 for (int i = 0; i < list.size(); i++) {
				JSONObject single = new JSONObject();
				single.put("sid",list.get(i).getSid());
				single.put("name",list.get(i).getName());
				single.put("schoolType",list.get(i).getSchoolType());
				single.put("province", list.get(i).getProvince());
				single.put("qu", list.get(i).getQu());
				single.put("city", list.get(i).getCity());
				single.put("road", list.get(i).getRoad());
				jsonArray.add(single);
			}
			 jsonObject.put("data", jsonArray);
			 
		 }else {
			 jsonObject.put("code", 0);
		}
		 
		 try {
			response.getWriter().write(jsonObject.toString());
			 response.getWriter().close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	@RequestMapping(value="test",method=RequestMethod.POST)
	public void test(HttpServletRequest request,HttpServletResponse response){
		System.out.println("hello");
	}
//--------------------------------------Get测试---------------------------------------------------------
	

}
