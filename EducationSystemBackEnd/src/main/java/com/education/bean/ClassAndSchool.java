package com.education.bean;


public class ClassAndSchool {

	private int grade;
	private int no;
	private String name;
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ClassAndSchool [grade=" + grade + ", no=" + no + ", name=" + name + "]";
	}
	
	
	
	
}
