<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://libs.baidu.com/jquery/2.0.2/jquery.min.js"></script>
<title>用户</title>
</head>
<body>
<form name="data" action="${pageContext.request.contextPath }/addup.do"method ="post">
	<p>
		名称：<input type="text" name="username" value="${list.username}" />
	</p>
	<p>
		性别： <input type="text" name="sex" value="${list.sex}" />
	<p>
	<p>
		出生日期：<input type="text" name="birthYear" value="${list.birthYear}" />
	</p>
	<p>
		入学时间：<input type="text" name="grade" value="${list.grade}" />
	</p>
	<p>
		院系id：<input type="text" name="collegeID" value="${list.collegeID}" />
	</p>
	<p>
		<input type="submit" id="add" name="add"value="新增"/>
		<input type="submit" id="up" name="add"value="修改"/>
	</p>
</form>
</body>
<script type="text/javascript">
<%  
String s2 = (String)request.getParameter("add");
%>
var s = '<%=s2%>';
$(document).ready(function(){
	if(s=="add"){
		$("#add").show();
		$("#up").hide();
	}
	if(s=="up"){
		$("#add").hide();
		$("#up").show();
	}
})


</script>
</html>