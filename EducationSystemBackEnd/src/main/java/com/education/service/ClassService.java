package com.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.education.mapper.ClassMapper;
import com.education.bean.Class;

public class ClassService {
	@Autowired
	ClassMapper classMapper;
	
	public  List<Class> getSchoolClassList(int sid) {
		return classMapper.getClassList(sid);
		
	}
}


