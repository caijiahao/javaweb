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
		//��ȥ�ִ��ٱȶ�
		
		String getContent=request.getParameter("te");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//ʹ��DOM����XML
		//���Ȼ��DOM������������������������������DOM������
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		try {
			//���DOM������
			DocumentBuilder builder=factory.newDocumentBuilder();
			//����xml�ļ�����ȡDocumnet������ڵ�
			Document document=builder.parse(new File("D:\\eclipse\\javaWeb��Ŀ����\\nighth\\WebContent\\WEB-INF\\Infor.xml"));
			//�����ڵ㼯
			NodeList list=document.getElementsByTagName("information");
			//ʹ��forѭ������������ֽ��бȶԹ���
			for(int i=0;i<list.getLength();i++){
				//���ڵ㼯�е�ÿһ���ڵ�ת��ΪԪ��
				Element e=(Element)list.item(i);
				//�õ����ӽڵ㣬���õ���ֵ
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

