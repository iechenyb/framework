<%@ page language="java" contentType="text/html; charset=gbk"    pageEncoding="gbk"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�ޱ����ĵ�</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>λ�ã�</span>
    <ul class="placeul">
    <li><a href="#">��ҳ</a></li>
    <li><a href="#">ϵͳ����</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">����֪ͨ</a></li> 
    <li><a href="#tab2">�Զ���</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi��<b>admin</b>����ӭ��������Ϣ�������ܣ�</div>
    
    <ul class="forminfo">
    <li><label>��Ƹ��ҵ<b>*</b></label><input name="" type="text" class="dfinput" value="����д��λ����"  style="width:518px;"/></li>
   
    <li><label>ְλ����<b>*</b></label>  
    

    <div class="vocation">
    <select class="select1">
    <option>UI���ʦ</option>
    <option>�������ʦ</option>
    <option>ǰ�����ʦ</option>
    <option>��ҳ���ʦ</option>
    <option>Flash����</option>
    <option>�Ӿ����ʦ</option>
    <option>�廭���ʦ</option>
    <option>����</option>
    <option>����</option>
    </select>
    </div>
    
    </li>
    
    <li><label>н�ʴ���<b>*</b></label>
    <div class="vocation">
    <select class="select1">
    <option>3000-5000</option>
    <option>5000-8000</option>
    <option>8000-10000</option>
    <option>10000-15000</option>
    </select>
    </div>
    
    
    
    </li>
    <li><label>�����ص�<b>*</b></label>
    
    <div class="usercity">
    
    <div class="cityleft">
    <select class="select2">
    <option>����</option>
    <option>����</option>
    <option>�㶫</option>
    <option>����</option>
    <option>����</option>
    </select>
    </div>
    
    <div class="cityright">
    <select class="select2">
    <option>�Ͼ�</option>
    <option>����</option>
    <option>�γ�</option>
    <option>����</option>
    <option>���Ƹ�</option>
    </select>
    </div>
    
    </div>
    
    
    
    </li>
    <li><label>֪ͨ����<b>*</b></label>
    

    <textarea id="content7" name="content" style="width:700px;height:250px;visibility:hidden;"></textarea>
    
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="���Ϸ���"/></li>
    </ul>
    
    </div> 
    
    
  	<div id="tab2" class="tabson">
    
    
    <ul class="seachform">
    
    <li><label>�ۺϲ�ѯ</label><input name="" type="text" class="scinput" /></li>
    <li><label>ָ��</label>  
    <div class="vocation">
    <select class="select3">
    <option>ȫ��</option>
    <option>����</option>
    </select>
    </div>
    </li>
    
    <li><label>�ص�ͻ�</label>  
    <div class="vocation">
    <select class="select3">
    <option>ȫ��</option>
    <option>����</option>
    </select>
    </div>
    </li>
    
    <li><label>�ͻ�״̬</label>  
    <div class="vocation">
    <select class="select3">
    <option>ȫ��</option>
    <option>����</option>
    </select>
    </div>
    </li>
    
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="��ѯ"/></li>
    
    </ul>
    
    
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
        <td>20130907</td>
        <td>����19��Сѧ���ж�����Ѫ�����ܱ߲�����ҵ��ͣ</td>
        <td>uimaker</td>
        <td>ɽ������</td>
        <td>2013-09-08 14:02</td>
        <td>δ���</td>
        <td><a href="#" class="tablelink">�鿴</a>     <a href="#" class="tablelink">ɾ��</a></td>
        </tr>
    
        </tbody>
    </table>
    
   
  
    
    </div>  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>


</body>

</html>