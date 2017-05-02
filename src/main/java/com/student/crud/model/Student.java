package com.student.crud.model;

public class Student {

	private String stuNo;

	private String stufName;

	private String stulName;

	private String stuEmail;

	public Student(String stuNo, String stufName, String stulName, String stuEmail) {
		this.stuNo = stuNo;
		this.stufName = stufName;
		this.stulName = stulName;
		this.stuEmail = stuEmail;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStufName() {
		return stufName;
	}

	public void setStufName(String stufName) {
		this.stufName = stufName;
	}

	public String getStulName() {
		return stulName;
	}

	public void setStulName(String stulName) {
		this.stulName = stulName;
	}

	public String getEmail() {
		return stuEmail;
	}

	public void setEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

}
