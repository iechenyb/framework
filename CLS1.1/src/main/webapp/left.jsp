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
	//导航切换
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
	<div class="lefttop"><span></span>功能菜单</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>客户信息管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="index.jsp" target="rightFrame">首页模版</a><i></i></li>
        <li class="active"><cite></cite><a href="right.jsp" target="rightFrame">客户新增与修改</a><i></i></li>
        <li><cite></cite><a href="imgtable.jsp" target="rightFrame">客户变更</a><i></i></li>
        <li><cite></cite><a href="form.jsp" target="rightFrame">客户查询</a><i></i></li>
        <li><cite></cite><a href="imglist.jsp" target="rightFrame">信用评定</a><i></i></li>
        <li><cite></cite><a href="imglist1.jsp" target="rightFrame">行动记录</a><i></i></li>
        <li><cite></cite><a href="tools.jsp" target="rightFrame">客户诉求</a><i></i></li>
        <li><cite></cite><a href="filelist.jsp" target="rightFrame">客户订单</a><i></i></li>
        <li><cite></cite><a href="tab.jsp" target="rightFrame">客户统计</a><i></i></li>
        <li><cite></cite><a href="error.jsp" target="rightFrame">404页面</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>客户分类
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#">我的客户</a><i></i></li>
        <li><cite></cite><a href="#">团队客户</a><i></i></li>
        <li><cite></cite><a href="#">潜在客户</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>编辑器</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>日期管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>
    
    </dd>   
    
    </dl>
    
</body>
</html>
