
<%@ page language="java" contentType="text/html; charset=gbk"    pageEncoding="gbk"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�ޱ����ĵ�</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script language="javascript">
$(function(){	
	//�����л�
	$(".disklist li").click(function(){
		$(".disklist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>

</head>


<body>

	<div class="place">
    <span>λ�ã�</span>
    <ul class="placeul">
    <li><a href="#">��ҳ</a></li>
    <li><a href="#">�ļ�����</a></li>
    </ul>
    </div>
    
    <div class="comtitle">
    <span><img src="images/clist.png" /></span>
    <h2>����(5)</h2>
    <div class="rline"></div>
    </div>
    
    
    <ul class="disklist">
    
    <li>
    <a href="filelist.html">
    <div class="dleft1"></div>    
    <div class="dright">
    <h2>��Ϣ�ĵ�(25)</h2>
    <div class="dinfo"><span style="width:100px;"></span></div>
    <p>34 MB �ռ�,�� 253 ���ļ�</p>    
    </div>
    </a>
    </li>
    
    <li>
    <div class="dleft"></div>    
    <div class="dright">
    <h2>ͼƬ(30)</h2>
    <div class="dinfo"><span style="width:50px;"></span></div>
    <p>120 MB �ռ�,�� 5100 ���ļ�</p>    
    </div>
    </li>
    
    <li>
    <div class="dleft"></div>    
    <div class="dright">
    <h2>�������(43)</h2>
    <div class="dinfo"><span style="width:38px;"></span></div>
    <p>500 MB �ռ�,�� 12 ���ļ�</p>    
    </div>
    </li>
    
    <li>
    <div class="dleft"></div>    
    <div class="dright">
    <h2>ϵͳ����(25)</h2>
    <div class="dinfo"><span style="width:60px;"></span></div>
    <p>125 MB �ռ�,�� 3585 ���ļ�</p>    
    </div>
    </li>
    
    <li class="selected">
    <div class="dleft"></div>    
    <div class="dright">
    <h2>uimaker(89)</h2>
    <div class="dinfo"><span style="width:40px;"></span></div>
    <p>10 MB �ռ�,�� 25 ���ļ�</p>    
    </div>
    </li>
    
    <li>
    <div class="dleft"></div>    
    <div class="dright">
    <h2>����(10)</h2>
    <div class="dinfo"><span style="width:15px;"></span></div>
    <p>2 MB �ռ�,�� 53 ���ļ�</p>    
    </div>
    </li>
    
    
    </ul>
    
    
    
    <div class="comtitle">
    <span><img src="images/clist.png" /></span>
    <h2>����(1)</h2>
    <div class="rline"></div>
    </div>
    
    
    <ul class="disklist">
    <li>
    <div class="dleft2"></div>    
    <div class="dright">
    <h3>�����Ϣ����</h3>
    <p>�ļ���</p>    
    </div>
    </li>  
    </ul>

</body>

</html>
