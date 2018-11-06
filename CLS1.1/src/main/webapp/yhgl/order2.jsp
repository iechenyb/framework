<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%  
String path=application.getRealPath(request.getRequestURI());  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<html ng-app="myapp2" ng-init="quantity=3;cost=5;show=true;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=basePath%>amazeui/css/amazeui.min.css">
<link rel="stylesheet" href="<%=basePath%>amazeui/css/app.css">
    </head>
    <body  ng-controller="orderByCtrl"> 
    <center><div ng-click="show=!show;">动态排序</div></center>
    &nbsp;&nbsp;&nbsp;&nbsp;模糊匹配所有列:<input ng-model="query"><br>
    &nbsp;&nbsp;&nbsp;&nbsp;
    模糊匹配name:<input ng-model="username" value="chenyb">
    age:<input ng-model="age">
    score:<input ng-model="score">
    <button ng-click='search(username)'>search</button>
    <button ng-click='showAll()'>show all</button><br>
     <table align=center class="am-table am-table-bordered" ng-show='show'>
    <thead align=center>
        <tr align=center>
            <th align=center>index</th>
            <th ng-click="col='name';xh=0;desc[0]=!desc[0]">name
            <span ng-class="{false:'am-icon-caret-down',true:'am-icon-caret-up'}[desc[0]==true]" calss="ng-hide am-icon-caret-down" ></span>
            </th>
            <th ng-click="col='gender';xh=1;desc[1]=!desc[1]">gender
            <span ng-class="{false:'am-icon-caret-down',true:'am-icon-caret-up'}[desc[1]==true]" calss="ng-hide am-icon-caret-down" ></span>
            </th>
            <th ng-click="col='age';xh=2;desc[2]=!desc[2]">age
            <span ng-class="{false:'am-icon-caret-down',true:'am-icon-caret-up'}[desc[2]==true]" calss="ng-hide am-icon-caret-down" ></span>
            </th>
            <th ng-click="col='score';xh=3;desc[3]=!desc[3]">score
            <span ng-class="{false:'am-icon-caret-down',true:'am-icon-caret-up'}[desc[3]==true]" calss="ng-hide am-icon-caret-down" ></span>
            </th>
        </tr>
    </thead>
    <tbody>
         <!--filter:query 匹配所有的单元格值-->
        <tr ng-repeat="d in filterUser|filter:query|orderBy:col:desc[xh]" ng-show="$index+1<=max">
            <td ng-bind="$index+1" align=center></td>
            <td ng-bind="d.name" align=center></td>
            <td align=center>{{sex[d.gender]}}</td>
            <td ng-bind="d.age" align=center></td>
            <td ng-bind="d.score" align=center></td>
        </tr>
    </tbody>
</table>
&nbsp;&nbsp;&nbsp;&nbsp;<span class="am-icon-tencent-weibo"> QQ</span>
<span class="am-icon-weixin"> Wechat</span>
<button ng-click="add(5)">显示+5</button>
<button ng-click="sub(5)">显示-5</button>
<button ng-click="add(10)">显示+10</button>
<button ng-click="sub(10)">显示-10</button>
max={{max}}
<hr>
&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" ng-model="checked">点击试试
&nbsp;&nbsp;&nbsp;&nbsp;<div ng-if="true"></div>
<p>&nbsp;&nbsp;&nbsp;&nbsp;ng-init总价： <span ng-bind="quantity * cost"></span></p>
&nbsp;&nbsp;&nbsp;&nbsp;1 如何仅对当前显示的记录进行排序？<br>
&nbsp;&nbsp;&nbsp;&nbsp;2 如何控制只排列指定的列，并保持其他图标不变化？<br>
&nbsp;&nbsp;&nbsp;&nbsp;3 如何显示或者隐藏更多行?<br>
&nbsp;&nbsp;&nbsp;&nbsp;4 如何显示公用图标?<br>
&nbsp;&nbsp;&nbsp;&nbsp;5 如何使用多个条件查询?<br>
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
 <script src="http://apps.bdimg.com/libs/angular.js/1.2.16/angular.min.js"></script>
<script type="text/javascript">
var app = angular.module('myapp2', []);

app.controller('orderByCtrl', function($scope) {
	/* $(window).scroll(
	    function(){
	    	if($(document).scrollTop()>=$(document).height-$(window).height)){
				 max = max+10;
				$scope.user = $scope.user.slice(0,max);
				$scope.$apply(); 
			}
	    }		
	); */
    $scope.col = 'name';//默认按name列排序
    $scope.max = 5;//默认按name列排序
    $scope.desc = [false,false,false,false];//默认排序条件升序
    $scope.sex=['男','女'];
    $scope.showAll=function(){
    	 $scope.filterUser = $scope.user.concat();
    	 $scope.$apply();
    };
    $scope.sub=function(num){
    	if($scope.max>num){
    		$scope.max=$scope.max-num;
    	}else{
    		$scope.max=0;
    	}
    };
    $scope.add=function(num){
    	if($scope.max+num<=$scope.user.length){
    		$scope.max=$scope.max+num;
    	}else{
    		$scope.max=$scope.user.length;
    	} 
    };
    $scope.username='';
    $scope.score='';
    $scope.search=function(){
	    if(typeof($scope.username) == "undefined"||typeof($scope.score) == "undefined"||typeof($scope.age) == "undefined"){
	    	alert('填写条件均为空，不执行查询1！');
	    	$scope.filterUser = $scope.user.concat();
	    	$scope.$apply();
	    } else if($scope.username==''&&$scope.score==''&&$scope.age==''){
	    	alert('填写条件均为空，不执行查询2！');
	    	$scope.filterUser = $scope.user.concat();
	    	$scope.$apply();
	    }else{
	    	$scope.filterUser =[];
	    	$scope.user.forEach(
	    	  function (item){
	    		  var yes = item.name==$scope.username||item.score==parseInt($scope.score)||item.age==parseInt($scope.age);
	    		   if(yes){
	    			   //$scope.filterUser.splice($scope.filterUser.indexOf(item));//删除
	    			   $scope.filterUser.push(item);
	    		   }else{
	    			  //page.users.splice(page.users.indexOf(pubUser), 1);//delete record from page
	    			  //this.remove(item);
	    			  return ;
	    		   } 
	    		 
	    	  });
	    	$scope.$apply();
    	}
    };
    $scope.user = [{
        name: 'name1',
        gender: '0',
        age: 26,
        score: 70
    }, {
        name: 'name2',
        gender: '1',
        age: 24,
        score: 84
    }, {
        name: 'name3',
        gender: '0',
        age: 20,
        score: 76
    }, {
        name: 'name4',
        gender: '1',
        age: 22,
        score: 65
    }, {
        name: 'name5',
        gender: '1',
        age: 29,
        score: 78
    }, {
        name: 'name6',
        gender: '1',
        age: 12,
        score: 69
    }, {
        name: 'name7',
        gender: '1',
        age: 42,
        score: 100
    }, {
        name: 'name8',
        gender: '1',
        age: 52,
        score: 99
    }, {
        name: 'bb9',
        gender: '1',
        age: 22,
        score: 89
    }, {
        name: 'bb10',
        gender: '1',
        age: 20,
        score: 56
    }, {
        name: 'cc11',
        gender: '1',
        age: 28,
        score: 74
    }, {
        name: 'cc12',
        gender: '1',
        age: 22,
        score: 60
    }, {
        name: 'cc13',
        gender: '1',
        age: 32,
        score: 84
    }];
    $scope.filterUser = $scope.user.concat();
});
</script>
    </body>
</html>