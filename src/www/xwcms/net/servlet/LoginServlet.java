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
			//�жϲ���ֵ������ؿջ�null˵�����ݿ�û�������¼��Ϣ������Ҫ���·��ص�¼�����������
			 session.setAttribute("backManager", "�û����������д���");
			 response.sendRedirect("login.jsp");
		}else
		{
			// �����¼�ɹ�����ת��MessageServlet������ִ�в�ѯ��������
			//?method=list ����Ϊ���ж�servlet��Ҫִ���Ǹ�������
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
