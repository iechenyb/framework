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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>amazeui/css/amazeui.min.css">
<link rel="stylesheet" href="<%=basePath%>cdn/amazeui.tree.css">
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//���������л�
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">  
    //��ȡϵͳʱ�䣬��ʱ����ָ����ʽ��ʾ��ҳ�档  
    function systemTime()  
    {  
        //��ȡϵͳʱ�䡣  
        var dateTime=new Date();  
        var hh=dateTime.getHours();  
        var mm=dateTime.getMinutes();  
        var ss=dateTime.getSeconds();  
          
        //����ʱ����һλ���֣�������ǰ��0��  
        mm = extra(mm);  
        ss = extra(ss);  
          
        //��ʱ����ʾ��IDΪtime��λ�ã�ʱ���ʽ���磺19:18:02  
        document.getElementById("time").innerHTML=hh+":"+mm+":"+ss;  
          
        //ÿ��1000msִ�з���systemTime()��  
        setTimeout("systemTime()",1000);  
    }  
      
    //��λ������  
    function extra(x)  
    {  
        //�����������С��10������ǰ��һλ0��  
        if(x < 10)  
        {  
            return "0" + x;  
        }  
        else  
        {  
            return x;  
        }  
    }  
</script>

</head>

<body style="background: url(images/topbg.gif) repeat-x;background-size:cover;overflow: hidden;">
<div class="am-g">
	<div class="topleft">
		<!-- <a href="index.jsp" target="_parent"></a> -->
		<!-- <img src="images/logo.png" title="ϵͳ��ҳ" />  -->
		��̨����ϵͳ
	</div>
	<div class="topright">
	<div>
		<ul>
			<li><span><img src="images/help.png" title="����"
					class="helpimg" /></span><a href="#">����</a></li>
			<li><a href="#">����</a></li>
			<li><a href="#" onclick='top.location.replace("user/exit.do")'>�˳�</a></li>
		</ul>
		</div>
		<div class="user">
			<span><%=username%></span>
		</div>
	</div>
<div class="am-g">
<script type="text/javascript">
  function exit(obj){
	 obj.href= '<%=basePath%>user/exit.do';
			obj.target = window.top;
			obj.click();
  }
</script>
</body>
</html>
