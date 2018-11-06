<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%  
String path=application.getRealPath(request.getRequestURI());  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%>
<!DOCTYPE html>
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>tree</title>
<style type="text/css"></style>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<link href="../css/tree.css" rel="stylesheet" type="text/css" />
<input type="hidden" id='path' name='path' value="<%=basePath%>"/>
</head>
<body ng-controller="controller">
<%=basePath%>
<ul class="tree">
<!--  1-->
	  <li><a href="#">&nbsp;&nbsp;分公司1</a>
		<ul>
			 <li class="active"><a href="addMenu.jsp?pid=7ca93b129c1345da8cb5c4a94c1c2d8e" target="rightFrame">部门1</a></li>
			 <li><a href="#">部门2</a></li>
			 <li><a href="#">公司3</a>
				<ul>
					<li><a href="#">部门1</a></li>
					<li><a href="#">部门2</a></li>
					<li><a href="#">部门3</a></li>
					<li><a href="#">公司4</a>
					<ul>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;部门1</a></li>
						<li><a href="#"><b>&nbsp;&nbsp;&nbsp;&nbsp;部门2</b></a></li>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;部门3</a></li>
					    <li><a href="#" target='rightFrame'>&nbsp;&nbsp;&nbsp;&nbsp;部门4</a>
					    <ul>
						    <li><a href="#">部门1</a></li>
							<li><a href="#">部门2</a></li>
							<li><a href="#">部门3</a></li>
						</ul>
				   </ul>
				</ul>
			</li>
			 <li><a href="#">部门4</a></li>
		</ul>
	</li>
   <!-- 1 -->
   <!-- 2 -->
	<li><a href="addMenu.jsp?id={{menus.menuid}}&bs=MENUROOT" title='{{menus.menuid}}-{{menus.menubs}}' target="rightFrame">系统菜单</a></li>
	  <div ng-repeat='m1 in menus.children'>	   
		<li ><a href="addMenu.jsp?id={{m1.menuid}}&bs={{m1.menubs}}" title='{{m1.menuid}}-{{m1.menubs}}'  target="rightFrame">&nbsp;&nbsp;{{m1.menuname}}</a></li>
	      <div ng-repeat='m2 in m1.children'>
	   		<li><a href="addMenu.jsp?id={{m2.menuid}}&bs={{m2.menubs}}" title='{{m2.menuid}}-{{m2.menubs}}' target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;{{m2.menuname}}</a></li>
	             <div ng-repeat='m3 in m2.children'>
	            	<li><a href="addMenu.jsp?id={{m3.menuid}}&bs={{m3.menubs}}" title='{{m3.menuid}}-{{m3.menubs}}' target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{m3.menuname}}</a></li>
			            <div ng-repeat='m4 in m3.children'>
			            	<li><a href="addMenu.jsp?id={{m4.menuid}}&bs={{m4.menubs}}" title='{{m4.menuid}}-{{m4.menubs}}' target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{m4.menuname}}</a></li>
					           <div ng-repeat='m5 in m4.children'>
					            	<li><a href="addMenu.jsp?id={{m5.menuid}}&bs={{m5.menubs}}" title='{{m5.menuid}}-{{m5.menubs}}' target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{m5.menuname}}</a></li>
				           				 <div ng-repeat='m6 in m5.children'>
				           					 <li><a href="addMenu.jsp?id={{m6.menuid}}&bs={{m6.menubs}}" title='{{m6.menuid}}-{{m6.menubs}}' target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{m6.menuname}}</a></li>
				           				       <div ng-repeat='m7 in m6.children'>
				           							 <li><a href="addMenu.jsp?id={{m7.menuid}}&bs={{m7.menubs}}" title='{{m7.menuid}}-{{m7.menubs}}' target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{m7.menuname}}</a></li>
						           				 	   <div ng-repeat='m8 in m7.children'>
						           							 <li><a href="addMenu.jsp?id={{m8.menuid}}&bs={{m8.menubs}}" title='{{m8.menuid}}-{{m8.menubs}}' target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{m8.menuname}}</a></li>
								           				 	   	 <div ng-repeat='m9 in m8.children'>
								           							 <li><a href="addMenu.jsp?id={{m9.menuid}}&bs={{m9.menubs}}" title='{{m9.menuid}}-{{m8.menubs}}' target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{m9.menuname}}</a></li>
										           				 	     <ul></ul>
										           				 	     <div ng-repeat='m10 in m9.children'>
										           							 <li><a href="addMenu.jsp?id={{m10.menuid}}&bs={{m10.menubs}}" title='{{m10.menuid}}-{{m10.menubs}}' target="rightFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{m10.menuname}}</a></li>
										           				 	     </div><!-- 10 -->
								           				 	     </div><!-- 9 -->
						           				 	   </div><!-- 8 -->
				           				 	   </div><!-- 7 -->
				           				 </div><!-- 6 -->
					            </div> <!-- 5 -->
			            </div> <!-- 4 -->
	            </div> <!-- 3 -->
	      </div><!-- 2 -->
	</div><!-- 1 -->
</ul>
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
 <script src="<%=basePath%>angular/angular-1.0.1.min.js"></script>
 <script src="<%=basePath%>amazeui/js/handlebars.min.js"></script>
<script src="<%=basePath%>amazeui/js/amazeui.widgets.helper.js"></script>
<script src="<%=basePath%>amazeui/js/amazeui.widgets.helper.min.js"></script>
<script type="text/javascript" src="../js/tree.js"></script>
<script src="<%=basePath%>js/cdgl/menutree.js"></script>

<script type="text/javascript">
	 /*tree(jQuery);
	 drawTree();*/
</script>
</html>