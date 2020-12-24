package com.baizhuo.smbms.web.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baizhuo.smbms.entity.Student;
import com.baizhuo.smbms.service.IUserService;
import com.baizhuo.smbms.service.StudentService;
import com.sun.glass.ui.Application;

@Controller

public class StudentConller {
	@Autowired
	private StudentService studentService;
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@Before(value = "")
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		studentService = (StudentService) context.getBean("studentService");
	}
	@RequestMapping(value="/Student1.do")
	public String a(HttpServletRequest request, HttpServletResponse response,String username,String add) {
		//String id=request.getParameter("add");
		System.out.println(add);
		if(add.equals("up")) {
			System.out.println("p"+username);
			return "/user.do";
		}
		String addd=request.getParameter("add");
		request.setAttribute("addd", addd);
		return "jsp/addup.jsp?add="+add;
	}
	/**
	 * 修改页面判断按钮是否是新增或修改
	 * @param student
	 * @param add
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/addup.do")
	public String addup(Student student,String add,HttpServletRequest request, HttpServletResponse response) {
		System.out.println("1");
		String name=request.getParameter("username");
		
		System.out.println(name);
		
	System.out.println(add);
		if(add.equals("新增")){
			return "/add.do";
		}else {
			return "/edit.do";
		}
	}
	
	/**
	 * 查询
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/Student.do")
	public String list(Model model) {
		List<Student> list=studentService.getlist();
		model.addAttribute("list", list);
		return "jsp/role.jsp";
	}
	
	@RequestMapping(value="/all.do")
	public String  userall(String username,String sex,Model model) {
		System.out.println("哈哈"+username);
		List<Student>list=studentService.userall(username, sex);
		System.out.println("111"+list);
		model.addAttribute("list", list);
		return "jsp/role.jsp";
	}
	
	/**
	 * 根据id查询单个信息
	 * @param userid
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/user.do")
	public String  user(String username,Model model) {
		System.out.println("来了"+username);
		Student list=studentService.user(username);
		System.out.println("111"+list);
		model.addAttribute("list", list);
		return "jsp/addup.jsp";
	}
	
	/**
	 * 修改
	 * @param student
	 * @param username
	 * @param sex
	 * @param birthYear
	 * @param grade
	 * @param collegeID
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="/edit.do")
	public String edit(Student student,String sex,Date birthYear,Date grade,int collegeID) throws UnsupportedEncodingException{
		//System.out.println("进来了");
		//System.out.println(collegeID);
		studentService.edit(student);
		return "/Student.do";
	}
	/**
	 * 新增
	 * @param student
	 * @param username
	 * @param sex
	 * @param birthYear
	 * @param grade
	 * @param collegeID
	 * @return
	 */
	@RequestMapping(value="/add.do")
	public String add(Student student,String username,String sex,Date birthYear,Date grade,int collegeID) {
		System.out.println("add");
		studentService.add(student);
		return "/Student.do";
	}
	/**
	 * 根据姓名进行删除
	 * @param username
	 * @return
	 */
	@RequestMapping(value="/delete.do")
	public String delete(String username) {
		System.out.println("delete");
		studentService.delete(username);
		return "/Student.do";
	}
}
