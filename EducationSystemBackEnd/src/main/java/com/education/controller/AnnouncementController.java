package com.education.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.education.bean.Announcement;
import com.education.service.AnnouncementService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("api/announcement")
public class AnnouncementController {

	@Autowired
	AnnouncementService announcementService;
	
	@RequestMapping("create")
	public void createAnnouncement(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		int anid  = Integer.parseInt(request.getParameter("anid"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		int tid  = Integer.parseInt(request.getParameter("tid"));
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = simpleDateFormat.parse(request.getParameter("date"));
		
		announcementService.createAnnounment(initAnnouncement(content, title, date),cid,tid);
		
		
		System.out.println(title+content+date.toString());
	}
	
	@RequestMapping(value="listbyclass",method=RequestMethod.POST)
	public void getAnnouncementByClass(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int cid  =Integer.parseInt(request.getParameter("cid"));
		List<Announcement> announcements = announcementService.getListByClass(cid);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject resultJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<announcements.size();i++){
			JSONObject singleJson = new JSONObject();
		    singleJson.put("title", announcements.get(i).getTitle());
		    singleJson.put("content", announcements.get(i).getContent());
		    singleJson.put("date", simpleDateFormat.format(announcements.get(i).getDate()));
		    jsonArray.add(singleJson);
		}
           resultJson.put("data", jsonArray);
           
           
           response.getWriter().write(resultJson.toString());
	       response.getWriter().close();	
	}
	
	private Announcement initAnnouncement(String content,String title, Date date){
		Announcement announcement  = new Announcement();
		announcement.setContent(content);
		announcement.setTitle(title);
		announcement.setDate(date);
		return announcement;
	}
}
