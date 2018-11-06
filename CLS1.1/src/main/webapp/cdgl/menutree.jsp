<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<html>
<head>
    <title></title>
    <script src="<%=basePath%>liger/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <link href="<%=basePath%>liger/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>liger/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="<%=basePath%>liger/lib/ligerUI/js/plugins/ligerTree.js" type="text/javascript"></script>
    <script type="text/javascript">
    var manager = null;

    $(".l-tree .l-body span").live('mouseover', function (e) {
        if (!this.title) 
            this.title = $(this).text();
    });

    $(function ()
    {
        $("#tree1").ligerTree(
        {   checkbox:false,
        	onSelect: function(node){
                //alert(node.data.text);
                 toPage(node.data.attributes);
            },
            url: '<%=basePath%>cdgl/tree.cs?root=MENUROOT', //user/tree.cs 静态数据
            ajaxType: 'get',
            nodeWidth : 100,
            onBeforeExpand: onBeforeExpand,
            onExpand: onExpand
        });
        manager = $("#tree1").ligerGetTreeManager();
    });
 
    function onBeforeExpand(note)
    {
        if (note.data.children && note.data.children.length == 0)
        {
            //这里模拟一个加载节点的方法，append方法也用loadData(target,url)代替
            manager.append(note.target, [
            { text: note.data.text + "'s child1" },
            { text: note.data.text + "'s child2" },
            { text: note.data.text + "'s child3" }
           ]);
        }
    }
    function onExpand(note)
    { 
    	
    }
    var path='<%=basePath%>';
    function toPage(node){
     if(node.isleaf==1){	
	   	 $('#page').attr("href",path+node.url);
	   	 document.getElementById("page").click();
   	 }
   }
    </script>
</head>
<body style="padding:10px">  
<div>
<!-- <a class="l-button" style="width:120px; margin-left:10px; float:left;" onclick="f_selectNode()">选择行</a>
 <a class="l-button" style="width:120px; margin-left:10px;float:left;" onclick="f_cancelSelect()">反选择行</a>
  <a class="l-button" style="width:120px; margin-left:10px;float:left;" onclick="showData()">获取选中的值</a> -->
 <a href='#' id='page' target='rightFrame'></a>
</div>
    <div style="width:90%; height:700px; margin:1px; float:left; clear:both; border:1px solid #ccc; overflow:auto;  ">
    <ul id="tree1"></ul>
    </div> 
        <div style="display:none">
                     不用复选框： checkbox: false,
    </div>
</body>
</html>
