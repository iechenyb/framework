<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<html>
<head>
    <title></title>
    <script src="../lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <link href="../lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="../lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="../lib/ligerUI/js/plugins/ligerTree.js" type="text/javascript"></script>
</head>
<body style="padding:10px">  
<div>
<a class="l-button" style="width:120px; margin-left:10px; float:left;" onclick="ffff_selectNode()">选择行</a>
 <a class="l-button" style="width:120px; margin-left:10px;float:left;" onclick="ffff_cancelSelect()">反选择行</a>
  <a class="l-button" style="width:120px; margin-left:10px;float:left;" onclick="showData()">获取选中的值并跳转</a><br>
  <div id='infor'> </div>
  <a href='#' id='page' target='_blank'></a>
</div>

    <div style="width:200px; height:300px; margin:10px; float:left; clear:both; border:1px solid #ccc; overflow:auto;  ">


    <ul id="tree1"></ul>
    </div> 
 
        <div style="display:none">
                     不用复选框： checkbox: false,
    </div>
     <script type="text/javascript">
    var tree = null;
    var manager = null;
    $(function ()
    {
        tree = $("#tree1").ligerTree({
        checkbox: false,
        data: [
            {  
            	text: '节点1', children: [
                { id:'xxx',text: '节点1.1',cyb:'selfden val',url:'www.baidu.com' },
                { text: '节点1.2' },
                { text: '节点1.3', children: [
                     { text: '节点1.3.1' },
                     { text: '节点1.3.2',cyb:'selfden val',url:'www.baidu.com' }
                ]
                },
                { text: '节点1.4' }
             ]
            },
            { text: '节点2' },
            { text: '节点3' },
            { text: '节点4' }
        ]
        });
        manager = $("#tree1").ligerGetTreeManager();
});
function ffff_selectNode()
{
    var parm = function (data)
    
    {
    	//alert(data.text.indexOf('节点1.3'));//循环调用，当等于text值时，停止
        return data.text.indexOf('节点1.3') == 0;
    };

    tree.selectNode(parm);
}

function ffff_cancelSelect()
{
     var parm = function (data)
    {
    	//alert(data);
        return false;
    }; 

    tree.selectNode(parm);
}
function showData(){
	 var node = manager.getSelected();
	 $('#infor').html(' <font color=red size=5 > text='+node.data.text+',url='+node.data.url+',自定义属性='+node.data.cyb+"</font>");
	 //window.location.href("http://"+node.data.url);
	 $('#page').attr("href","http://"+node.data.url);
	// $('#page').click();
	 document.getElementById("page").click();
}
    </script>
</body>
</html>
