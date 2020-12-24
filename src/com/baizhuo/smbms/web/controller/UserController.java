package com.baizhuo.smbms.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baizhuo.smbms.entity.User;
import com.baizhuo.smbms.service.IUserService;

@Controller
@RequestMapping(value="/user.do")
public class UserController {
	private IUserService userService;

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(params="action=login")
	public String login(User user, HttpServletRequest request) {
		User login = userService.login(user);
		if (login != null) {
			request.getSession().setAttribute("user", login);
			return "jsp/frame";// /index.jsp
		} else {
			request.setAttribute("error", "登录失败，用户名或密码错误！");
			return "login";// /login.jsp
		}
	}
	
/*	@RequestMapping(params="method=query")
	public String login1(User user, HttpServletRequest request) {
		User login = userService.login(user);
		if (login != null) {
			request.getSession().setAttribute("user", login);
			return "jsp/userlist";
		} else {
			request.setAttribute("error", "登录失败，用户名或密码错误！");
			return "frame";//
		}
	}*/
	
	@RequestMapping(params="method=query")
	public String list(Model model) {
		List<User> list = userService.getlist();
		model.addAttribute("userList", list);
		System.out.println(12341);
		return "jsp/userlist";//转发
	}
	@RequestMapping(params="action=getuser")
	public String getuser(String queryname,HttpServletRequest request) {
		User user = new User();
		System.out.println(">>>>>>"+queryname);
//		user.setUserName(queryname);
		List<User> list = userService.getname(queryname);
		return "jsp/userlist";
	}
	
	@RequestMapping(params="action=logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
}
