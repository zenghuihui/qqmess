<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page import="www.xwcms.net.bean.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>添加留言</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

a,img {
	border: 0;
}

body {
	font: 12px/ 180% Arial, Helvetica, sans-serif, "新宋体";
}

.demo {
	width: 800px;
	margin: 40px auto 0 auto;
}
.addTable tr td{height: 40px; font-size: 12px;}
.addTable tr td input{}
</style>
	</head>

	<body>

		<div class="demo">
		   <form method="post" action="MessageServlet?method=add">
			<table class="addTable" width="100%" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<td width="70">
							标题
						</td>
						<td>
							<input style="width: 220px; height: 28px;" type="text" name="messageName"/>
						</td>
					</tr>
					<tr>
						<td>
							性别
						</td>
						<td><input name="messageSex" type="radio" value="男" checked/>男 <input name="messageSex" type="radio" value="女" />女</td>
					</tr>
					<tr>
						<td>
							邮箱
						</td>
						<td>
							<input style="width: 220px; height: 28px;" type="text" name="messageEmail"/>
						</td>
					</tr>
					<tr>
						<td>
							QQ
						</td>
						<td>
							<input style="width: 220px; height: 28px;" type="text" name="messageQQ"/>
						</td>
					</tr>
					<tr>
						<td>
							电话
						</td>
						<td>
							<input style="width: 220px; height: 28px;" type="text" name="messageTel"/>
						</td>
					</tr>
					<tr>
						<td>
							地址
						</td>
						<td>
							<input style="width: 220px; height: 28px;" type="text" name="messageAdd"/>
						</td>
					</tr>
					<tr>
						<td>
							内容
						</td>
						<td>
							<textarea name="messageCont" cols="29" rows="10"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							时间
						</td>
						<td>
							<input style="width: 220px; height: 28px;" type="text" name="messageTime"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input style="width: 80px;height: 30px;" name="添加" type="submit"  value="添加"/><input style="width: 80px;height: 30px;" name="重置" type="reset" />
						</td>
					</tr>

				</thead>

			</table>
			</form>
		</div>

	</body>
</html>
