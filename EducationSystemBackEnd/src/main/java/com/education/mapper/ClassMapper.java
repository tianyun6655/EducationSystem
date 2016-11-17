package com.education.mapper;

import java.util.List;

import com.education.bean.Class;
import com.education.bean.ClassAndSchool;

public interface ClassMapper {
	public List<Class> getClassList(int sid);
	
	public  List<Class> getTeacherClassList(int tid);
	
	public  List<Class> getParentClassList(int pid);
	
    public ClassAndSchool getClassByToeken(String token);
    
	public ClassAndSchool  getClassAndSchoolByCid(int stid);
	
	public int getCidByStid(int stid);
	
}
