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
  var obj = document.getElementById('infor');
  rDrag.init(obj);
  
});
</script>
<script type="text/javascript">
var rDrag = {
 o:null,
//��ӭ����վ����Ч�������ǵ���ַ��www.zzjs.net���ܺüǣ�zzվ����js����js��Ч����վ�ռ�����������js���룬���������������ء�
 init:function(o){
  o.onmousedown = this.start;
 },
 start:function(e){
  var o;
  e = rDrag.fixEvent(e);
               e.preventDefault && e.preventDefault();
               rDrag.o = o = this;
  o.x = e.clientX - rDrag.o.offsetLeft;
                o.y = e.clientY - rDrag.o.offsetTop;
  document.onmousemove = rDrag.move;
  document.onmouseup = rDrag.end;
 },
 move:function(e){
  e = rDrag.fixEvent(e);
  var oLeft,oTop;
  oLeft = e.clientX - rDrag.o.x;
  oTop = e.clientY - rDrag.o.y;
  rDrag.o.style.left = oLeft + 'px';
  rDrag.o.style.top = oTop + 'px';
 },
 end:function(e){
  e = rDrag.fixEvent(e);
  rDrag.o = document.onmousemove = document.onmouseup = null;
 },
    fixEvent: function(e){
        if (!e) {
            e = window.event;
            e.target = e.srcElement;
            e.layerX = e.offsetX;
            e.layerY = e.offsetY;
        }
        return e;
    }
}
</script>
</head>


<body>

	<div class="place">
    <span>λ�ã�</span>
    <ul class="placeul">
    <li><a href="#">��ҳ</a></li>
    <li><a href="#">ͼƬ�б�</a></li>
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
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">����ͼ</th>
    <th>����</th>
    <th>��Ŀ</th>
    <th>Ȩ��</th>
    <th>������</th>
    <th>�Ƿ����</th>
    <th>���</th>
    </tr>
    </thead>
    
    <tbody>
    
    <tr>
    <td class="imgtd"><img src="images/img11.png" /></td>
    <td><a href="#">�ǳ�����Ĺ����̨ģ�壬֧��HTML5</a><p>����ʱ�䣺2013-10-12 09:25:18</p></td>
    <td>��̨����<p>ID: 82122</p></td>
    <td>�������</td>
    <td>admin</td>
    <td>�����</td>
    <td>128</td>
    </tr>
    
    <tr>
    <td class="imgtd"><img src="images/img12.png" /></td>
    <td><a href="#">һ�׼�Լ��״ͼ��UI����</a><p>����ʱ�䣺2013-10-12 09:25:18</p></td>
    <td>ͼ�����<p>ID: 82122</p></td>
    <td>�������</td>
    <td>uimaker</td>
    <td><i>δ���</i></td>
    <td>235</td>
    </tr>
    
    <tr>
    <td class="imgtd"><img src="images/img13.png" /></td>
    <td><a href="#">��ɫ����������PSD����</a><p>����ʱ�䣺2013-10-12 09:25:18</p></td>
    <td>�������<p>ID: 82122</p></td>
    <td>�������</td>
    <td>admin</td>
    <td>�����</td>
    <td>100</td>
    </tr>
    
    <tr>
    <td class="imgtd"><img src="images/img14.png" /></td>
    <td><a href="#">uimaker.com����-123��switch����UI���</a><p>����ʱ�䣺2013-10-12 09:25:18</p></td>
    <td>ͼ�����<p>ID: 82122</p></td>
    <td>�������</td>
    <td>user</td>
    <td>�����</td>
    <td>96</td>
    </tr>
    
    <tr>
    <td class="imgtd"><img src="images/img15.png" /></td>
    <td><a href="#">����ͼ��PSDԴ�ļ�����</a><p>����ʱ�䣺2013-10-12 09:25:18</p></td>
    <td>�������<p>ID: 82122</p></td>
    <td>�������</td>
    <td>admin</td>
    <td>�����</td>
    <td>45</td>
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
    
    
    <div class="tip" id="infor">
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
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>
