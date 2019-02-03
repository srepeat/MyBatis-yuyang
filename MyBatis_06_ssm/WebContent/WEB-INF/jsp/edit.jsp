<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<body> 
	<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
	<form id="itemForm"	action="${pageContext.request.contextPath }/update" method="post">
		修改商品信息：<input type="text" name="id" value="${requestScope.emps.id}" /> 
		<table width="100%" border=1>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="lastName" value="${requestScope.emps.lastName}" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="gender" value="${requestScope.emps.gender}" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${requestScope.emps.email }" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>
</body>

</html>