package com.wgh.servlet;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Servlet implementation class PlacardServlet
 */
@WebServlet("/PlacardServlet")
public class PlacardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlacardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String fileURL = request.getRealPath("/xml/placard.xml");    //xml文件的路径
		File file = new File(fileURL);
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		Document document = null;
		Element placard = null;
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		if(!file.exists()){
			document = DocumentHelper.createDocument();
			placard=DocumentHelper.createElement("placard");
			document.setRootElement(placard);
			placard.addAttribute("version", "2.0");
			Element description = placard.addElement("description");
			description.setText("公告栏");
			Element createTime = placard.addElement("createTime");
			createTime.setText("创建于"+df.format(new Date()));
		}else{
			SAXReader reader = new SAXReader();
			try{
				document = reader.read(new File(fileURL));
				placard = document.getRootElement();
			}catch(DocumentException e){
				e.printStackTrace();
			}
		}
		
		String id = String.valueOf(placard.elements("info").size()+1);
		Element info = placard.addElement("info");
		info.addAttribute("id", id);
		Element title_info = info.addElement("tilte");
		title_info.setText(title);
		Element content_item = info.addElement("content");
		
		content_item.addCDATA(content);
		Element pubDate_item = info.addElement("pubDate");
		df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		pubDate_item.setText(df.format(new Date()));
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		try{
			XMLWriter writer = new XMLWriter(new FileWriter(fileURL),format);
			writer.write(document);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("xml/placard.xml").forward(request, response);
	}

}
