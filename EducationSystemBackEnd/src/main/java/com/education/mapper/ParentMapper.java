package com.education.mapper;

import java.util.List;

import com.education.bean.Parent;

public interface ParentMapper 
{
	   public int signUpForParent(Parent parent);
	   public Parent getParentByMobile(String mobile);
	   public List<Parent> getParentList(int pid);
	   public int updateParent(Parent parent);
	   public boolean checkDuplicate(Parent parent);
}
