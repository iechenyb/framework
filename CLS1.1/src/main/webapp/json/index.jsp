<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/json2.js"></script>
<title>push json para to server</title>
<script type="text/javascript">  
   function pushArr(){  
        var saveDataAry=[];  
        var data1={"name":"chenyb","password":"1111"};  
        var data2={"name":"iecyb","password":"6666"};  
        saveDataAry.push(data1);  
        saveDataAry.push(data2);         
        $.ajax({ 
            type:"POST", 
            url:"<%=basePath%>user/pushJsonList.cs", 
            dataType:"json",      
            contentType:"application/json",               
            data:JSON.stringify(saveDataAry), 
            success:function(data){ 
                  $('#infor').html("服务端返回的数据：<font size=5 color=red >"+JSON.stringify(data)+"</font>");                
            } 
         }); 
   }
   function pushObj(){  
       var data1={"name":"cyb","password":"986546","more":"value"};  
       delete data1["more"]; //移除多余的key 
       $.ajax({ 
           type:"POST", 
           url:"<%=basePath%>user/pushJsonObj.cs", 
           dataType:"json",      
           contentType:"application/json",               
           data:JSON.stringify(data1), 
           success:function(data){ 
        	   $('#infor').html("服务端返回的数据：<font size=5 color=green >"+JSON.stringify(data)+"</font>");                      
           } 
        }); 
  }
</script> 
</head>
<body>
传送的json对象的key值不能大于接收映射对象的属性值，一对一匹配才能看着正常的请求并处理，否则，看着是bad request！<br>
<button onclick='pushObj()'> 推送json对象到服务端</button>
<button onclick='pushArr()'> 推送json数组到服务端</button>
<div id='infor'></div>
</body>
</html>