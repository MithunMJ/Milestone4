package com.mindtree.studentservice.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.studentservice.Entity.Student;
import com.mindtree.studentservice.VO.ResponseTemplate;

@Service
public interface StudentService
{
    Student addStudent(Student std);
	List<Student> list();
	Student searchById(long id);
	ResponseTemplate stdWithCollege(long rollNo);
	Student assignCollege(long rollNo, long clgId);
	List<Student> getByCollegeId(long clg_id);
	List<Student> getStudentByStreamWithDescAge(String strm);

}
