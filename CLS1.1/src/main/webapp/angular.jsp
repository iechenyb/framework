<%@ page language="java" contentType="text/html; charset=gbk"    pageEncoding="gbk"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<html  ng-app="app">
  <head>
      <link rel="stylesheet" href="<%=basePath%>amazeui/css/amazeui.min.css">
      <link rel="stylesheet" href="<%=basePath%>amazeui/css/app.css">
  </head>
  <body ng-controller="controller">
    Your name: <input type="text" ng-model="yourname" placeholder="World" value="chenyb">
    <hr>
   <ul>
   
    <li ng-repeat="phone in phones">
      <font size=2 color=red>{{phone.name}}</font>
    <p><font size=2 color=red>{{phone.snippet}} </font></p>
    </li>
    <select style="height=100px;width=100px">
     <option value=1> str1</option>
     <option value=2> str2</option>
     <option value=3> str3</option>
     <option value=4> str4</option>
     <option value=5> str5</option>
    </select>
   
  </ul>model value = {{total}}<p ng-model="total"></p>
  <button ng-click="testOnclick(23);">点我model！</button>
  <button ng-click="count=count+1">点我express！</button>
 <p>express = {{ count }}</p>

    Hello <font size=5 color=red>{{yourname || 'World'}}!</font><br>
    the param from angular.js  is  <font size=5 color=red>{{test}}</font><br>
    <input type="text" id="test" name="test" value="haha" placeholder="World"></br>
 <script src="<%=basePath%>js/jquery.min.js"></script>
 <script src="<%=basePath%>js/jquery.js"></script>
 <script src="<%=basePath%>angular/angular-1.0.1.min.js"></script>
      <script src="<%=basePath%>js/my/angular.js"></script>
  </body>
</html>