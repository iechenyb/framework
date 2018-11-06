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
    <script src="../lib/ligerUI/js/plugins/ligerTip.js" type="text/javascript"></script>
    <script type="text/javascript">
        var manager = null;

        $(".l-tree .l-body span").live('mouseover', function (e) {
            if (!this.title) 
                this.title = $(this).text();
        });

        $(function ()
        {
            $("#tree1").ligerTree(
            {
                url: '<%=basePath%>user/tree.cs', 
                ajaxType: 'get',
                nodeWidth : 60,
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
     
    </script>
</head>
<body style="padding:10px"> 
    <h4>模拟异步动态加载节点</h4> 
    <div  style="width:400px; height:500px;">
    <ul id="tree1" > 
        <li isexpand="false"><span>第一个节点</span><ul></ul></li>
        <li isexpand="false"><span>第二个节点</span><ul></ul></li>
    </ul> 
    </div>
        <div style="display:none">
     
    </div>
</body>
</html>
