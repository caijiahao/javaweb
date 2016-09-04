<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
        <%@ page language="java" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>分页显示信息</title>
</head>
<body>
<%
String driverName="com.mysql.jdbc.Driver";
String userName="root";
String userPasswd="13713393809";
String dbName="test";
String url ="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
Class.forName(driverName).newInstance();
Connection connection=DriverManager.getConnection(url);
Statement statement = connection.createStatement();
int PageSize = 8;
int StartRow = 0;
int PageNo = 0;
int CounterStart = 0;
int CounterEnd = 0;
int RecordCount = 0;
int MaxPage = 0;
int PrevStart = 0;
int NextPage = 0;
int LastRec = 0;
int LastStartRecord = 0;

if(request.getParameter("PageNo")==null){
	if(StartRow == 0){
		PageNo = StartRow +1;
	}
	}else{
		PageNo = Integer.parseInt(request.getParameter("PageNo"));
		StartRow = (PageNo - 1)*PageSize;
	}
	if(PageNo % PageSize == 0){
		CounterStart = PageNo - (PageSize - 1);
	}else{
		CounterStart = PageNo -(PageNo % PageSize) + 1;
	}
CounterEnd = CounterStart + (PageSize -1);
%>

<%
ResultSet rs = statement.executeQuery("select count(*) from friends");
rs.next();
RecordCount = rs.getInt(1);
rs = statement.executeQuery("select id,name,tel from friends order by id desc LIMIT "+StartRow+","+PageSize);
MaxPage = RecordCount % PageSize;
if(RecordCount % PageSize ==0){
	MaxPage = RecordCount/PageSize;
}else{
	MaxPage  = RecordCount/PageSize + 1;
}
%>
<table width="450" border="1">
<tr>
<th>编号</th>
<th>姓名</th>
<th>电话</th>
</tr>
<%
while(rs.next()){
%>
<tr>
<td><%=rs.getInt("id") %></td>
<td><%=rs.getString("id") %></td>
<td><%=rs.getString("id") %></td>
</tr>
<%
}
%>
<%
out.print("<font size=4>");
if(PageNo!=1){
	PrevStart = PageNo-1;
	out.print("<a herf=db4.jsp?PageNo=1>第一页</a>:");
	out.print("<a href = db4.jsp?PageNo="+PrevStart+">前一页</a>");
}
out.print("[");
for(int c=CounterStart;c<=CounterEnd;c++){
	if(c<MaxPage){
		if(c==PageNo){
			if(c%PageSize==0){
				out.print(c);
			}else{
				out.print(c+",");
			}
		}else if(c%PageSize==0){
			out.print("<a href=db4.jsp?PageNo="+c+">"+c+"</a>");
		}else{
			out.print("<a href=db4.jsp?PageNo="+c+">"+c+"</a>,");
		}
	}else{
		if(PageNo == MaxPage){
			out.print(c);
			break;
		}else{
			out.print("<a href=db4.jsp?PageNo="+c+">"+c+"</a>");
		}
	}
}
out.print("]");
if(PageNo < MaxPage){
	NextPage = PageNo + 1;
	out.print("<a href=db4.jsp?PageNo="+NextPage+">下一页</a>");
}

if(PageNo < MaxPage){
	LastRec = RecordCount %PageSize;
	if(LastRec == 0){
		LastStartRecord = RecordCount - PageSize;
	}else{
		LastStartRecord = RecordCount - LastRec;
	}
	out.print(":");
	out.print("<a href=db4.jsp?PageNo="+MaxPage+">最后一页</a>");
}
out.print("</font>");
%>
<%
rs.close();
statement.close();
connection.close();
%>
</table>
</body>
</html>