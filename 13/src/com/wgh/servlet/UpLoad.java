package com.wgh.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpLoad
 */
@WebServlet("/UpLoad")
public class UpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoad() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("uploadFile".equals(action)) {
			this.uploadFile(request, response); // �ϴ��ļ�
		}
	}
	public void uploadFile(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("GBK");
		HttpSession session = request.getSession();
		session.setAttribute("progressBar", 0);            //����ָ���ϴ����ȵ�Session����
		String error = "";
		int maxSize = 50*1024*1024;                        //�����ϴ��ļ���С������
		DiskFileItemFactory factory = new DiskFileItemFactory();   //���ڴ����ļ���Ŀ����һ����������
		ServletFileUpload upload = new ServletFileUpload(factory);  //����һ���µ��ļ��ϴ�����
		try{
			List items = upload.parseRequest((RequestContext) request); //�����ϴ�����
			Iterator itr = items.iterator();                             //ö�ٷ���
			while(itr.hasNext()){
				FileItem item = (FileItem) itr.next();
				if(!item.isFormField()){
					if(item.getName() != null&&!item.getName().equals("")){
						long upFileSize = item.getSize();
						String fileName = item.getName();
						if(upFileSize > maxSize){
							error = "���ϴ����ļ�̫��,��ѡ�񲻳���50MB���ļ�";
							break;
						}
						//��ʱ�ļ��ݴ��ڷ��������ڴ���
						File tempFile = new File(fileName);   
						//��ȡ��Ŀ¼��Ӧ����ʵ����·��
						File file = new File(request.getRealPath("/upload"),tempFile.getName());
						InputStream is = item.getInputStream();
						int buffer = 1024;
						int length = 0;
						byte[] b = new byte[buffer];
						double percent = 0;
						FileOutputStream fos = new FileOutputStream(file);
						while((length = is.read(b))!=-1){
							percent += length/(double)upFileSize * 100D;        //�����ϴ��ļ��İٷֱ�
							fos.write(b, 0, length);
							session.setAttribute("progressBar", Math.round(percent));
						}
						fos.close();
						Thread.sleep(1000);
					}else{
						error = "û��ѡ���ϴ��ļ���";
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			error = "�ϴ��ļ����ִ���"+e.getMessage();
		}
		if(!"".equals(error)){
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else{
			request.setAttribute("result", "�ļ��ϴ��ɹ�");
			request.getRequestDispatcher("upFile_deal.jsp").forward(request, response);
		}
	}

}
