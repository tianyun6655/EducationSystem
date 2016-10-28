package com.education.mapper;

import java.util.List;

import com.education.bean.Teacher;

public interface TeacherMapper {
   public int signUpForTeacher(Teacher teacher);
   public int bindClass(int tid, int cid);
   public Teacher getTeacherByMobile(String mobile);
   public List<Teacher> getTeacherList(int cid);
   public int updateTeacher(Teacher teacher);
}
