<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%
	String basePath = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath() + "/";
	Object username = request.getSession().getAttribute("username");
%>
<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�ޱ����ĵ�</title>
<style>
    .dh-footer {
        width: 100%;
        height: 100%;
        margin:0.2rem;
        border:0px red solid;
    }

    .dh-footer p {
        text-align: center;
        margin: 0;
        padding: .1rem;
        font-family : ΢���ź�,����;
		font-size : 1em;
		color : '';
    }

	.dh-footer p a:hover {
        color: #f08080;
    }
    .dh-footer a {
        color: white;
        font-size : 1.5rem;
    }
</style>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>amazeui/css/amazeui.min.css">
</head>
<body style="background: url(images/topbg.gif) repeat-x;overflow: hidden;">
	<div class="am-g">
	<div class="dh-footer">
       <p><a>�Ϻ�������·686�Ŷ����������� 4008-889-889</a> &nbsp;&nbsp;
        <a href="http://www.miibeian.gov.cn/" target="_blank">��ICP��14006107��</a>&nbsp;&nbsp;
        <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011202001150" target="_blank">����������
            31011202001150��</a><br>
         <a>�������ӣ�</a><a href="http://localhost/" target="_blank">�����ڻ���վ�°�</a>
       </p>
	</div>
	</div>
</body>
</html>
