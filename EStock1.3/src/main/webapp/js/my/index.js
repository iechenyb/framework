var app = angular.module('app',[]);
app.controller('controller',main);
var context;
var page;
function main($scope,$q,$http){
	 context = $('#context').val();
	 $scope.defaultNumber = 30 ;
	 $scope.condition = "";
	 $scope.stocks = "[]";
	 $scope.search = finder;
	 $scope.display = displayer;
	 $scope.showMore = showMoreer; 
	 $scope.showLess = showLesser; 
	 $scope.addNum = function(num){
		 $scope.defaultNumber =  $scope.defaultNumber+num;
	 };
	 document.onkeydown=function(event){
         var e = event || window.event || arguments.callee.caller.arguments[0];
        /* if(e && e.keyCode==27){ // 按 Esc 
             //要做的事情
           }
         if(e && e.keyCode==113){ // 按 F2 
              //要做的事情
            }  */          
          if(e && e.keyCode==13){ // enter 键
              //要做的事情
        	  finder();
         }
     }; 
	 page = $scope; 
}
function showMoreer(){
	var flag = false;
	if(page.defaultNumber>page.stocks.length){flage = false;}else{flag =  true;}
	return flag;
}
function showLesser(){
	var flag = false;
	if(page.defaultNumber>0){flage = true;}else{flag =  false;}
	return flag;
}
function displayer(num){
	if(num<=page.defaultNumber){return true;}else{return false;}
}
function finder(){
	 if(page.condition!=''){
		 var param = '?condition='+ page.condition;
		 $.ajax({
			 url:context+"ws/searchJson.zc"+param,
			 async:false,
			 success:function (data){
				 page.stocks = data[0].lst;
			 }
		 });
	 }else{
		 page.stocks = [];
		 page.$apply();
	 }
}