<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>类别</title>
</head>
<body>
<form action="all.do"method="post">
	名称：<input name="username"type="text"/>
	性别：<input name="sex" type="text"/>
	<input type="submit" value="查询">
</form>
		<table>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>入学时间</th>
				<th>院系id</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list}" var="s"> 
			<tr>
				<td><input value="${s.userid}"style="border: none;text-align: center;"/></td>
				<td>${s.username}</td>
				<td>${s.sex}</td>
				<td>${s.birthYear}</td>
				<td>${s.grade}</td>
				<td>${s.collegeID}</td>
				<td><a href="Student1.do?username=${s.username}&add=up"><input type="button" name="add" value="修改"></a></td>
				<td><a href="delete.do?username=${s.username}"><input type="button" value="删除"></a></td>
			</tr>
			</c:forEach>
			<a href="Student1.do?&add=add"><input type="button" name="add" value="新增"></a>
		</table>
		
</body>
</html>