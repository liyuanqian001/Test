package com.baizhuo.smbms.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class User implements Serializable {
	private String openid;       //微信id
	private String name;         //微信名称
	private String Gender;          //性别
	private String city;         //地址
	private User user;
	@Autowired
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String Gender) {
		this.Gender = Gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [openid=" + openid + ", name=" + name + ", gender=" + Gender + ", city=" + city
				+ "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String openid, String name, String gender, String city) {
		super();
		this.openid = openid;
		this.name = name;
		this.Gender = Gender;
		this.city = city;
	}


}
