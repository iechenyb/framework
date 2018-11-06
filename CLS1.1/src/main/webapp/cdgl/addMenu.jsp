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
</head>
<body ng-controller="controller">
<!-- <div class="am-tabs" data-am-tabs="{noSwipe: 1}" id="doc-tab-demo-1">
  <ul class="am-tabs-nav am-nav am-nav-tabs">
    <li class="am-active"><a href="javascript: void(0)">新增菜单</a></li>
    <li><a href="javascript: void(0)">子菜单列表</a></li>
  </ul> -->
id=<%=request.getParameter("id")%>
bs=<%=request.getParameter("bs")%>
<form class="am-form" action='<%=basePath%>cdgl/add.cs' method='post'>
<input type="hidden" id='id' name='id' value="<%=request.getParameter("id")%>"/>
<input type="hidden" value="<%=request.getParameter("id")%>" name="parentId" id='parentId'/>
<input type="hidden" value="<%=request.getParameter("bs")%>" name="parentBs" id='parentBs'/>
<table  class="am-table am-table-bordered">
<tr>
	<td width="10%" align='right'>上级菜单:</td><td width="40%"><input type="text" class="" id=""  ng-model='parentName'  style='width:400px;float:left;' disabled placeholder="上级菜单名称，不可编辑"></td>
	<td width="10%" align='right'>菜单名称:</td><td  width="50%"><input type="text" style='width:400px' class="" id="menuName" name="menuName" placeholder="菜单名称"/><font color='red' ></font></td>
</tr>
<tr>
	<td width="10%" align='right'>菜单路径:</td>
	<td>
     <input type="text"  class="" id='url' name="url" placeholder="http://ip:port/webName/?">
     <font color='red' ></font>
	</td>
	<td width="10%" align='right'>菜单标志:</td>
	<td>
     <input type="text"  class="" id='menubs' name="menuBs" placeholder="菜单首字母"  style="width:400px;"/>
     <font color='red' ></font>
	</td>
</tr>   
<tr>
	<td width="10%" align='right'>是否叶子:</td><td width="40%"> 
	  <label class="am-radio-inline">
        <input type="radio"  value="1" name="isLeaf"> 是
      </label>
      <label class="am-radio-inline">
        <input type="radio" value='0' name="isLeaf"> 否
      </label><font color='red' size=1>&nbsp;&nbsp;设置为叶子节点则不能再添加子节点！</font></td>
	<td width="10%" align='right'>菜单级别:</td>
	<td  width="50%"> 
      <select id="level" name='level' style='width:400px'>
        <option value="1">一级</option>
        <option value="2">二级</option>
        <option value="3">三级</option>
      </select>
    </td>
</tr> 
<tr>
	<td width="10%" align='right'>备注:</td>
	<td colspan=3>
      <textarea class="" rows="5" name="bz" style='width:700'></textarea>
	</td>
</tr>   
<tr>
	<td colspan=4 align='center'>
	<button type="submit" class="am-btn am-btn-primary" ng-click='reshTree(opener);'>提交</button>
	</td>
</tr>   
</table>
</form>
 <%--  <div class="am-tabs-bd">
    <div class="am-tab-panel am-active">
      <jsp:include page="menu.jsp">
        <jsp:param  name="pid" value='<%=request.getParameter("pid")%>' />
      </jsp:include>
    </div> --%>
   <%--  <div class="am-tab-panel">
     <jsp:include page="menuList.jsp">
       <jsp:param  name="pid" value='<%=request.getParameter("pid")%>' />
     </jsp:include>
    </div> --%>
    <table  class="am-table am-table-bordered imgtable">
<thead>
<tr align=center>
<th><center>子菜单名称</center></th><th><center>标识</center></th><th><center>路径</center></th><th><center>URL</center></th>
<th><center>级别</center></th><th><center>顺序</center></th><th><center>是否叶子节点</center></th><th><center>备注</center></th><th><center>创建时间</center></th><th><center>操作</center></th>
</tr>
</thead>
<tbody>
<tr ng-repeat="vo in menus" align=center>
<td>{{vo.menuname}}</td>
<td>{{vo.menubs}}</td>
<td>{{vo.path}}</td>
<td>{{vo.url}}</td>
<td>{{vo.level}}级菜单</td>
<td>{{vo.rank}}</td>
<td>{{vo.isleaf}}</td>
<td>{{vo.bz}}</td>
<td>{{vo.createtime}}</td>
<td align='center'><img  class="click" ng-click="modify(vo);" src="../images/t02.png">&nbsp;&nbsp;&nbsp; 
<img  class="click" ng-click="del(vo);" src="../images/t03.png"></td>
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
      id=<%=request.getParameter("id")%>
      bs=<%=request.getParameter("bs")%>
      <form class="am-form" action='<%=basePath%>cdgl/mod.cs' method='post'>
      <input type="hidden" id='id' name='id' value="<%=request.getParameter("id")%>"/>
      <input type="hidden" id='bs' name='bs' value="<%=request.getParameter("bs")%>"/>
      <input type=hidden id='menuId' ng-model='menu.menuid' name='menuId' value='{{menu.menuid}}'/>
      <input type=hidden id='rank' ng-model='menu.rank' name='rank' value='{{menu.rank}}'/>
      <input type=hidden id='parentBs' ng-model='menu.parentbs' name='parentBs' value='<%=request.getParameter("bs")%>'/>
      <input type=hidden id='parentId' ng-model='menu.parentid' name='parentId' value='<%=request.getParameter("id")%>'/>
      <input type=hidden id='level' ng-model='menu.level' name='level' value='{{menu.level}}'/>
     <table  class="am-table am-table-bordered">
		<tr>
			<td width="10%" align='right'>上级菜单:</td><td width="40%"><input type="text" ng-model='menu.bs' class="" id=""  style='width:400px;float:left;' disabled placeholder="上级菜单名称，不可编辑"></td>
			<td width="10%" align='right'>菜单名称:</td><td  width="50%"><input type="text" ng-model='menu.menuname' style='width:400px' class="" id="menuName" name="menuName" placeholder="菜单名称"/><font color='red' ></font></td>
		</tr>
		<tr>
		<td width="10%" align='right'>菜单路径:</td>
		<td>
	     <input type="text"  class="" id='url' ng-model='menu.url' name="url" placeholder="http://ip:port/webName/?">
	     <font color='red' ></font>
		</td>
		<td width="10%" align='right'>菜单标志:</td>
		<td>
	     <input type="text"  class="" id='menubs' ng-model='menu.menubs' name="menuBs" placeholder="菜单首字母"  style="width:400px;"/>
	     <font color='red' ></font>
		</td>
	</tr>   
	<tr>
		<td width="10%" align='right'>是否叶子:</td>
		<td align='left' width="40%"> 
	        <input type="radio"  value="1" ng-model="menu.isleaf" name="isLeaf"> 是
	        <input type="radio" value='0' ng-model="menu.isleaf" name="isLeaf"> 否
	      <font color='red' size=1>&nbsp;&nbsp;设置为叶子节点则不能再添加子节点！</font></td>
		<td width="10%" align='right'>菜单级别:</td>
		<td  width="50%"> 
	      <select id="level" name='level' ng-model="menu.level"style='width:400px'>
	        <option value="1">一级</option>
	        <option value="2">二级</option>
	        <option value="3">三级</option>
	      </select>
	    </td>
	</tr> 
	<tr>
		<td width="10%" align='right'>备注:</td>
		<td colspan=3>
	      <textarea class="" rows="5" name="bz" ng-model='menu.bz' style='width:700'></textarea>
		</td>
	</tr>   
	<tr>
		<td colspan=4 align='center'>
		<button type="submit" class="am-btn am-btn-primary">提交</button>
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
<script src="<%=basePath%>js/cdgl/subMenuList.js"></script>
</html>
