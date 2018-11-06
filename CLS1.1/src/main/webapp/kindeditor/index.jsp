<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>study</title>
</head>
<body>
<a href="<%=basePath%>kindeditor/jsp/demo.jsp" target='_blank'>demo</a><br>
<a href="<%=basePath%>kindeditor/jsp/demo1.jsp" target='_blank'>demo1</a><br>
<a href="<%=basePath%>kindeditor/jsp/file_manager_json.jsp" target='_blank'>fil_manager_json</a><br>
<a href="<%=basePath%>kindeditor/jsp/upload_json.jsp" target='_blank'>upload_json</a>
</body>
</html>