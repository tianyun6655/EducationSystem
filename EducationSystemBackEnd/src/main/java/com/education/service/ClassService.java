package com.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.mapper.ClassMapper;
import com.education.mapper.ParentMapper;
import com.education.mapper.TeacherMapper;
import com.education.bean.Class;
import com.education.bean.ClassAndSchool;
@Service
@Transactional
public class ClassService {
	@Autowired
	ClassMapper classMapper;
	@Autowired
	ParentMapper parentMapper;
	@Autowired
	TeacherMapper teacherMapper;
	public  List<Class> getSchoolClassList(int sid) {
		return classMapper.getClassList(sid);
	}
	
	public  List<Class> getTeacherClassList(int tid) {
		return classMapper.getTeacherClassList(tid);
	}
	
	public  List<Class> getParentClassList(int pid) {
		return classMapper.getParentClassList(pid);
	}
	
	public ClassAndSchool getClassByToeken(String token){
		return classMapper.getClassByToeken(token);
		
	}
	
	public List[] getNumbersFromCid(int cid){
		List[] parentTeacher = new List[2];
		parentTeacher[0] = parentMapper.getParentsByCid(cid);
		parentTeacher[1] = teacherMapper.getTeachersByCid(cid);
		return parentTeacher;
	}
}


