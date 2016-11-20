package com.education.mapper;

import java.util.List;

import org.springframework.jmx.export.UnableToRegisterMBeanException;

import com.education.bean.Parent;

public interface ParentMapper 
{
	   public int signUpForParent(Parent parent);
	   public Parent getParentByMobile(String mobile);
	   public List<Parent> getParentList(int pid);
	   public int updateParent(Parent parent);
	   public boolean checkDuplicate(Parent parent);
	   public int bandClass(int pid,int cid);
	   public List<Parent> getParentsByCid(int cid);
}
