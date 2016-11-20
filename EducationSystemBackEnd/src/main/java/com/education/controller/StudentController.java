package com.education.controller;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.education.bean.Student;
import com.education.bean.StudentList;
import com.education.service.StudentService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "createStduent", method = RequestMethod.POST)
	public void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		if (name != null && birthday != null && studentId != 0) {
			int result = studentService.createStudent(initStudent(name, birthday, studentId));
			if (result == 0) {
				jsonObject.put("code", 0);
			} else {
				JSONObject dataObject = new JSONObject();
				dataObject.put("stid", request);
				jsonObject.put("code", 1);
				jsonObject.put("data", dataObject);
			}

		} else {
			jsonObject.put("code", 0);
		}

		response.getWriter().write(jsonObject.toString());
		response.getWriter().close();

	}
   @RequestMapping(value="getStudentbyStid",method=RequestMethod.POST)
   private void getStudentbysid(HttpServletRequest request,HttpServletResponse response) throws IOException{
         JSONObject result =new JSONObject();
         int stid = Integer.parseInt(request.getParameter("stid"));
         if(stid==0){
        	 result.put("code", -1);
         }else{
        	 Student tempStudent = studentService.getStudentByStid(stid);
        	 if(tempStudent!=null){
        		 result.put("code", 1);
        		 JSONObject data = new JSONObject();
        		 data.put("name",tempStudent.getName());
        		 data.put("birthday", tempStudent.getBirthday());
        		 data.put("studentId", tempStudent.getStudentId());
				 data.put("cid", tempStudent.getCid());

        		 result.put("data", data);
        	 }
         }
         response.getWriter().write(result.toString());
         response.getWriter().close();
   }
   
   @RequestMapping(value="getStduentListByPid",method=RequestMethod.POST)
   public void getStudentByPid(HttpServletRequest request,HttpServletResponse response) throws IOException{
	   JSONObject result  = new JSONObject();
       int pid = Integer.parseInt(request.getParameter("pid"));
       List<StudentList> list = studentService.getStudentListItem(pid);
       if(list.size()==0){
    	   result.put("code", 0);
       }else{
    	   JSONArray jsonArray = new JSONArray();
    	   for(int i=0;i<list.size();i++){
    		   JSONObject eachItem = new JSONObject();
    		   eachItem.put("stid", list.get(i).getStid());
    		   eachItem.put("name", list.get(i).getName());
    		   eachItem.put("schoolName", list.get(i).getSchoolName());
    		   
    		   eachItem.put("grade", list.get(i).getGrade());
    		   eachItem.put("no", list.get(i).getNo());
    		   
    		  jsonArray.add(eachItem);
    	   }
    	   
    	   result.put("code", 1);
    	   result.put("data", jsonArray);
    	   
       }
       
       response.getWriter().write(result.toString());
       response.getWriter().close();
       
   }
   
	@RequestMapping(value="getStudentBycid",method=RequestMethod.POST)
	public void getStudentByCid(HttpServletRequest request,HttpServletResponse response) throws IOException{
		 int cid = Integer.parseInt(request.getParameter("cid"));
		 JSONObject resultJson = new JSONObject();
		 if(cid==0){
			 resultJson.put("code", -1);
		 }else{
			 List<Student> students = studentService.getStudentBycid(cid);
			 if(students.isEmpty()){
				 resultJson.put("code", 0);
			 }else{
				 JSONArray jArray = new JSONArray();
				 for(int i =0;i<students.size();i++){
					 JSONObject signle = new JSONObject();
					 signle.put("stid",students.get(i).getStid());
					 signle.put("name", students.get(i).getName());
					 signle.put("studentId", students.get(i).getStudentId());
					 jArray.add(signle);
					 
				 }
				 resultJson.put("code", 1);
				 resultJson.put("data", jArray);
			 }
		 }
		 
		 response.getWriter().write(resultJson.toString());
		 response.getWriter().close();
	}
	
	@RequestMapping(value="bandParent", method=RequestMethod.POST)
	public void bandParent(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject resultJson = new JSONObject();
	     int stid = Integer.parseInt(request.getParameter("stid"));
	     int pid =Integer.parseInt(request.getParameter("pid"));
	     if(stid==0||pid==0){
	    	 resultJson.put("code", -1);
	     }else{
	    	 studentService.bandParent(stid, pid);
	    	 resultJson.put("code", -1);
	     }
	     response.getWriter().write(resultJson.toString());
	     response.getWriter().close();
	     
	}
	private Student initStudent(String name, String birthday, int studentId) {
		Student student = new Student();
		student.setName(name);
		student.setbBirthday(birthday);
		student.setStudentId(studentId);
		return student;
	}
	

}
