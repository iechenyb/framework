var app = angular.module('app',[]);
app.controller('controller',main);
var scope ;
var path ;
function main($scope,$q,$http){
	 scope = $scope;
	 path = $('#path').val();
	 var url = path+'cdgl/tree1.cs?root=MENUROOT';
	 scope.reshTree=reshTree;
	 $.ajax({
		 url:url,
		 async:false,
		 success:function (data){
			 scope.menus = data[0];
			 tree(jQuery);
			 drawTree();
		 }
	 });	 
}
function reshTree(){
	var url = path+'cdgl/tree1.cs?root=MENUROOT';
	 $.ajax({
		 url:url,
		 async:false,
		 success:function (data){
			 scope.menus = data[0].children;
			 tree(jQuery);
			 drawTree();
			 scope.$apply();
		 }
	 });	
}
