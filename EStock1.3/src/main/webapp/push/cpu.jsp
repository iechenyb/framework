<%@ page language="java"  import="com.cyb.utils.*"  contentType="text/html; charset=gbk"    pageEncoding="gbk"%>
<%  
String pushUrl = PropertyUtil.get("pushurlLocal");
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<html  ng-app="app">
  <head>
      <link rel="stylesheet" href="<%=basePath%>amazeui/css/amazeui.min.css">
      <link rel="stylesheet" href="<%=basePath%>amazeui/css/app.css">
          <script src="<%=basePath%>echarts/echarts-all.js"></script>
       <script src="<%=basePath%>js/jquery.min.js"></script>
       <script type="text/javascript" src="<%=basePath%>push/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>push/socket.io.js"></script>
 <script src="<%=basePath%>js/jquery.js"></script>
 <script src="<%=basePath%>angular/angular-1.0.1.min.js"></script>
 <title>Cpu����</title>
  </head>
  <script type="text/javascript" src="http://hq.sinajs.cn/list=sh601006" charset="gb2312"></script>
  <script type="text/javascript">
  var app = angular.module('app',[]);
  app.controller('controller',main);
  var scope ;	    
  var optionLine ;	 
  optionLine = {
  	    title : {
  	        text: '      ϵͳCPUʵʱռ����',
  	        subtext: ''
  	    },
  	    tooltip : {
  	        trigger: 'axis'
  	    },
  	    legend: {
  	    	show:true,
  	    	selectedMode:'single',
            selected:{
                'cpuʹ���ʷ���':true
            },
  	        data:['cpuʹ���ʷ���']
  	    },
  	    toolbox: {
  	        show : true,
  	        feature : {
  	            mark : {show: false},
  	            dataView : {show: false, readOnly: false},
  	            magicType : {show: false, type: ['line']},
  	            restore : {show: false},
  	            saveAsImage : {show: true}
  	        }
  	    },
  	    calculable : false,
  	    xAxis : [
  	        {
  	            type : 'category',
  	            axisLine: {onZero: true},
  	            boundaryGap : false,
  	            show:true,
  	            splitNumber:20,
  	            axisLabel: {
                    show: true,
                    textStyle: {
                        color: '#f0f'
                    }
  	            },
  	            data :[1,2,3,4]
  	        }
  	    ],
  	    yAxis : [
  	        {
  	            type : 'value',
  	            min:0,
  	            max:100,
  	            boundaryGap:false,
  	            splitNumber:20,
  	            axisLabel : {
  	            	 margin:10,
  	            	 textStyle: {
                         color: '#0aaaa3',
                         fontFamily:'Verdana',
                         fontSize:12,
                         fontStyle:'oblique',
                         fontWeight:'bold'
                     },
  	                formatter: function (value){return value.toFixed(0)+"%";}
  	            }
  	        }
  	    ],
  	    lineStyle:[
  	               {type:"line",
  	            	color:'red'}
  	               ],
  	    series : [
  	        {
  	            name:'cpuʹ�ðٷֱ�',
  	            type:'line',
  	            roam: true,   //��ק ��������
  	            symbol:'none',
  	            data: [2,30,4,50],
  	            itemStyle:{
  	            	normal:{
  	            		lineStyle:{
  	            			color:'green',
  	            			width:1
  	            		}
  	            	}
  	            },
  	            markLine : {
  	                data : [
  	                    [{name: '',value: '11.40', xAxis: '', yAxis: ''},{xAxis:'',yAxis: ''}]
  	    			  ]
                  }
  	        }
  	    ]
  	};
  var tip = '';
  var pushUrl;
  var socket ;
  function main($scope,$q,$http) {
	  setNowFormatDate();
	  pushUrl='<%=pushUrl%>';
	  <%-- $.ajax({
			 url:"<%=basePath%>phone/urlIO.zc",
			 async:false,
			 success:function (data){
	     	  pushUrl = data;
	       }
	  }); --%>
	  socket = io.connect(pushUrl);
	  socket.on('connect',function() {
 	       console.log("connect to server success ,pushurl is"+pushUrl+"!");
 	       tip = "connect to server success ,pushurl is"+pushUrl+"!";
 	    });
 		socket.on("connecting", function() {
 			console.log("connecting...");
 			tip = "connecting..."
 		});
 		socket.on('disconnect', function() {
 			console.log("disconnect to server");
 			tip = "disconnect to server";
 		});
 		socket.on('connect_failed', function() {
 			console.log("connect_failed");
 			tip = "connect_failed";
 			socket.connect();
 		});
 		socket.on('error', function(data) {
 			console.log("error" + data);
 			tip = "error" + data;
 			socket.connect();
 		});
 		socket.on('message', function(data) {
 			console.log("message" + data);
 			tip="message" + data;
 		});
 		socket.on('anything', function(data) {
 			console.log("connection anything" + data);
 			tip = "connection anything" + data;
 		});
 		socket.on('reconnect_attempt', function() {
 			console.log("reconnect_attempt");
 			tip = "reconnect_attempt";
 		});
 		socket.on('reconnect_failed', function() {
 			console.log("reconnect_failed");
 			tip = "reconnect_failed";
 			socket.connect();
 		});
 		socket.on('reconnect', function() {
 			console.log("reconnect success");
 			tip = "reconnect success";
 		});
 		socket.on('reconnecting', function(data) {
 			console.log("reconnecting..." + data);
 			tip = "reconnecting..." + data;
 		});
 		//alert(echarts);
 	    /*��굥���¼� EVENT.CLICK
 		  ���˫���¼� EVENT.DBLCLICK
 		  ��꾭���¼� EVENT.HOVER
 		  ����뿪�¼� EVENT.MOUSEOUT */
 	  socket.on('pushpoint',function(msg){
 		  var myChart = echarts.init($("#lineChart")[0]);
 		  optionLine.series[0].data=msg.data;
 		  optionLine.xAxis[0].data=msg.time;
 		  myChart.on("click",function(param){
 		  }); 
 		  myChart.setOption(optionLine,true);
 		  var idx1 = msg.time.length;
 		  var idx2 = msg.data.length;		  
 		  $('#cp').html("<div style='width:100%;border:solid 0px red;margin-top:15px;margin-bottom:20px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
 		  "<b>����������ʱ�䣺<font color=red size=5>"+msg.cur+"</font>,"+
 		  "�ۼƲɼ����� [<font color=red size=5>"+msg.points+"</font>],"+
 		  "��ʼ�ɼ�ʱ�䣺<font color=red size=5>"+msg.start+"</font>,"+
 		  "���²ɼ�ʱ�䣺<font color=red size=5>"+msg.end+"</font>"+
 		  "</b></div>");
 		 $('#cp1').html("<div style='width:100%;border:solid 0px red;margin-top:0px;margin-bottom:20px;'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CPU����:&nbsp;&nbsp;&nbsp;&nbsp;"+"���ڿ��<font color=red size=5>"+msg.width+"</font>,"+"ƽ��ֵ<font color=red size=5>"+
 		 msg.avg.toFixed(2)+"%</font>"+
 		 ",���ֵ <font color=red size=5>"+msg.max+"%</font>,"+
 		  "��Сֵ��<font color=red size=5>"+msg.min+"%</font>,"+
 		  "����ֵ��<font color=red size=5>"+msg.new1+"%</font>,"+
 		  "�����ٶȣ�<font color=red size=5>�ɼ�һ�����ݵ�/��</font>,"+
 		  "����״̬��<font color=red size=5>"+tip+"</font>"
 		 +"</b></div>");
 	  });
	  $('#infor').html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+hq_str_sh601006);
  }
  </script>
  
  <script type="text/javascript"> 
  function start(){
	  socket.connect();
	  tip = "connect to server success��";
  }
 function stop(){
	  socket.disconnect();
	  tip = "disconnect to server��";
  }
 function setNowFormatDate() {
	    var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var hour ="";
	    var min ="";
	    var sec ="";
	    if(date.getHours()>=0&&date.getHours()<=9){
	    	hour = "0"+date.getHours();
	    }else{
	    	hour = date.getHours();
	    }
	    if(date.getMinutes()>=0&&date.getMinutes()<=9){
	    	min = "0"+date.getMinutes();
	    }else{
	    	min = date.getMinutes();
	    }
	    if(date.getSeconds()>=0&&date.getSeconds()<=9){
	    	sec = "0"+date.getSeconds();
	    }else{
	    	sec = date.getSeconds();
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	            + " " + hour + seperator2 + min
	            + seperator2 + sec;
	   $("#time").html("<center><font color=red size=5>ҳ���ʼ��ʱ�䣺"+currentdate+"</font></center>");
	}
  </script>
  <body ng-controller="controller">
  <div class="am-g">
	   <div class="am-u-sm-4 "> &nbsp;</div>
	   <div class="am-u-sm-4 " >  
	   	<input type="button" onclick="start();" value="��   ��"/>
	   	<input type="button" onclick="stop();" value="��   ��"/>
	   </div>
	   <div class="am-u-sm-4 "> &nbsp;</div>
  </div>
  <div class="am-g">
	    <div class="am-u-sm-12 " id='cp1'> &nbsp;</div>
  </div>
  <div id='lineChart' style="height:700px;width:100%;">  </div>
  <div id='infor' style="display:none;"> </div>
 <!--  <div id='cp'> </div>
  <div id='time'> </div> -->
  <div class="am-g">
	    <div class="am-u-sm-12 " id='cp'> &nbsp;</div>
  </div>
  <div class="am-g" >
	    <div class="am-u-sm-12 " id='time'> &nbsp;</div>
  </div>
  </body>
</html>