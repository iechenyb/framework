<%@ page language="java" contentType="text/html; charset=gbk"    pageEncoding="gbk"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script language="javaScript" src="<%=basePath%>js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//�����л�
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>���ܲ˵�</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>�ͻ���Ϣ����
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="index.jsp" target="rightFrame">��ҳģ��</a><i></i></li>
        <li class="active"><cite></cite><a href="right.jsp" target="rightFrame">�ͻ��������޸�</a><i></i></li>
        <li><cite></cite><a href="imgtable.jsp" target="rightFrame">�ͻ����</a><i></i></li>
        <li><cite></cite><a href="form.jsp" target="rightFrame">�ͻ���ѯ</a><i></i></li>
        <li><cite></cite><a href="imglist.jsp" target="rightFrame">��������</a><i></i></li>
        <li><cite></cite><a href="imglist1.jsp" target="rightFrame">�ж���¼</a><i></i></li>
        <li><cite></cite><a href="tools.jsp" target="rightFrame">�ͻ�����</a><i></i></li>
        <li><cite></cite><a href="filelist.jsp" target="rightFrame">�ͻ�����</a><i></i></li>
        <li><cite></cite><a href="tab.jsp" target="rightFrame">�ͻ�ͳ��</a><i></i></li>
        <li><cite></cite><a href="error.jsp" target="rightFrame">404ҳ��</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>�ͻ�����
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#">�ҵĿͻ�</a><i></i></li>
        <li><cite></cite><a href="#">�Ŷӿͻ�</a><i></i></li>
        <li><cite></cite><a href="#">Ǳ�ڿͻ�</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>�༭��</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">�Զ���</a><i></i></li>
        <li><cite></cite><a href="#">��������</a><i></i></li>
        <li><cite></cite><a href="#">��Ϣ�б�</a><i></i></li>
        <li><cite></cite><a href="#">����</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>���ڹ���</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">�Զ���</a><i></i></li>
        <li><cite></cite><a href="#">��������</a><i></i></li>
        <li><cite></cite><a href="#">��Ϣ�б�</a><i></i></li>
        <li><cite></cite><a href="#">����</a><i></i></li>
    </ul>
    
    </dd>   
    
    </dl>
    
</body>
</html>
