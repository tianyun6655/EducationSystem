package com.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.bean.Teacher;
import com.education.mapper.TeacherMapper;

@Service
@Transactional
public class TeacherService {

	@Autowired
	TeacherMapper teacherMapper;
	

	public int signUpForTeacher(Teacher teacher,int cid){
		//需要添加检查手机号有没有重复
		teacherMapper.signUpForTeacher(teacher);
		teacherMapper.bindClass(teacher.getTid(), cid);
		return teacher.getTid();
	}
	
	public Teacher getTeacherByMobile(String mobile) {
		
		return teacherMapper.getTeacherByMobile(mobile);
		
	}
	public List<Teacher> getTeacherList(int cid){
		return teacherMapper.getTeacherList(cid);
	}
}
