package com.mindtree.studentservice.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import com.mindtree.studentservice.Entity.Student;
import com.mindtree.studentservice.Repository.StudentRepository;
import com.mindtree.studentservice.Service.StudentService;
import com.mindtree.studentservice.VO.College;
import com.mindtree.studentservice.VO.ResponseTemplate;


@Component
public class StudentImpl implements StudentService
{
	@Autowired
	private  StudentRepository stdRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Student addStudent(Student std) 
	{
		return stdRepo.save(std);
	}

	@Override
	public List<Student> list() {
		return stdRepo.findAll();
	}

	@Override
	public Student searchById(long id) {
		return stdRepo.findById(id);
	}

	@Override
	public ResponseTemplate stdWithCollege(long rollNo) {
		ResponseTemplate RT = new ResponseTemplate();
		Student std = stdRepo.findById(rollNo);
		
		long clg_id = std.getClg_id();
		College clg= restTemplate.getForObject("http://COLLEGE-SERVICE/department/"+clg_id, College.class);
		RT.setCollege(clg);
		RT.setStudent(std);
		return RT;
	}

	@Override
	public Student assignCollege(long rollNo, long clgId) 
	{
		Student std = stdRepo.findById(rollNo);
		College clg = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+rollNo, College.class);

		std.setClg_id(rollNo);
		stdRepo.save(std);
		return std;
	}

	@Override
	public List<Student> getByCollegeId(long clg_id) 
	{
		return stdRepo.getByClgId(clg_id);
	}

	@Override
	public List<Student> getStudentByStreamWithDescAge(String strm)
	{
		return stdRepo.getByStudentStreamWithDescAge(strm);
	}


}
