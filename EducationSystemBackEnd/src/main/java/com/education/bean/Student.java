package com.education.bean;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

public class Student {
	private int stid;
	private String name;
	private int age;
	private String hobby;
	private int  sttudent_id;
	private int sex;
	
	public void setStudentID(int stid)
	{
		this.stid=stid;
	}
	public void getName(String name)
	{
		this.name=name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	 public void setHobby(String hobby) {
		this.hobby=hobby;
	}
	public void setSttudentID(int sttudent_id)
	{
		this.sttudent_id=sttudent_id;
	}
    public void setGender(int sex)
    {
    	this.sex=sex;
    }
    public void setSstudentID(int sttudent_id)
	{
		this.sttudent_id=sttudent_id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getAge()
	{
		return age;
	}
	 public String getHobby() {
		return hobby;
	}
	public int getSttudentID()
	{
		return sttudent_id;
	}
    public int getGender()
    {
    	return sex;
    }
    public int getSstudentID()
    {
    	return sttudent_id;
    }
    
}
