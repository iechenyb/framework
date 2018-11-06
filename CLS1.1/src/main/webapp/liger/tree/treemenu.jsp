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
    <script src="../lib/ligerUI/js/plugins/ligerMenu.js" type="text/javascript"></script>
    <script type="text/javascript">
    //$("#tree3").ligerTree({ checkbox: false, parentIcon: null, childIcon: null });场景二：不使用复习框和图标： 
        var menu;
        var actionNodeID;
        var manager = null;
         function itemclick(item, i)
        {
            alert(actionNodeID + " | " + item.text);
        }
         
        $(function ()
        {
            menu = $.ligerMenu({ top: 100, left: 100, width: 120,items:
            [
            { text: '增加', click: itemclick, icon: 'add' },
            { text: '修改', click: itemclick },
            { line: true },
            { text: '查看', click: itemclick }
            ]
            });

            $("#tree1").ligerTree({ 
           onCheck:function(note, checked)
                {
                    alert('onCheck:' + note.data.text + " checked:" + checked);
                    
                } ,
           onSelect: function(node){
                   alert(node.data.text);
                 },
            onContextmenu: function (node, e)
            { 
                actionNodeID = node.data.text;
                menu.show({ top: e.pageY, left: e.pageX });
                return false;
            }
            });
            manager = $("#tree1").ligerGetTreeManager();
        });
       
        function showData(){
       	 var node = manager.getSelected();
       	 alert(node);
       }
    </script>
</head>
<body style="padding:10px">  
    <!--带复选框和Icon-->
      <a class="l-button" style="width:120px; margin-left:10px;float:left;" onclick="showData()">获取选中的值</a>
    <div style="width:500px; height:500px; margin:10px; float:left; border:1px solid #ccc; overflow:auto;  ">
    <ul id="tree1">
        <li>
            <span>节点1</span>
            <ul>
                <li>
                    <span>节点1.1</span>
                     <ul>
                        <li><span>节点1.1.1</span></li>
                        <li><span>节点1.1.2</span></li>
                     </ul>
                 </li>
                 <li><span>节点1.2</span></li>
            </ul>
        </li> 
        <li><span>节点2</span></li>
        <li>
            <span>节点3</span>
            <ul>
                <li><span>节点3.1</span></li>
                <li><span>节点3.2</span></li>
            </ul>
        </li>
        <li>
            <span>节点4</span>
            <ul>
                <li  isexpand="false">
                    <span>节点4.1</span>
                    <ul>
                        <li>
                            <span>节点4.1.1</span>
                            <ul>
                                <li><span>节点4.1.1.2</span></li>
                                <li><span>节点4.1.1.2</span></li>
                            </ul>
                        </li>
                        <li><span>节点4.1.2</span></li>
                    </ul>
                </li>
                <li><span>节点4.2</span></li>
            </ul>
        </li>
    </ul>
    </div> 
        <div style="display:none">右键点击节点，并点击弹出菜单的项才，查看效果。
    </div>
</body>
</html>
