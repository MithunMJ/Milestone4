package com.mindtree.studentservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.studentservice.Entity.Student;
import com.mindtree.studentservice.Service.StudentService;
import com.mindtree.studentservice.VO.ResponseTemplate;



@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	StudentService studentService;
	
	@PostMapping
	public Student addStudent(@RequestBody Student std)
	{
		return studentService.addStudent(std);
	}
	
	@GetMapping
	public List<Student> getStudent() 
	{
		return studentService.list();
	}
	
	@GetMapping("/{rollNo}")
	public ResponseTemplate stdWithCollege(@PathVariable long rollNo)
	{
		return studentService.stdWithCollege(rollNo);
	}
	
	@PutMapping("/{rollno}/{clgId}")
	public String updateCollege(@PathVariable long rollno,@PathVariable long clgId)
	{
		Student std = studentService.assignCollege(rollno,clgId);
		if(std!=null)
		{
			return std.toString();
		}
		return "Sorry. Data not Found";
	}
	
	@GetMapping("/student-with-ascname/{clg_id}")
	public List<Student> getByCollegeId(@PathVariable long dept_id)
	{
		return studentService.getByCollegeId(dept_id);
	}
	
	@GetMapping("/student-with-desc-age/{strm}")
	public List<Student> getStudentByCollegeWithDescAge(@PathVariable String strm)
	{
		return studentService.getStudentByStreamWithDescAge(strm);
	}


}
