package com.mindtree.studentservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rollNo;
	private String name;
	private String gender;
	private int age;
	private String stream;
	private long clg_id;
	public long getRollNo() {
		return rollNo;
	}
	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public long getClg_id() {
		return clg_id;
	}
	public void setClg_id(long clg_id) {
		this.clg_id = clg_id;
	}
	public Student(long rollNo, String name, String gender, int age, String stream, long clg_id) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.stream = stream;
		this.clg_id = clg_id;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", gender=" + gender + ", age=" + age + ", stream="
				+ stream + ", clg_id=" + clg_id + "]";
	}
	
	

	
}
