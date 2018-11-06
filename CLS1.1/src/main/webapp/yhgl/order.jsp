<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%  
String path=application.getRealPath(request.getRequestURI());  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<html ng-app>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
         <script src="http://apps.bdimg.com/libs/angular.js/1.2.16/angular.min.js"></script>

    </head>
    <body>
      <hr>
        <div ng-controller="ctl">
                           条 件:<input ng-model="query">
                            静态select,order by:<select ng-model="order">
                <option value="name">name</option>
                <option value="age">age</option>
            </select> 
			 动态select,order by:
			<select ng-model="order1" ng-change="showVal()" ng-options="type.name for type in types">
            </select>
            <ul class="persons">
                <li ng-repeat="person in persons | filter:query | orderBy:order">
                    {{person.name}}
                    {{person.age}}
                </li>
            </ul>
        </div>
        <script type="text/javascript">
            function ctl($scope){//controller(参数)
            	$scope.showVal=function(){
            		//alert($scope.order1.value+","+$scope.order1.name);//选中的是对象，而不是值
            		$scope.order = $scope.order1.value;
            	}
            	$scope.types=[{name:'name',value:'name'},{name:'age',value:'age'}];
                $scope.persons = [
                    {"name":"xingoo","age":25},
                    {"name":"zhangsan","age":18},
                    {"name":"lisi","age":20},
                    {"name":"wangwu","age":30}
                ];
                $scope.order = "age";
            }
        </script>
        <hr>
    </body>
</html>