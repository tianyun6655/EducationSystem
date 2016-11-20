package com.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.bean.Parent;
import com.education.mapper.ParentMapper;

@Service
@Transactional
public class ParentService 
{
	
	@Autowired
	ParentMapper parentMapper;
	
	public int signUpForParent(Parent parent)
	{
		//需要添加检查手机号有没有重复
		parentMapper.signUpForParent(parent);
		return parent.getPid();
	}
	public Parent getParentByMobile(String mobile) 
	{
		return parentMapper.getParentByMobile(mobile);
	}
	public List<Parent> getParentList(int pid)
	{
		return parentMapper.getParentList(pid);
	}
	public int updateParent(Parent parent)
	{
		return parentMapper.updateParent(parent);
	}
	public int bandClass(int pid,int cid){
		return parentMapper.bandClass(pid, cid);
	}
	
	public List<Parent> getParentsByCid(int cid){
		return parentMapper.getParentsByCid(cid);
	}
}
