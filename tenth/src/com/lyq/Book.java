package com.lyq;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Book {
private int id;
private String name;
private double price;
private int bookCount;
private String author;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getBookCount() {
	return bookCount;
}
public void setBookCount(int bookCount) {
	this.bookCount = bookCount;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}

public Connection getConnection(){
	Connection conn = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String username ="root";
		String password = "13713393809";
	    conn = DriverManager.getConnection(url,username,password);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return conn;
}

//通过存储过程查询数据
public List<Book> findAll(){
	List<Book> list = new ArrayList<Book>();
    Connection conn = getConnection();
    try{
    	CallableStatement cs = conn.prepareCall("{call findAllBook()}");
    	ResultSet rs = cs.executeQuery();
    	while(rs.next()){
    		Book book = new Book();
    		book.setId(rs.getInt("id"));
    		book.setName(rs.getString("name"));
    		book.setPrice(rs.getDouble("price"));
    		book.setBookCount(rs.getInt("bookCount"));
    		book.setAuthor(rs.getString("author"));
    		list.add(book);
    	}
    }catch(Exception e){
    	e.printStackTrace();
    }
    return list;
}
}
