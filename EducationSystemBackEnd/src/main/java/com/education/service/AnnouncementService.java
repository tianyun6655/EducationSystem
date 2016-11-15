package com.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.bean.Announcement;
import com.education.mapper.AnnouncementMapper;

@Service
@Transactional
public class AnnouncementService {

	@Autowired
	AnnouncementMapper announcementMapper;
	
	public int createAnnounment(Announcement announcement,int cid,int tid){
		announcementMapper.createAnnouncement(announcement);
		if(announcement.getAnid()!=0){
			announcementMapper.bandClass(cid, announcement.getAnid());
			announcementMapper.bandTeacher(tid, announcement.getAnid());
			return 1;

		}else {
		   return 0;
		}
		
		
	}
	
	public List<Announcement> getListByClass(int cid){
		return announcementMapper.getAnnouncementByClass(cid);
		
	}
}
