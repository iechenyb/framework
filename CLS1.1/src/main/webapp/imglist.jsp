<%@ page language="java" contentType="text/html; charset=gbk"    pageEncoding="gbk"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�ޱ����ĵ�</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//�����л�
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
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
    <li><a href="#">ģ�����</a></li>
    <li><a href="#">ͼƬ</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>���</li>
        <li class="click"><span><img src="images/t02.png" /></span>�޸�</li>
        <li><span><img src="images/t03.png" /></span>ɾ��</li>
        <li><span><img src="images/t04.png" /></span>ͳ��</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>����</li>
        </ul>
    
    </div>
    
    
    <ul class="imglist">
    
    <li class="selected">
    <span><img src="images/img01.png" /></span>
    <h2><a href="#">��������������</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    <li>
    <span><img src="images/img02.png" /></span>
    <h2><a href="#">������ʽ�ز�����</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    <li>
    <span><img src="images/img03.png" /></span>
    <h2><a href="#">����С���ڽ�����ƽ̳�</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    <li>
    <span><img src="images/img04.png" /></span>
    <h2><a href="#">��ëͼ����ƽ̳�</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    <li>
    <span><img src="images/img05.png" /></span>
    <h2><a href="#">���������ʽ���</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    <li>
    <span><img src="images/img06.png" /></span>
    <h2><a href="#">��ëͼ����ƽ̳�</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    <li>
    <span><img src="images/img07.png" /></span>
    <h2><a href="#">����С���ڽ�����ƽ̳�</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    <li>
    <span><img src="images/img08.png" /></span>
    <h2><a href="#">����С���ڽ�����ƽ̳�</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    <li>
    <span><img src="images/img09.png" /></span>
    <h2><a href="#">����С���ڽ�����ƽ̳�</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    <li>
    <span><img src="images/img10.png" /></span>
    <h2><a href="#">��������������</a></h2>
    <p><a href="#">�༭</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">ɾ��</a></p>
    </li>
    
    </ul>
    
    
   
    <div class="pagin">
    	<div class="message">��<i class="blue">1256</i>����¼����ǰ��ʾ��&nbsp;<i class="blue">2&nbsp;</i>ҳ</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>��ʾ��Ϣ</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>�Ƿ�ȷ�϶���Ϣ���޸� ��</p>
        <cite>���������ȷ����ť ���������ȡ����</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="ȷ��" />&nbsp;
        <input name="" type="button"  class="cancel" value="ȡ��" />
        </div>
    
    </div>
    
    
    
    
    </div>
    

</body>

</html>
