package com.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.mapper.ClassMapper;
import com.education.bean.Class;
@Service
@Transactional
public class ClassService {
	@Autowired
	ClassMapper classMapper;
	
	public  List<Class> getSchoolClassList(int sid) {
		return classMapper.getClassList(sid);
	}
	
	public  List<Class> getTeacherClassList(int tid) {
		return classMapper.getTeacherClassList(tid);
	}
	
	public  List<Class> getParentClassList(int pid) {
		return classMapper.getParentClassList(pid);
	}
}


