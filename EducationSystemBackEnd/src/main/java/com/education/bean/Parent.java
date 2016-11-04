package com.education.bean;

public class Parent {
	   private int pid;
	   private String name;
	   private String password;
	   private String mobile;
	   private String createTime;
	   private String updateTime;
	   private int sex;
	   private int aid;
	   
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	@Override
	public String toString() {
		return "Parent [pid=" + pid + ", name=" + name + ", password=" + password + ", mobile=" + mobile + ", status="
			 + ", createTime=" + createTime + ", updateTime=" + updateTime +", sex=" + sex + ", aid=" + aid
				+ "]";
	}
	   



}
