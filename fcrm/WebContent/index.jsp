<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a {
		text-decoration: none;
	}
	
	#one {
		font-size: 20px;
	}
	
</style>
</head>
<body>
	
<div align="center" id="one">
	<h2>账单管理</h2>
	<hr>
	<a href="${pageContext.request.contextPath }/custitems.action">查询信息</a>
	<br>
	<a href="${pageContext.request.contextPath }/addjump.action">添加信息</a>
</div>

</body>
</html>