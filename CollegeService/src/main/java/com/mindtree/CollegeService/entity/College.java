package com.mindtree.CollegeService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class College 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clgId;
	
	private String name;
	private int noOfStudents;
	
	public Long getClgId() {
		return clgId;
	}
	public void setClgId(Long clgId) {
		this.clgId = clgId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public College(Long clgId, String name, int noOfStudents) {
		super();
		this.clgId = clgId;
		this.name = name;
		this.noOfStudents = noOfStudents;
	}
	public College() {
		super();
	}
	
	
	

}
