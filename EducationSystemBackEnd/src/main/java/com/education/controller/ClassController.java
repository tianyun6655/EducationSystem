package com.education.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.education.bean.Class;
import com.education.bean.ClassAndSchool;
import com.education.bean.Parent;
import com.education.bean.Teacher;
import com.education.service.ClassService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import javassist.expr.NewArray;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("api/class")
public class ClassController {
	@Autowired
	ClassService classService;
     
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
		List<Class> classes = classService.getSchoolClassList(school_id);
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
			List<Class> classes = classService.getTeacherClassList(teaher_id);
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
		 * 获取某个家长所关联的所有班级信息
		 * @param request
		 * @param response
		 * request；pid 家长主键 respon： return array of class given a specific parent
		 * @throws IOException
		 */
		@RequestMapping(value = "parentclasslist", method = RequestMethod.POST)
		public void getClassInformationGivenASpecificParent(HttpServletRequest request, HttpServletResponse response) throws IOException {
			JSONArray j = new JSONArray();
			JSONObject obj = new JSONObject();
			String parentId = request.getParameter("pid");
			int parent_id = Integer.parseInt(parentId);
			List<Class> classes = classService.getParentClassList(parent_id);
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

		
	@RequestMapping(value="getClassByToken", method = RequestMethod.POST)
     public void getClassByToken(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String token = request.getParameter("token");
		JSONObject jsonObject = new JSONObject();
		
		ClassAndSchool classAndSchool = classService.getClassByToeken(token);
		if(classAndSchool!=null){
			 JSONObject classAndSchoolJS = new JSONObject();
			 classAndSchoolJS.put("name", classAndSchool.getName());
			 classAndSchoolJS.put("grade", classAndSchool.getGrade());
			 classAndSchoolJS.put("no", classAndSchool.getNo());
			 jsonObject.put("code", 1);

			 jsonObject.put("data", classAndSchoolJS);
		}else{
			jsonObject.put("code", 0);
		}
		
		response.getWriter().write(jsonObject.toString());
		response.getWriter().close();
	}
	
	@RequestMapping(value="getNumbersFromCid",method=RequestMethod.POST)
	public void getNumberFromCid(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int cid = Integer.parseInt(request.getParameter("cid"));
		JSONObject result = new JSONObject();
		List[] datas = classService.getNumbersFromCid(cid);
		List<Teacher> teachers = datas[1];
		List<Parent> parents = datas[0];
		result.put("code", 1);
		JSONArray teacherArray  = new JSONArray();
		for(int i =0;i<teachers.size();i++){
			JSONObject eachTeacher = new JSONObject();
			eachTeacher.put("name", teachers.get(i).getName());
			eachTeacher.put("tid", teachers.get(i).getTid());
			teacherArray.add(eachTeacher);
		}
		JSONObject teacherData = new JSONObject();
		teacherData.put("teacher", teacherArray);
		JSONArray parentArray = new JSONArray();
		for(int i =0;i<parents.size();i++){
			JSONObject eacherParent = new JSONObject();
			eacherParent.put("name", parents.get(i).getName());
			eacherParent.put("pid", parents.get(i).getPid());
			parentArray.add(eacherParent);
		}
     	JSONObject parentData = new JSONObject();
		parentData.put("parent", parentArray);
	    JSONArray datarray = new JSONArray();
	    datarray.add(parentData);
	    datarray.add(teacherData);
	    result.put("data", datarray);
	    
	    response.getWriter().write(result.toString());
	    response.getWriter().close();
	}
		
	// --------------------------------get------------------------------------------------
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void TESTgetClassInformation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONArray j = new JSONArray();
		JSONObject obj = new JSONObject();
		String schoolID = request.getParameter("sid");
		int school_id = Integer.parseInt(schoolID);
		List<Class> classes = classService.getSchoolClassList(school_id);
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
