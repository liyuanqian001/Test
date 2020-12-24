package com.baizhuo.smbms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhuo.smbms.entity.User;
import com.baizhuo.smbms.mapper.UserMapper;
import com.baizhuo.smbms.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	private UserMapper userMapper;

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User getUser(int id) {
		return userMapper.get(id);
	}

	public List<User> findUsers(User user) {
		return userMapper.find(user);
	}

	public int addUser(User user) {
		int i = 0;
		userMapper.add(user);
//		User user2 = new User();
//		user2.setOpenid("123");;
//		user2.setName("123");
//		user2.setGender("123");
//		user2.setCity("123");
//		userMapper.add(user2);
		return i;

	}

	public User login(User user) {
		List<User> list = userMapper.find(user);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List<User> getlist() {
		return userMapper.getlist();
	}

	public List<User> getname(String name) {
		return userMapper.getname(name);
	}

}
