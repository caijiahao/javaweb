package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.User;
import com.service.IUserService;
import com.service.impl.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//����������������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		//�������ƻ�ã���Ԫ�ػ�����б���ֵ
		String sUserName = request.getParameter("userName");
		String sPassWord = request.getParameter("psw");
		boolean flg = false;
		
		User user  = new User(sUserName,sPassWord);
		IUserService uService = new UserService();
		flg = uService.getLoginState(user);
		PrintWriter out = response.getWriter();
		
		if(flg){
			//���û�����Ϣ����session
			request.getSession().setAttribute("user", user);
			//��¼�ɹ����ض�����ҳ
			response.sendRedirect("index.jsp");
		}else{
			//��¼ʧ�ܣ����ص���¼ҳ��
			out.print("<script>" +
									"alert('�û�����������������µ�¼��');"+
									"location.href='login.jsp'" +
							"</script>");
		}
	}

}
