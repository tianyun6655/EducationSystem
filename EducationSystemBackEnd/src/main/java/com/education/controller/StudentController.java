package com.education.controller;

import java.io.IOException;
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

import javassist.expr.NewArray;
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
   private void getStudentbysid(HttpServletRequest request,HttpServletResponse response){
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
        	 }
         }
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
	
	private Student initStudent(String name, String birthday, int studentId) {
		Student student = new Student();
		student.setName(name);
		student.setbBirthday(birthday);
		student.setStudentId(studentId);
		return student;
	}
}
