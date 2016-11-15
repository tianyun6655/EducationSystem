package com.education.bean;

import java.util.Date;

public class Announcement {
	private int anid;
	private String content;
	private String title;
    private Date date;
	public int getAnid() {
		return anid;
	}
	public void setAnid(int anid) {
		this.anid = anid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
}
