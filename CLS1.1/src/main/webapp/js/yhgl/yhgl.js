var app = angular.module('app',[]);
app.controller('controller',main);
var page ;
var path ;
function main($scope,$q,$http){
	 page = $scope;
	 path = $('#path').val();
	 page.save=saveUser;	
	 page.setUser=setUser;
	 page.submitMod=submitMod;
	 page.del=deleteUser;	
	 var url = path+'yhgl/all.cs';
	 $.ajax({
		 url:url,
		 async:false,
		 success:function (data){
			 page.users = data;
		 }
	 }); 
	 
}
function submitMod(user){
	var url = path+'yhgl/mod.cs';
	delete user["$$hashKey"];  
	$.ajax({
		 method: "POST",
		 url:url,
	     dataType:"json",      
         contentType:"application/json",               
         data:JSON.stringify(user), 
		 async:false,
		 success:function (data){
		 }
	 });	
	 page.user={};
	 //page.$apply();
	 $('#modify').modal('close');//$modal.modal('close');
}
function saveUser(user){
	delete user["$$hashKey"];  
	var url = path+'yhgl/add.cs';
	 $.ajax({
		 method: "POST",
		 url:url,
	     dataType:"json",      
         contentType:"application/json",               
         data:JSON.stringify(user), 
		 async:true,
		 success:function (data){
			 /*if(data=="1"){ }else{
				 alert("save failed!")
			 }*/try{
				 alert("save success! name="+data.id)
				 page.users.push(data);
				 page.user={};
				 page.$apply();
			 }catch(e){
				 alert(e);
			 }
			 return ;
		 }
	 });	
	 
 }

function setUser(record){
	page.user1 =record;
	$('#modify').modal({
		    width : $(window).width() * 0.8,
			height : Math.min($(window).height() * 0.8, 480),
	 });
}
var pubUser;//全局变量
function deleteUser(cyb){
	  //page.user = cyb;
	  pubUser = cyb;//两种全局变量使用方式均可解决删除同一条记录的问题，执行顺序 ，见注释标号
	  delete cyb["$$hashKey"];  
	  $('#tip').modal({//1
	        relatedTarget: this,
	        onConfirm: function(options) {//3
	        	var url = path+'yhgl/del.cs?id='+pubUser.id;//path+'yhgl/del.cs?id='+index;根据id删除
	        	$.ajax({
	        		 url:url,//使用cyb会报错,直接使用deleteUser的参数cyb。两个cyb不一样,使用全局变量可以解决问题。
	        		 async:true,
	        		 success:function (data){
	        			 if(data=="1"){
	        				 alert("delete success! ");
	        				 page.users.splice(page.users.indexOf(pubUser), 1);//delete record from page
	        			     page.$apply();
	        			 }else{
	        				 alert("delete failed!")
	        			 }
	        			 return;
	        		 }
	        	 });/*delete by id */	
	        	//delete by object
	        	/* delete cyb["$$hashKey"];  
	        	 var url = path+'yhgl/delObj.cs';
	        	 $.ajax({
	       		 method: "POST",
	       		 url:url,
	       	     dataType:"json",      
	             contentType:"application/json",               
	             data:JSON.stringify(cyb), 
	       		 async:true,
	       		 success:function (data){
	       			 if(data=="1"){
        				 alert("delete success! name="+cyb.username)
        				 page.users.splice(page.users.indexOf(cyb), 1);//delete record from page
//        				 record={};
//	       				 var item = page.users[index];
//	       			     removeItem(item);
        			     page.$apply();
        			 }else{
        				 alert("delete failed!")
        			 }
        			 return;
	       	    }
	       	   });	*/
	      
	   },
	        //closeOnConfirm: false,
	        onCancel: function() {
	        }
	  });//2	
}
function orderEvent(){
	  var up = page.direct;
	  /*page.users.filter(
		function (item){
			return item["username"].toString().indexOf("")>=0;
		}	  
	  );*/
	  page.users.forEach(
		function(item){
			return;
		}	  
	  );
	  alert(up);
	  if(up=="0"){
		  page.users.sort(
			function(a,b){
				return a[page.order]>b[page.order]?1:-1;
			});
	  }else{
		  page.users.sort(
			function(a,b){
				return a[page.order]<b[page.order]?1:-1;
			});
	  }
}
