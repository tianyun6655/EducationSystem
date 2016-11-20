package com.education.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.bean.ClassAndSchool;
import com.education.bean.Parent;
import com.education.bean.Student;
import com.education.bean.StudentList;
import com.education.mapper.ClassMapper;
import com.education.mapper.ParentMapper;
import com.education.mapper.StudentMapper;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ClassMapper classMapper;
	@Autowired
	private ParentMapper parentMapper;
	
	public int  createStudent(Student student) {
		studentMapper.createStudent(student);
		return student.getStid();
	}
	
	public Student getStudentByStid(int stid){
		return studentMapper.getStudentByStid(stid);
		
	}
	
	public List<StudentList> getStudentListItem(int pid){
		List<StudentList> result = new ArrayList<StudentList>();
		List<Student> stids = new ArrayList<Student>();
		stids = studentMapper.getStidByPid(pid);
		for(int i =0;i<stids.size();i++){
			StudentList studentList = new StudentList();
			studentList.setStid(stids.get(i).getStid());
			studentList.setName(stids.get(i).getName());
			int cid = classMapper.getCidByStid(stids.get(i).getStid());
			ClassAndSchool classAndSchool = classMapper.getClassAndSchoolByCid(cid);
			studentList.setGrade(classAndSchool.getGrade());
			studentList.setSchoolName(classAndSchool.getName());
			studentList.setNo(classAndSchool.getNo());
		    result.add(studentList);
		}
		
		return result;
	}
	
	public List<Student> getStudentBycid(int cid){
		return studentMapper.getStudentBycid(cid);
		
	}
	
	public int bandParent(int stid,int pid,int cid){
	         	parentMapper.bandClass(pid, cid);
		return studentMapper.bandParent(stid, pid);
		
	}
}
