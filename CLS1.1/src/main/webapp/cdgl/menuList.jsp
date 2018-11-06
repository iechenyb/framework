<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%  
String path=application.getRealPath(request.getRequestURI());  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="<%=basePath%>amazeui/css/amazeui.min.css">
<link rel="stylesheet" href="<%=basePath%>amazeui/css/app.css">
<input type="hidden" id='path' name='path' value="<%=basePath%>"/>
<input type="hidden" id='pid' name='pid' value="<%=request.getParameter("pid")%>"/>

</head>
<body ng-controller="controller">
<table  class="am-table am-table-bordered imgtable">
<thead>
<tr align=center>
<th>名称</th><th>标识</th><th>路径</th><th>URL</th><th>级别</th><th>顺序</th><th>是否叶子节点</th><th>备注</th><th>创建时间</th><th>操作</th>
</tr>
</thead>
<tbody>
<tr ng-repeat="menu in menus">
<td>{{menu.MENUNAME}}</td>
<td>{{menu.menubs}}</td>
<td>{{menu.path}}</td>
<td>{{menu.url}}</td>
<td>{{menu.level}}</td>
<td>{{menu.rank}}</td>
<td>{{menu.isleaf}}</td>
<td>{{menu.bz}}</td>
<td>{{menu.createtime}}</td>
<td align='center'><img  class="click" src="../images/t02.png">&nbsp;&nbsp;&nbsp; <img  class="click" ng-click="del(menu);" src="../images/t03.png"></td>
</tr>
</tbody>
</table>
<div class="am-modal am-modal-confirm" tabindex="-1" id="tip">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">Amaze UI</div>
    <div class="am-modal-bd">
             	你，确定要删除这条记录吗？
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
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
<script src="<%=basePath%>js/cdgl/subMenuList.js"></script>
</html>
