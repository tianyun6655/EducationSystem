package com.education.mapper;

import java.util.List;

import com.education.bean.Class;

public interface ClassMapper {
	public List<Class> getClassList(int sid);
	
	public  List<Class> getTeacherClassList(int tid);
	
	
	
	
	
}
