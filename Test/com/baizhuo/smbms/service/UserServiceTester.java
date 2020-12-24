package com.baizhuo.smbms.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baizhuo.smbms.entity.User;

public class UserServiceTester {
	private IUserService userService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (IUserService) context.getBean("userService");
	}

//	@Test
//	public void testGetUser() {
//		User user = userService.getUser(1);
////		System.out.println(user.getUserName());
//	}
	
//	@Test
//	public void testFindUsers() {
//		User user = new User();
////		user.setUserCode("admin");
//		List<User> list = userService.findUsers(user);
//		System.out.println(list.size());
//	}
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setOpenid("123");;
		user.setName("123");
		user.setGender("123");
		user.setCity("123");
		userService.addUser(user);
	}

//	@Test
//	public void testlist() {
//		List<User> list = userService.getlist();
//		for(User user:list){
////			System.out.println(user.getUserCode()+"\t"+user.getUserName()+"\t"+user.getGender()+"\t"+user.getPhone()+"\t"+user.getAddress()+"\t"+user.getUserRole());
//		}
//	}
}
