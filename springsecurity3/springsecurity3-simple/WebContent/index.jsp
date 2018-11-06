<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <sec:authentication property ="principal" var ="authentication"/>
      <a href="<%=basePath%>admin/admin.jsp">管理员页面</a><br>
      <a href="<%=basePath%>user/user.jsp">普通用户页面</a><br>
      <a href="<%=basePath%>exit.html">退出系统</a><br>
      <sec:authorize ifAllGranted ="ROLE_ADMIN">管理员页面 </sec:authorize>
      <sec:authorize ifAllGranted ="ROLE_USER">普通用户页面 </sec:authorize>
      <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="admin.jsp">admin page</a>
      </sec:authorize>
   <!-- 需要拥有所有的权限 -->
   <sec:authorize ifAllGranted="ROLE_ADMIN">
      <a href="admin.jsp">admin</a>
   </sec:authorize>
   <!-- 只需拥有其中任意一个权限 -->
   <sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">hello</sec:authorize>
   <!-- 不允许拥有指定的任意权限 -->
   <sec:authorize ifNotGranted="ROLE_ADMIN">
      <a href="user.jsp">user</a>
   </sec:authorize>
              用户名：${authentication.username } <br/> 
              <hr>
    <!-- 拥有访问指定url的权限才显示其中包含的内容 -->
   <sec:authorize url="/admin/admin.jsp">
      <a href="/admin/admin.jsp">admin</a>
   </sec:authorize>
   <sec:authorize url="/user/user.jsp">
      <a href="/user/user.jsp">user</a>
   </sec:authorize>
   <sec:authorize url="/other/admin.jsp">
      <a href="sdsd.jsp">other</a>
   </sec:authorize>
   <hr>
    <sec:authorize access="isFullyAuthenticated()" var="isFullyAuthenticated">
      	只有通过登录界面进行登录的用户才能看到1。<br/>
   </sec:authorize>
   		上述权限的鉴定结果是：${isFullyAuthenticated }<br/>
   <%if((Boolean)pageContext.getAttribute("isFullyAuthenticated")) {%>
      	只有通过登录界面进行登录的用户才能看到2。
   <%}%>
   <sec:authentication property="principal.username"/>
   <sec:authentication property="name"/>
   <!-- 将获取到的用户名以属性名username存放在session中 -->
   <sec:authentication property="principal.username" scope="session" var="username"/>
   ${username }
  </body>
</html>
