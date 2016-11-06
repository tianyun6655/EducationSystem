package com.education.bean;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.steps.idSeekLeafPlanner;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

public class Student {
  private int stid;
  private int studentId;
  private int age;
  private String name;
public int getStid() {
	return stid;
}
public void setStid(int stid) {
	this.stid = stid;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
  
    
}
