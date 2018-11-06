<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>tree</title>
<style type="text/css"></style>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/tree.js"></script>
<link href="../css/tree.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
  $(document).ready(function() {
	 tree(jQuery);
	 drawTree();
  });  
</script>
</head>
<body>
<ul class="tree">
	<li><a href="javascript:void(0)" target="rightFrame1">系统菜单</a></li>
	<li><a href="#">分公司1</a>
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
					   <li><a href="http://www.baidu.com" target='rightFrame'>&nbsp;&nbsp;&nbsp;&nbsp;部门4</a>
				   </ul>
				</ul>
			</li>
			 <li><a href="#">部门3</a></li>
		</ul>
	</li>
	<li><a href="#">分公司2</a>
		<ul>
			 <li><a href="#">部门1</a></li>
			 <li><a href="#">部门2</a></li>
			 <li><a href="#">部门3</a></li>
			 <li><a href="#">公司1</a>
				<ul>
					<li><a href="#">部门1</a></li>
					<li><a href="#">部门2</a></li>
					<li><a href="#">部门3</a></li>
					<li><a href="#">部门4</a></li>
				</ul>
			</li>
			 <li><a href="#">部门4</a></li>
		</ul>
	</li>
	<li><a href="#">分公司3</a></li>
	<li><a href="#">分公司4</a></li>
</ul>
</body>
</html>