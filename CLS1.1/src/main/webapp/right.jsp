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

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>λ�ã�</span>
    <ul class="placeul">
    <li><a href="#">��ҳ</a></li>
    <li><a href="#">���ݱ�</a></li>
    <li><a href="#">��������</a></li>
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
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>���<i class="sort"><img src="images/px.gif" /></i></th>
        <th>����</th>
        <th>�û�</th>
        <th>����</th>
        <th>����ʱ��</th>
        <th>�Ƿ����</th>
        <th>����</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>20130908</td>
        <td>����ƽĻ�ţ���Ӣ���������ּ�Ѫ �˻���û��˼</td>
        <td>admin</td>
        <td>�����Ͼ�</td>
        <td>2013-09-09 15:05</td>
        <td>�����</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink"> ɾ��</a></td>
        </tr> 
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>20130907</td>
        <td>����19��Сѧ���ж�����Ѫ�����ܱ߲�����ҵ��ͣ</td>
        <td>uimaker</td>
        <td>ɽ������</td>
        <td>2013-09-08 14:02</td>
        <td>δ���</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink">ɾ��</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>20130906</td>
        <td>���Ժ:��������ٽ���ũ�徭�ýṹ�����ת��</td>
        <td>user</td>
        <td>��������</td>
        <td>2013-09-07 13:16</td>
        <td>δ���</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink">ɾ��</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>20130905</td>
        <td>����&quot;�ֳ�Υ�潨��լ&quot;���ֳ�����</td>
        <td>admin</td>
        <td>������</td>
        <td>2013-09-06 10:36</td>
        <td>�����</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink">ɾ��</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>20130904</td>
        <td>�й�2020�������������������</td>
        <td>uimaker</td>
        <td>�����Ͼ�</td>
        <td>2013-09-05 13:25</td>
        <td>�����</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink">ɾ��</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>20130903</td>
        <td>���ڵ���������˿���բ�� 3�˱��������</td>
        <td>user</td>
        <td>�㶫����</td>
        <td>2013-09-04 12:00</td>
        <td>�����</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink">ɾ��</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>20130902</td>
        <td>33�εر����� ���񲻸��µ�����(ͼ)</td>
        <td>admin</td>
        <td>���ϳ�ɳ</td>
        <td>2013-09-03 00:05</td>
        <td>δ���</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink">ɾ��</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>20130901</td>
        <td>ҽ����ϵ��ҽ������ĸﲻ���ױ��ڹ�</td>
        <td>admin</td>
        <td>�����Ͼ�</td>
        <td>2013-09-02 15:05</td>
        <td>δ���</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink">ɾ��</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>20130900</td>
        <td>ɽ�����𹫳������꾰�㽫�Զ�����ϵͳ����</td>
        <td>uimaker</td>
        <td>ɽ������</td>
        <td>2013-09-01 10:26</td>
        <td>�����</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink">ɾ��</a></td>
        </tr>        
        </tbody>
    </table>
    
   
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
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
