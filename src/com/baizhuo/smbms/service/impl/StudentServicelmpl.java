package com.baizhuo.smbms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhuo.smbms.entity.Student;
import com.baizhuo.smbms.mapper.StudentMapper;
import com.baizhuo.smbms.mapper.UserMapper;
import com.baizhuo.smbms.service.StudentService;

@Service(value = "studentService")
public class StudentServicelmpl implements StudentService{

	private StudentMapper studentMapper;
	
	@Autowired
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	
	public List<Student> getlist() {
  		return studentMapper.getlist();
	}

	public Student user(String username) {
		return studentMapper.user(username);
	}
	public List<Student> userall(String username,String sex) {
		return studentMapper.userall(username, sex);
	}

	public int edit(Student student) {
		return studentMapper.edit(student);
	}

	public int add(Student student) {
		return studentMapper.add(student);
	}

	public int delete(String username) {
		return studentMapper.delete(username);
	}
	
}
