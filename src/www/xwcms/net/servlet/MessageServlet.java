package www.xwcms.net.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import www.xwcms.net.bean.Message;
import www.xwcms.net.dao.MessageDao;

@SuppressWarnings("serial")
public class MessageServlet extends HttpServlet {

	 protected void messageServlet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
		 //method从前台传递过来的参数，用来判断要执行那种方法（查询、添加、删除、修改）方法。
		 String method = request.getParameter("method");
		 MessageDao messageDao =new MessageDao();
		 if(method.equals("list"))
		 {
			 //调用查询所有留言信息
			 this.list(request, response, messageDao);
			 
		 }else if(method.equals("add"))
		 {
			 //调用添加留言信息
			 this.add(request, response, messageDao);
			 
		 }else  if(method.equals("delete"))
		 {
			 //调用删除留言信息
			 this.delete(request, response, messageDao);
			 
		 }else if(method.equals("update"))
		 {
			 //调用修改留言信息
			 this.update(request, response, messageDao);
			 
		 }else if(method.equals("edit"))
		 {
			 //修改数据是根据ID查找单条数据
			 this.edit(request, response, messageDao);
			 
		 }
	 }
	@SuppressWarnings("unchecked")
	public void list(HttpServletRequest request, HttpServletResponse response,MessageDao messageDao) throws IOException
	{
		HttpSession session =request.getSession();
		List list =messageDao.messageList();
		session.setAttribute("list", list);
		response.sendRedirect("message.jsp");
	}
	public void add(HttpServletRequest request, HttpServletResponse response,MessageDao messageDao) throws IOException
	{
		String messageName=request.getParameter("messageName");
		String messageSex=request.getParameter("messageSex");
		String messageEmail=request.getParameter("messageEmail");
		String messageQQ=request.getParameter("messageQQ");
		String messageTel=request.getParameter("messageTel");
		String messageAdd=request.getParameter("messageAdd");
		String messageCont=request.getParameter("messageCont");
		String messageTime=request.getParameter("messageTime");
		Message message =new Message();
		message.setMessageId(UUID.randomUUID().toString());//获取UUID作为主键，大家也可以用其他主键或自动增长列
		message.setMessageName(messageName);
		message.setMessageSex(messageSex);
		message.setMessageEmail(messageEmail);
		message.setMessageQQ(messageQQ);
		message.setMessageTel(messageTel);
		message.setMessageAdd(messageAdd);
		message.setMessageCont(messageCont);
		message.setMessageTime(messageTime);
		messageDao.messageAdd(message);
		response.sendRedirect("MessageServlet?method=list");
	}
	public void delete(HttpServletRequest request, HttpServletResponse response,MessageDao messageDao) throws IOException
	{
		String messageId=request.getParameter("messageId");
		messageDao.messageDelete(messageId);
		response.sendRedirect("MessageServlet?method=list");
	}
	public void edit(HttpServletRequest request, HttpServletResponse response,MessageDao messageDao) throws IOException
	{
		HttpSession session =request.getSession();
		String messageId=request.getParameter("messageId");
		Message message=messageDao.messageEdit(messageId);
		session.setAttribute("message", message);
		response.sendRedirect("messageUpdate.jsp");
	}
	public void update(HttpServletRequest request, HttpServletResponse response,MessageDao messageDao) throws IOException
	{
		//String messageId=request.getParameter("MessageId");
		String messageId=request.getParameter("messageId");
		String messageName=request.getParameter("messageName");
		String messageSex=request.getParameter("messageSex");
		String messageEmail=request.getParameter("messageEmail");
		String messageQQ=request.getParameter("messageQQ");
		String messageTel=request.getParameter("messageTel");
		String messageAdd=request.getParameter("messageAdd");
		String messageCont=request.getParameter("messageCont");
		String messageTime=request.getParameter("messageTime");
		Message message =new Message();
		message.setMessageId(messageId);
		message.setMessageName(messageName);
		message.setMessageSex(messageSex);
		message.setMessageEmail(messageEmail);
		message.setMessageQQ(messageQQ);
		message.setMessageTel(messageTel);
		message.setMessageAdd(messageAdd);
		message.setMessageCont(messageCont);
		message.setMessageTime(messageTime);
		messageDao.messageUpdate(message);
		response.sendRedirect("MessageServlet?method=list");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		messageServlet(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		messageServlet(request,response);
	}

}
