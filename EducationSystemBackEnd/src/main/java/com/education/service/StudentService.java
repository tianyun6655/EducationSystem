package com.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.bean.Student;
import com.education.mapper.StudentMapper;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	public int  createStudent(Student student) {
		studentMapper.createStudent(student);
		return student.getStid();
	}
}
