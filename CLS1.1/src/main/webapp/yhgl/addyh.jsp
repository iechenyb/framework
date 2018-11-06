<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%  
String path=application.getRealPath(request.getRequestURI());  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增用户</title>
<link rel="stylesheet" href="<%=basePath%>amazeui/css/amazeui.min.css">
<link rel="stylesheet" href="<%=basePath%>amazeui/css/app.css">
</head>
<body ng-controller="controller">
<form class="am-form" action='../yhgl/add.cs' method='post'>
<input type="hidden" id='path' name='path' value="<%=basePath%>"/>
<table  class="am-table am-table-bordered">
<tr>
	<td width="10%" align='right'>用户名:</td><td width="40%"><input type="text" class="" id=""  ng-model='user.username'  style='width:400px;float:left;'  placeholder="用户名"></td>
	<td width="10%" align='right'>电子邮件:</td><td  width="50%"><input type="text" style='width:400px' class="" id="menuName" ng-model='user.email' name="email" placeholder="电子邮件"/><font color='red' ></font></td>
</tr>
<tr>
	<td width="10%" align='right'>手机号码:</td>
	<td>
     <input type="text"  class="" ng-model='user.mobphone' name="mobphone"  placeholder="">
     <font color='red' ></font>
	</td>
	<td width="10%" align='right'>电话号码:</td>
	<td>
     <input type="text"  class="" ng-model='user.telphone' name="telphone" placeholder="xxx-xxxxxx"  style="width:400px;"/>
     <font color='red' ></font>
	</td>
</tr>   
<tr>
	<td width="10%" align='right'>年龄:</td>
	<td>
     <input type="text"  class="" ng-model='user.age' name="age" placeholder="">
     <font color='red' ></font>
	</td>
	<td width="10%" align='right'></td>
	<td>
     
	</td>
</tr> 
<tr>
	<td width="10%" align='right'>性别:</td>
	<td width="40%" align='left'> 
        <input type="radio"  value="1" ng-model="user.sex" name="sex"> 男
        <input type="radio" value='0' ng-model="user.sex" name="sex"> 女
      </td>
	<td width="10%" align='right'>学历:</td>
	<td  width="50%"> 
      <select id="level" ng-model="user.degree" name='degree' style='width:400px'>
        <option value="1">初中</option>
        <option value="2">高中</option>
        <option value="3">中专</option>
        <option value="4">本科</option>
        <option value="5">硕士</option>
        <option value="6">博士</option>
      </select>
    </td>
</tr> 
<tr>
	<td width="10%" align='right'>家庭住址:</td>
	<td colspan=3>
      <textarea class="" rows="5" name="address" ng-model='user.address' style='width:700'></textarea>
	</td>
</tr>   
<tr>
	<td colspan=4 align='center'>
	<button type="button" class="am-btn am-btn-primary" ng-click='save(user)'>提交</button>
	</td>
</tr>   
</table>
<table>
<tr align=center>
   <td align='center'>
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<td align='center'>
	    查询条件:<input ng-model="query">
         排序列:
	</td>
	<td><select ng-model="order" style="width:200px;" width='200px'>
                <option value="username" selected>用户名</option>
                <option value="age">年龄</option>
                <option value="sex" selected>性别</option>
                <option value="degree">学历</option>
                <option value="email" selected>电子邮件</option>
                <option value="mobphone">手机号码</option>
                <option value="telphone" selected>座机号码</option>
                <option value="address">家庭住址</option>
            </select>
     </td>
     <td> 排序方向：</td>
      <td>
      
       <select ng-model="direct" onchange="" style="width:200px;" width='200px'>
                <option value="true" selected="selected">升序</option>
                <option value="false">降序</option>
        </select>
        </td>
</tr>   
</table>

</form>
<table  class="am-table am-table-bordered imgtable">
<thead>
<tr align=center>
<th ng-click="order='username';direct=!direct"><center>用户名
<span ng-class="{false:'am-icon-caret-down',true:'am-icon-caret-up'}[direct==true]" calss="ng-hide am-icon-caret-down" ></span>
</center></th>
<th ng-click="order='age';direct=!direct"><center>年龄</center></th>
<th ng-click="order='sex';direct=!direct"><center>性别</center></th>
<th ng-click="order='degree';direct=!direct"><center>学历</center></th>
<th ng-click="order='email';direct=!direct"><center>电子邮件</center></th>
<th ng-click="order='mobphone';direct=!direct"><center>手机号码</center></th>
<th ng-click="order='telphone';direct=!direct"><center>座机号码</center></th>
<th ng-click="order='address';direct=!direct"><center>家庭住址</center></th>
<th ng-click="order='createTime';direct=!direct"><center>创建时间</center></th>
<th><center>操作</center></th>
</tr>
</thead>
<tbody>
<!-- ng-repeat="d in data|orderBy:col:desc" -->
<tr ng-repeat="vo in users | filter:query | orderBy:order:direct" align=center>
<td >{{vo.username}}</td>
<td>{{vo.age}}</td>
<td >{{vo.sex}}</td>
<td >{{vo.degree}}</td>
<td >{{vo.email}}</td>
<td >{{vo.mobphone}}</td>
<td >{{vo.telphone}}</td>
<td >{{vo.address}}</td>
<td >{{vo.createTime}}</td>
<td align='center'><img  class="click" ng-click="setUser(vo);" src="../images/t02.png">&nbsp;&nbsp;&nbsp; 
<img  class="click" ng-click="del(vo);" src="../images/t03.png">{{vo.id}}</td>
</tr>
</tbody>
</table>
<div class="am-modal am-modal-confirm" tabindex="-1" id="tip">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">提示</div>
    <div class="am-modal-bd">
             	确定要删除这条记录吗？
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>

<!-- 修改菜信息 -->
<div class="am-modal am-modal-no-btn" tabindex="-1" id="modify">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">修改菜单信息
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
    <div class="am-modal-bd">
      <form class="am-form" action='../yhgl/mod.cs' method='post'>
      <input type="hidden" id='path' name='path' value="<%=basePath%>"/>
<table  class="am-table am-table-bordered">
<tr>
	<td width="10%" align='right'>用户名:</td><td width="40%"><input type="text" class="" id=""  ng-model='user1.username'  style='width:400px;float:left;' placeholder="用户名"></td>
	<td width="10%" align='right'>电子邮件:</td><td  width="50%"><input type="text" style='width:400px' class="" id="menuName" ng-model='user1.email' name="email" placeholder="电子邮件"/><font color='red' ></font></td>
</tr>
<tr>
	<td width="10%" align='right'>手机号码:</td>
	<td>
     <input type="text"  class="" ng-model='user1.mobphone' name="mobphone" placeholder="http://ip:port/webName/?">
     <font color='red' ></font>
	</td>
	<td width="10%" align='right'>电话号码:</td>
	<td>
     <input type="text"  class="" ng-model='user1.telphone' name="telphone" placeholder="xxx-xxxxxx"  style="width:400px;"/>
     <font color='red' ></font>
	</td>
</tr>   
<tr>
	<td width="10%" align='right'>年龄:</td>
	<td>
     <input type="text"  class="" ng-model='user1.age' name="age" placeholder="">
     <font color='red' ></font>
	</td>
	<td width="10%" align='right'></td>
	<td>
     
	</td>
</tr> 
<tr>
	<td width="10%" align='right'>性别:</td>
	<td width="40%" align='left'> 
        <input type="radio"  value="1" ng-model="user1.sex" name="sex"> 男
        <input type="radio" value='0' ng-model="user1.sex" name="sex"> 女
     </td>
	<td width="10%" align='right'>学历:</td>
	<td  width="50%"> 
      <select id="level" ng-model="user1.degree" name='degree' style='width:400px'>
        <option value="1">初中</option>
        <option value="2">高中</option>
        <option value="3">中专</option>
        <option value="4">本科</option>
        <option value="5">硕士</option>
        <option value="6">博士</option>
      </select>
    </td>
</tr> 
<tr>
	<td width="10%" align='right'>家庭住址:</td>
	<td colspan=3>
      <textarea class="" rows="5" name="address" ng-model='user1.address' style='width:700'></textarea>
	</td>
</tr>   
<tr>
	<td colspan=4 align='center'>
	<button type="button" class="am-btn am-btn-primary" ng-click='submitMod(user1);'>提交</button>
	</td>
</tr>   
</table>
	</form>
    </div>
  </div>
</div>

</body>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=basePath%>amazeui/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="<%=basePath%>amazeui/js/amazeui.min.js"></script>
<%--  <script src="<%=basePath%>js/jquery.min.js"></script> --%>
 <%-- <script src="<%=basePath%>js/jquery.js"></script> --%>
 <script src="<%=basePath%>angular/angular-1.0.1.min.js"></script>
 <script src="<%=basePath%>amazeui/js/handlebars.min.js"></script>
<script src="<%=basePath%>amazeui/js/amazeui.widgets.helper.js"></script>
<script src="<%=basePath%>amazeui/js/amazeui.widgets.helper.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/json2.js"></script>
<script src="<%=basePath%>js/yhgl/yhgl.js"></script>
</html>
