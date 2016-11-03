package com.education.bean;

public class SchoolAndAddress {
	private int sid;
	
   private String name;
   private int schoolType;
   private int aid;
   private String province;
   private String road;
   private String qu;
   private String city;
   private int type;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSchoolType() {
	return schoolType;
}
public void setSchoolType(int schoolType) {
	this.schoolType = schoolType;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getRoad() {
	return road;
}
public void setRoad(String road) {
	this.road = road;
}
public String getQu() {
	return qu;
}
public void setQu(String qu) {
	this.qu = qu;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}

public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
@Override
public String toString() {
	return "SchoolAndAddress [name=" + name + ", schoolType=" + schoolType + ", aid=" + aid + ", province=" + province
			+ ", road=" + road + ", qu=" + qu + ", city=" + city + ", type=" + type + "]";
}
   
}
