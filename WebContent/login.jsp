
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<title>管理员后台登陆</title>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="loginPage/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="loginPage/css/login.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div id="enter">
			<h1>
				<img alt="XWCMS后台" src="loginPage/images/enter_logo.jpg" />
			</h1>

			<form method="post" action="/cnWeb/LoginServlet">
				<table>
					<tr>
						<td>
							用户名:
						</td>
						<td colspan="3">
							<input class="text" type="text" id="adminName" name="adminName"
								value="admin" />
						</td>
					</tr>
					<tr>
						<td>
							密&nbsp;&nbsp;&nbsp;码:
						</td>
						<td class="width160">
							<input class="text" type="password" name="adminPwd" id="adminPwd" value="666" />
						</td>
						<td colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<th colspan="4">
							<input class="btnEnter" type="submit" name="" value="" />
							<input class="btnBack" type="button" name="" value=""
								onclick="go('http://taobao.xx0511.com')" />
							<input class="btnBorget" type="button" name="" value="" />
							<p>
								&copy; 2003-2009 ShopEx inc. Powered by ECMall
							</p>
							<br />
							<font color="red">${backManager } </font>
						</th>
					</tr>
				</table>
			</form>

		</div>
	</body>
</html>
