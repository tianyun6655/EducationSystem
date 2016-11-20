package com.education.mapper;

import java.util.List;

import com.education.bean.Student;


public interface StudentMapper {
  
	public void createStudent(Student student);
	public Student getStudentByStid(int stid);	
	public  List<Student> getStidByPid(int pid);
	public List<Student>getStudentBycid(int cid);
	public int bandParent(int stid,int pid);
}
