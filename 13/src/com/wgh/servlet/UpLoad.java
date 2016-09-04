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
			this.uploadFile(request, response); // 上传文件
		}
	}
	public void uploadFile(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("GBK");
		HttpSession session = request.getSession();
		session.setAttribute("progressBar", 0);            //定义指定上传进度的Session变量
		String error = "";
		int maxSize = 50*1024*1024;                        //单个上传文件大小的上限
		DiskFileItemFactory factory = new DiskFileItemFactory();   //基于磁盘文件项目创建一个工厂对象
		ServletFileUpload upload = new ServletFileUpload(factory);  //创建一个新的文件上传对象
		try{
			List items = upload.parseRequest((RequestContext) request); //解析上传请求
			Iterator itr = items.iterator();                             //枚举方法
			while(itr.hasNext()){
				FileItem item = (FileItem) itr.next();
				if(!item.isFormField()){
					if(item.getName() != null&&!item.getName().equals("")){
						long upFileSize = item.getSize();
						String fileName = item.getName();
						if(upFileSize > maxSize){
							error = "您上传的文件太大,请选择不超过50MB的文件";
							break;
						}
						//此时文件暂存在服务器的内存中
						File tempFile = new File(fileName);   
						//获取根目录对应的真实物理路径
						File file = new File(request.getRealPath("/upload"),tempFile.getName());
						InputStream is = item.getInputStream();
						int buffer = 1024;
						int length = 0;
						byte[] b = new byte[buffer];
						double percent = 0;
						FileOutputStream fos = new FileOutputStream(file);
						while((length = is.read(b))!=-1){
							percent += length/(double)upFileSize * 100D;        //计算上传文件的百分比
							fos.write(b, 0, length);
							session.setAttribute("progressBar", Math.round(percent));
						}
						fos.close();
						Thread.sleep(1000);
					}else{
						error = "没有选择上传文件！";
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			error = "上传文件出现错误："+e.getMessage();
		}
		if(!"".equals(error)){
			request.setAttribute("error", error);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else{
			request.setAttribute("result", "文件上传成功");
			request.getRequestDispatcher("upFile_deal.jsp").forward(request, response);
		}
	}

}
