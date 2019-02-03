<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>

<style type="text/css">
	.top{
		border: 1px black solid; 
	 }

	tr td{
		border: 1px black solid; 
	 }
	 
	a {
		text-decoration: none;
		color: black;
	}
	
	.but {
		 width: 29%;
	}
	

</style>
	<script type="text/javascript">
		function delProFromCart(id) {
			if(confirm("你是否确定删除?")){
				location.href="${pageContext.request.contextPath }/delete?id="+id;
			}
		}
		
	</script>

</head>
<body>
<div align="center">
<p>查询信息</p>
	<table class="top">
	
		<button class="but"><a href="${pageContext.request.contextPath }/skipAdd">添加</a></button>
			<tr>
				<td>id</td>
				<td>lastName</td>
				<td>email</td>
				<td>gender</td>
				<td>update</td>
				<td>delete</td>
			</tr>
		<c:forEach items="${allEmps }" var="emp">
			<tr class="one">
				<td>${emp.id }</td>
				<td>${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>${emp.gender }</td>
				<td><a href="${pageContext.request.contextPath }/findAll?id=${emp.id}">修改</a></td>
				<td><a href="javascript:;" onclick="delProFromCart('${emp.id}')">删除</a></td>
			</tr>
		</c:forEach>
	
				<%-- <td><a href="${pageContext.request.contextPath }/delete?id=${emp.id }">删除</a></td> --%>
	</table>
</div>
</body>
</html>