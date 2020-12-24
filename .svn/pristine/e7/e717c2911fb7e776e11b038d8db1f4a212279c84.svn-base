package com.baizhuo.smbms.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baizhuo.smbms.entity.User;
import com.baizhuo.smbms.service.IUserService;

@Controller
public class LoginController {
	private IUserService userService;

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (IUserService) context.getBean("userService");
	}
	@RequestMapping(value="/login.do")
	public void testAddUser1() {
		System.out.println("123");
		User user = new User();
		user.setOpenid("123");
		user.setName("123");
		user.setGender("123");
		user.setCity("123");
		userService.addUser(user);
	}
	
	//@RequestMapping(value="/login.do")
	public String login(User user,HttpServletRequest request) {
		User login = userService.login(user);
		if (login != null) {
			request.getSession().setAttribute("user", login);
			return "jsp/frame";// /index.jsp
		} else {
			request.setAttribute("error", "登录失败，用户名或密码错误！");
			return "login";// /login.jsp
		}
	}
	
	//@RequestMapping(value="/login.do")
	public String login(User user,HttpSession session,Model model) {
		User login = userService.login(user);
		if (login != null) {
			session.setAttribute("user", login);
			return "jsp/index";// /index.jsp
		} else {
			model.addAttribute("error", "登录失败，用户名或密码错误！");
			return "login";// /login.jsp
		}
	}
	
	//@RequestMapping(value="/login.do")
	public ModelAndView login(User user,HttpSession session,ModelAndView mv) {
		User login = userService.login(user);
		if (login != null) {
			session.setAttribute("user", login);
			mv.setViewName("index");
		} else {
			mv.addObject("error","登录失败，用户名或密码错误！");
			mv.setViewName("login");
		}
		return mv;
	}


}
