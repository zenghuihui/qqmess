<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="www.xwcms.net.bean.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示留言数据</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
.demo{width:800px;margin:40px auto 0 auto;}
/* tablescroll */
.tablescroll{font:12px normal Tahoma, Geneva, "Helvetica Neue", Helvetica, Arial, sans-serif;background-color:#fff;}
.tablescroll td,.tablescroll_wrapper,.tablescroll_head,.tablescroll_foot{border:1px solid #ccc;}
.tablescroll td{padding:5px;}
.tablescroll_wrapper{border-left:0;}
.tablescroll_head{font-size:12px;font-weight:bold;background-color:#eee;border-left:0;border-top:0;margin-bottom:3px;}
.tablescroll thead td{border-right:0;border-bottom:0;}
.tablescroll tbody td{border-right:0;border-bottom:0;}
.tablescroll tbody tr.first td{border-top:0; font-size: 12px;}
.tablescroll_foot{font-weight:bold;background-color:#eee;border-left:0;border-top:0;margin-top:3px;}
.tablescroll tfoot td{border-right:0;border-bottom:0;}
</style>
<script type="text/javascript">
function openAddPage()
{
   window.open("messageAdd.jsp",'_self') 
}
</script>
  </head>
  
  <body>
  
    <div class="demo">
    <table>
    <tr><td colspan="10"><input type="button" style="width: 80px; height: 35px;" value="添加" onclick="openAddPage()"/></td></tr>
    </table>
	<table id="thetable" cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<td>标题</td>
				<td>性别</td>
				<td>邮箱</td>
				<td>QQ</td>
				<td>电话</td>
				<td>地址</td>
				<td>内容</td>
				<td>时间</td>
				<td>修改</td>
				<td>删除</td>
			</tr>
		</thead>
		<tbody>
		 <%
		    List list =(List)session.getAttribute("list");
		    for(int i=0;i<list.size();i++)
		    {
		       Message message =(Message)list.get(i);
		  %>
		 
			   <tr class="first">
					<td><%=message.getMessageName() %></td>
					<td><%=message.getMessageSex()%></td>
					<td><%=message.getMessageEmail()  %></td>
					<td><%=message.getMessageQQ()%></td>
					<td><%=message.getMessageTel()  %></td>
					<td><%=message.getMessageAdd()%></td>
					<td><%=message.getMessageCont()%></td>
					<td><%=message.getMessageTime()%></td>
					<td><a href="MessageServlet?method=edit&messageId=<%=message.getMessageId() %>">修改</a></td>
					<td><a href="MessageServlet?method=delete&messageId=<%=message.getMessageId() %>">删除</a></td>
				</tr>
		  <%         
		    }
		 %>
			
			
		</tbody>
		
	</table>
</div>
	
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.tablescroll.js"></script>
<script type="text/javascript">
$(document).ready(function($){
	$('#thetable').tableScroll({
		width:780,
		height:250
	});
});
</script>
  </body>
</html>
