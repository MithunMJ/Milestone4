package com.mindtree.studentservice.VO;

public class College
{
	private Long clgId;
	private String name;
	private int noOfStudents;
	private String stream;
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
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public College(Long clgId, String name, int noOfStudents, String stream) {
		super();
		this.clgId = clgId;
		this.name = name;
		this.noOfStudents = noOfStudents;
		this.stream = stream;
	}
	public College() {
		super();
	}
	
	

}
