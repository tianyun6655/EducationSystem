package com.education.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.education.bean.Student;
import com.education.service.StudentService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "createStduent", method = RequestMethod.POST)
	public void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		if (name != null && age != 0 && studentId != 0) {
			int result = studentService.createStudent(initStudent(name, age, studentId));
			if (result == 0) {
				jsonObject.put("code", 0);
			} else {
				JSONObject dataObject = new JSONObject();
				dataObject.put("stid", request);
				jsonObject.put("code", 1);
				jsonObject.put("data", dataObject);
			}

		} else {
			jsonObject.put("code", 0);
		}

		response.getWriter().write(jsonObject.toString());
		response.getWriter().close();

	}

	private Student initStudent(String name, int age, int studentId) {
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setStudentId(studentId);
		return student;
	}
}
