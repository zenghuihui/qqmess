package www.xwcms.net.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import www.xwcms.net.dao.LoginDao;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	 protected void login(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
		 HttpSession session =request.getSession();
		String adminName=request.getParameter("adminName");
		String adminPwd=request.getParameter("adminPwd");
		LoginDao loginServlet=new LoginDao();
		String backValue=loginServlet.adminLogin(adminName, adminPwd);
		if(backValue==null||backValue=="")
		{
			//判断查找值如果返回空或null说明数据库没有这个登录信息，所以要从新返回登录界面从新输入
			 session.setAttribute("backManager", "用户名或密码有错误！");
			 response.sendRedirect("login.jsp");
		}else
		{
			// 如果登录成功则跳转到MessageServlet方法并执行查询所有数据
			//?method=list 参数为了判断servlet需要执行那个方法。
			 response.sendRedirect("MessageServlet?method=list");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login(request,response);
	}

}
