<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加记录</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/additems.action" method=post>
		<!-- <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0 align="center"> 
			<TBODY>
				<TR>
					<TD width=15><IMG  border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
						</TABLE> -->
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>商品名称：</td>
								<td>
									<INPUT maxLength=50 type="text" name="name">
								</td>
								<td>商品价格 ：</td>
								<td>
									<input type="text" name="price" />
								</td>
							</tr>
							<tr>
								<td>商品来源 ：
								</td>
								<td>
									<input type="text" name="source" />
								</td>
									
								<td>商品类型 ：</td>
								<td>
									<input type="text" name="type" />
								</td>
							</tr>
								<td rowspan=2>
									<INPUT class=button id=sButton2 type=submit value=" 保存 " name=sButton align="center">
								</td>
							</tr>
						</TABLE>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG border=0></TD>
					<TD align=middle width="100%" height=15></TD>
					<TD width=15><IMG border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
