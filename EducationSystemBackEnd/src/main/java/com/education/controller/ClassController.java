package com.education.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.education.bean.Class;
import com.education.mapper.ClassMapper;
import com.education.service.ClassService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("api/class")
public class ClassController {
	@Autowired
	ClassService ClassService;
     
	/**
	 * 获取某个学校的所有班级信息
	 * @param request
	 * @param response
	 * request；sid 学校主键 respon： return array of class given a specific school
	 * @throws IOException
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public void getClassInformation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONArray j = new JSONArray();
		JSONObject obj = new JSONObject();
		String schoolID = request.getParameter("sid");
		int school_id = Integer.parseInt(schoolID);
		//List<Class> classes = classMapper.getClassList(school_id);
		List<Class> classes = ClassService.getSchoolClassList(school_id);
		if (classes.isEmpty()) {
			obj.put("code", 0);
		} else {
			obj.put("code", 1);
			for (Class c : classes) {
				JSONObject eachC = new JSONObject();
				eachC.put("cid", c.getCid());
				eachC.put("grade", c.getGrade());
				eachC.put("no", c.getClassNo());
				j.add(eachC);
			}
			obj.put("data", j);
		}
		response.getWriter().write(obj.toString());
		response.getWriter().close();
	}
	
       /**
		 * 获取某个老师的所有班级信息
		 * @param request
		 * @param response
		 * request；tid 老师主键 respon： return array of class given a specific teacher
		 * @throws IOException
		 */
		@RequestMapping(value = "classlist", method = RequestMethod.POST)
		public void getClassInformationGivenASpecificTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
			JSONArray j = new JSONArray();
			JSONObject obj = new JSONObject();
			String teacherId = request.getParameter("tid");
			int teaher_id = Integer.parseInt(teacherId);
			List<Class> classes = ClassService.getTeacherClassList(teaher_id);
			if (classes.isEmpty()) {
				obj.put("code", 0);
			} else {
				obj.put("code", 1);
				for (Class c : classes) {
					JSONObject eachC = new JSONObject();
					eachC.put("cid", c.getCid());
					eachC.put("grade", c.getGrade());
					eachC.put("no", c.getClassNo());
					j.add(eachC);
				}
				obj.put("data", j);
			}
			response.getWriter().write(obj.toString());
			response.getWriter().close();
		}

	// --------------------------------get------------------------------------------------
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void TESTgetClassInformation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONArray j = new JSONArray();
		JSONObject obj = new JSONObject();
		String schoolID = request.getParameter("sid");
		int school_id = Integer.parseInt(schoolID);
		List<Class> classes = ClassService.getSchoolClassList(school_id);
		if (classes.isEmpty()) {
			obj.put("code", 0);
		} else {
			obj.put("code", 1);
			for (Class c : classes) {
				JSONObject eachC = new JSONObject();
				eachC.put("cid", c.getCid());
				eachC.put("grade", c.getGrade());
				eachC.put("no", c.getClassNo());
				j.add(eachC);
			}
			obj.put("data", j);
		}
		response.getWriter().write(obj.toString());
		response.getWriter().close();

	}
}
