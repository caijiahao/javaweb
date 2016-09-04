package com.lyq;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class CharacterWrapper implements Filter{
	public void init(FilterConfig config){}
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain)throws IOException,ServletException{
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//先去字串再比对
		
		String getContent=request.getParameter("te");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//使用DOM解析XML
		//首先获得DOM解析工厂，工厂的作用是用来创建DOM解析器
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		try {
			//获得DOM解析器
			DocumentBuilder builder=factory.newDocumentBuilder();
			//解析xml文件，获取Documnet对象根节点
			Document document=builder.parse(new File("D:\\eclipse\\javaWeb项目代码\\nighth\\WebContent\\WEB-INF\\Infor.xml"));
			//创建节点集
			NodeList list=document.getElementsByTagName("information");
			//使用for循环对输入的文字进行比对过滤
			for(int i=0;i<list.getLength();i++){
				//将节点集中的每一个节点转化为元素
				Element e=(Element)list.item(i);
				//得到孩子节点，并得到其值
				String content=e.getElementsByTagName("content").item(0).getFirstChild().getNodeValue();
				for(int j=0;j<getContent.length();j++){
					if(j==getContent.length()-2)
						break;
					if(content.equals(getContent.substring(j,j+2)))
						response.getWriter().print("**");
					else
						response.getWriter().print(getContent.substring(j,j+2));
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}finally{
			chain.doFilter(req, resp);
		}
	}
	public void destroy(){}

}

