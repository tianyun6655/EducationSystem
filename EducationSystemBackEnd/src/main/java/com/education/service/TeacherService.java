package com.education.service;

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
	

	public int signUpForTeacher(Teacher teacher){
		//需要添加检查手机号有没有重复
		return teacherMapper.signUpForTeacher(teacher);
		
	}
}
