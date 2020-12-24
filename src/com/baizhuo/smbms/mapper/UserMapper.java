package com.baizhuo.smbms.mapper;

import java.util.List;

import com.baizhuo.smbms.entity.User;

public interface UserMapper {
	public User get(int id);
  
	public List<User> getlist();
	
	public List<User> find(User user);
	
	public int add(User user);
	
	public List<User> getname(String name);
}
