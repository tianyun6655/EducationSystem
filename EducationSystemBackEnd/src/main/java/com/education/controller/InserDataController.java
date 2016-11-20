package com.education.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.education.bean.Student;
import com.education.bean.Teacher;
import com.education.service.ParentService;
import com.education.service.StudentService;
import com.education.service.TeacherService;

@Controller
@RequestMapping("test")
public class InserDataController {
    
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;
	@Autowired
	ParentService parentService;
	
	@RequestMapping("createTeacher")
	public void create30Teacher(HttpServletRequest request,HttpServletResponse response){
		for(int i=0;i<30;i++){
			Teacher teacher = new Teacher();
			teacher.setName(i+"陈老师");
		    teacher.setMobile(i+"");
		    teacher.setPassword(1+"");
		    teacher.setClassAdviser(0);
		    teacherService.signUpTeacherWithoutBand(teacher);
		}
	} 
	@RequestMapping("createStuent")
	public void createStudent(HttpServletRequest request,HttpServletResponse response){
		int studentid=1;

		for(int i=0;i<360;i++){
			Student student = new Student();
			student.setName(i+"学生");
			student.setbBirthday("2016-01-09");
			if(studentid==11){
				studentid=1;
			}
			student.setStudentId(studentid);
		   studentid++;
		   studentService.createStudent(student);
		   
		}
	}
	
	
	@RequestMapping("createParent")
	public void createParent(HttpServletRequest request,HttpServletResponse response){
	}
	
	
	@RequestMapping("test")
	public void test(HttpServletRequest request,HttpServletResponse response){
		System.out.println("test");
	}
}
