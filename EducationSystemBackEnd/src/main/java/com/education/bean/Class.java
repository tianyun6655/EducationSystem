package com.education.bean;

public class Class {
private int cid;
private int grade;
private int no;// class number 

public int getCid()
{
	return cid;
}
public int getGrade()
{
	return grade;
}
public int getClassNo()
{
	return no;
}
public void  setCid(int cid)
{
	this.cid=cid;
}
public void setGrade(int grade)
{
	this.grade= grade;
}
public void setClassNo(int no)
{
	this.no= no;
}
@Override
public String toString()
{
	return "Class [cid=" + cid + ", grade=" + grade + ", no="+no+"]";
}




}
