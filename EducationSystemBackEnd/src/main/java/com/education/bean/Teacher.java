package com.education.bean;

public class Teacher {
   private int tid;
   private String name;
   private String password;
   private String mobile;
   private int status;
   private int classAdviser;
   private String createTime;
   private String updateTime;
  
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getClassAdviser() {
	return classAdviser;
}
public void setClassAdviser(int classAdviser) {
	this.classAdviser = classAdviser;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(String updateTime) {
	this.updateTime = updateTime;
}
@Override
public String toString() {
	return "Teacher [tid=" + tid + ", name=" + name + ", password=" + password + ", mobile=" + mobile + ", status="
			+ status + ", classAdviser=" + classAdviser + ", createTime=" + createTime + ", updateTime=" + updateTime
			+ "]";
}
   


}
