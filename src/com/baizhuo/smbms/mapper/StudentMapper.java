package com.baizhuo.smbms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhuo.smbms.entity.Student;

public interface StudentMapper {
	public List<Student> getlist();//查询所有
	public Student user(String username);//查询单条
	public List<Student> userall(@Param("username")String username,@Param("sex")String sex);//查询多个
	public int edit(Student student);//修改
	public int add(Student student);//新增
	public int delete(String username);//删除
}
