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
		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		//根据名称获得（表单元素或参数列表）的值
		String sUserName = request.getParameter("userName");
		String sPassWord = request.getParameter("psw");
		boolean flg = false;
		
		User user  = new User(sUserName,sPassWord);
		IUserService uService = new UserService();
		flg = uService.getLoginState(user);
		PrintWriter out = response.getWriter();
		
		if(flg){
			//将用户的信息存入session
			request.getSession().setAttribute("user", user);
			//登录成功，重定向到主页
			response.sendRedirect("index.jsp");
		}else{
			//登录失败，返回到登录页面
			out.print("<script>" +
									"alert('用户名或密码错误，请重新登录！');"+
									"location.href='login.jsp'" +
							"</script>");
		}
	}

}
