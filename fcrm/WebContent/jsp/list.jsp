<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<style type="text/css">
	a {
		text-decoration: none;
	}
</style>

<script type="text/javascript">
function delProFromCart(id){
	if(confirm("你是否确定删除?")){
		location.href="${pageContext.request.contextPath }/itemDelete.action?id="+id;
	}
}
</script>
</head>
<body> 
<form action="${pageContext.request.contextPath }/queryitem.action" method="post">
商品列表：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>商品日期</td>
	<td>商品来源</td>
	<td>商品类型</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemList }" var="item">
<tr>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td>${item.source }</td>
	<td>${item.type }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>
	<a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a>
	&nbsp;&nbsp;&nbsp;
	<%-- <a href="${pageContext.request.contextPath }/itemDelete.action?id=${item.id}">删除</a> --%>
	<a href="javascript:;" onclick="delProFromCart('${item.id}')" class="delete">删除</a>
	</td>
</tr>
</c:forEach>

</table>
</form>
</body>

</html>