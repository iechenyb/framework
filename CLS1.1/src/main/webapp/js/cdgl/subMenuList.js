var app = angular.module('app',[]);
app.controller('controller',main);
var scope ;
var path ;
function main($scope,$q,$http){
	 scope = $scope;
	 path = $('#path').val();
	 scope.del = deleteMenu;
	 scope.modify = modifyMenu;
	 //scope.reshTree=reshTree;
	 var id = $('#parentId').val();
	 var url = path+'cdgl/sub.cs?parentId='+id;
	 var url2 = path+'cdgl/getMenu.cs?id='+id;
	 $.ajax({
		 url:url,
		 async:false,
		 success:function (data){
			 scope.menus = data;
		 }
	 }); 
	 $.ajax({
		 url:url2,
		 async:false,
		 success:function (data){
			 scope.parentName = data[0].menuname;
		 }
	 }); 
}

function modifyMenu(record){
	scope.menu =record;
	$('#modify').modal({
		    width : $(window).width() * 0.8,
			height : Math.min($(window).height() * 0.8, 480),
	 });
}
var pubRecord ;
function deleteMenu(record){
	  pubRecord = record;
	  $('#tip').modal({
	        relatedTarget: this,
	        onConfirm: function(options) {
	       	  $.ajax({
	       			 url:path+"cdgl/del.cs?id="+pubRecord.menuid,
	       			 async:false,
	       			 success:function (data){
	       				if(data==1){
	       				    scope.menus.splice(scope.menus.indexOf(pubRecord), 1);//delete record from page
	       				    scope.$apply();
	       					//alert("delete "+pubRecord.menuname+","+id+" success!");
	       				}else{
	       					alert("delete "+pubRecord.menuname+" failed!");
	       				}
	       			 }
	       		 });
	        },
	        //closeOnConfirm: false,
	        onCancel: function() {
	        }
	  });
}