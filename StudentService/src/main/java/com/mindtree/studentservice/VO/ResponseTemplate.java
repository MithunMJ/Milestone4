package com.mindtree.studentservice.VO;

import com.mindtree.studentservice.Entity.Student;

public class ResponseTemplate 
{
	private Student student;
	private College College;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public College getCollege() {
		return College;
	}
	public void setCollege(College college) {
		College = college;
	}
	public ResponseTemplate(Student student,College college) {
		super();
		this.student = student;
		College = college;
	}
	public ResponseTemplate() {
		super();
	}

}
