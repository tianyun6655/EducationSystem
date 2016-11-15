package com.education.mapper;

import java.util.List;

import com.education.bean.Announcement;

public interface AnnouncementMapper {
	
	public int createAnnouncement(Announcement announcement);
    public int bandClass(int cid,int anid);
    public int bandTeacher(int tid,int anid);
    public List<Announcement> getAnnouncementByClass(int cid);
    
}
