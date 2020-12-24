package com.baizhuo.smbms.entity;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Student implements Serializable{
	private int userid;//编号
	private String username;//姓名
	private String sex;//性别
	private Date birthYear;//出生日期
	private Date grade;//入学时间
	private int collegeID;//院系id
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(Date birthYear) {
		this.birthYear = birthYear;
	}
	public Date getGrade() {
		return grade;
	}
	public void setGrade(Date grade) {
		this.grade = grade;
	}
	public int getCollegeID() {
		return collegeID;
	}
	public void setCollegeID(int collegeID) {
		this.collegeID = collegeID;
	}
	
	@Override
	public String toString() {
		return "Student [userid=" + userid + ", username=" + username + ", sex=" + sex + ", birthYear="  + birthYear+", grade=" + grade+", collegeID=" + collegeID
				+ "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int userid, String username, String sex, Date birthYear, Date grade,int collegeID) {
		super();
		this.userid = userid;
		this.username = username;
		this.sex = sex;
		this.birthYear = birthYear;
		this.grade = grade;
		this.collegeID = collegeID;
	}

}
