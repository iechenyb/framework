<%@ page language="java" pageEncoding="UTF-8"%>

<div style="color:red; font-size:22px;">${message_login}</div>
${pageContext.request.contextPath}
<form action="${pageContext.request.contextPath}/mydemo/login" method="POST">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    验证：<input type="text" name="captcha"/>&nbsp;
         <img style="cursor:pointer;" src="${pageContext.request.contextPath}/captcha.jsp" onClick="this.src='${pageContext.request.contextPath}/captcha.jsp?time'+Math.random();"/><br/>
         <input type="submit"/>
</form>