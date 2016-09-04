package com.lyq;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindsServlet
 */
@WebServlet("/FindsServlet")
public class FindsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int currPage = 1;
		if(request.getParameter("page")!= null){
			currPage =Integer.parseInt(request.getParameter("page"));
		}
		ProductDao dao = new ProductDao();
		List<Product> list = dao.find(currPage);
		request.setAttribute("list", list);
		int pages;
		int count = dao.findCount();
		if(count%Product.PAGE_SIZE == 0){
			pages = count/Product.PAGE_SIZE;
		}else{
			pages = count/Product.PAGE_SIZE + 1;
		}
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<pages;i++){
			if(i == currPage){
				sb.append(" [" + i + "]");
			}else{
				sb.append("<a href='FindsServlet?page="+i+"'>"+i+"</a>");
			}
			sb.append("  ");
		}
		request.setAttribute("bar", sb.toString());
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
