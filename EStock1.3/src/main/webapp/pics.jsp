<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%  
String path=application.getRealPath(request.getRequestURI());
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
String name=request.getParameter("name");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<input type="hidden" id="meta" value=<%=request.getContextPath()%>/>
<title>ͼ��</title>
<link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<%-- <input type="hidden" name='code' id ='code' value='${code}'/> --%>
<input type="hidden" name='code' id ='code' value='<%=request.getParameter("code")%>'/> 
</head>
<body ng-controller="controller">
      <!-- ΪECharts׼��һ���߱���С����ߣ���Dom -->
     <a href="pics.jsp?name=img/world.jpg">�����ͼ</a>
     <a href="pics.jsp?name=img/coder1.png">����ԱȤ̸</a>
     <a href="pics.jsp?name=img/coder2.jpg">����Ա����֮·</a>
     <img src="<%=name%>"></img>
</body>
</html>