package com.lyq;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String username ="root";
			String password = "13713393809";
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			String sql = "select * from tb_book";
			ResultSet rs = stmt.executeQuery(sql);
			List<Book> list = new ArrayList<Book>();
			while(rs.next()){
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setBookCount(rs.getInt("bookCount"));
				book.setAuthor(rs.getString("author"));
				list.add(book);
			}
			request.setAttribute("list", list);
			rs.close();
			stmt.close();
			conn.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("book_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
