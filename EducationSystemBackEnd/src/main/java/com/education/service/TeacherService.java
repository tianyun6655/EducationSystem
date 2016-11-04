package com.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.bean.Teacher;
import com.education.mapper.TeacherMapper;

@Service
@Transactional
public class TeacherService 
{

	@Autowired
	TeacherMapper teacherMapper;

	public int signUpForTeacher(Teacher teacher,String[] cids){

		//需要添加检查手机号有没有重复
		int result =-1;
		Teacher tempteacher = teacherMapper.getTeacherByMobile(teacher.getMobile());
		if(tempteacher==null){
			teacherMapper.signUpForTeacher(tempteacher);
		for(String cid : cids )
		{
			int tempCid = Integer.parseInt(cid);
			teacherMapper.bindClass(teacher.getTid(), tempCid);
		}
			result=teacher.getTid();
		}else{
			result=0;
		}
		
		
		//
		return result;
	}
	public Teacher getTeacherByMobile(String mobile) 
	{
		return teacherMapper.getTeacherByMobile(mobile);
	}
	public List<Teacher> getTeacherList(int cid)
	{
		return teacherMapper.getTeacherList(cid);
	}
	public int updateTeacher(Teacher teacher)
	{
		return teacherMapper.updateTeacher(teacher);
	}
}
