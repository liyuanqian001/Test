package com.baizhuo.smbms.service;

import java.util.List;

import com.baizhuo.smbms.entity.User;

public interface IUserService {
	public User getUser(int id);
	
	public List<User> getlist();

	public List<User> findUsers(User user);

	public User login(User user);

	public int addUser(User user);
	
	public List<User> getname(String name);
}
