<%@ page language="java" contentType="text/html; charset=gbk"    pageEncoding="gbk"%>
<%  
String basePath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
%> 
<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�ޱ����ĵ�</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jsapi.js"></script>
<script type="text/javascript" src="js/format+zh_CN,default,corechart.I.js"></script>		
<script type="text/javascript" src="js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="js/jquery.ba-resize.min.js"></script>

<script type="text/javascript">
		gvChartInit();
		jQuery(document).ready(function(){

		jQuery('#myTable5').gvChart({
				chartType: 'PieChart',
				gvSettings: {
					vAxis: {title: 'No of players'},
					hAxis: {title: 'Month'},
					width: 650,
					height: 250
					}
			});
		});
		</script>
</head>


<body>

	<div class="place">
    <span>λ�ã�</span>
    <ul class="placeul">
    <li><a href="#">��ҳ</a></li>
    <li><a href="#">����̨</a></li>
    </ul>
    </div>
    
    
    <div class="mainbox">
    
    <div class="mainleft">
    
    
    <div class="leftinfo">
    <div class="listtitle"><a href="#" class="more1">����</a>����ͳ��</div>
        
    <div class="maintj">  
    <table id='myTable5'>
				<caption>uimaker.com players count</caption>
				<thead>
					<tr>
						<th></th>
						<th>Jan</th>
						<th>Feb</th>
						<th>Mar</th>
						<th>Apr</th>
						<th>May</th>
						<th>Jun</th>
						<th>Jul</th>
						<th>Aug</th>
						<th>Sep</th>
						<th>Oct</th>
						<th>Nov</th>
						<th>Dec</th>
					</tr>
				</thead>
					<tbody>
					<tr>
						<th>2010</th>
						<td>125</td>
						<td>185</td>
						<td>327</td>
						<td>359</td>
						<td>376</td>
						<td>398</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>
				</tbody>
			</table>  
    </div>
    
    </div>
    <!--leftinfo end-->
    
    
    <div class="leftinfos">
    
   
    <div class="infoleft">
    
    <div class="listtitle"><a href="#" class="more1">����</a>��������</div>    
    <ul class="newlist">
    <li><a href="#">�Ϻ���ó��������ʽ���Ƴ���</a><b>10-09</b></li>
    <li><a href="#">ϰ��ƽ���ö��������� �״γ�ϯAPEC���</a><b>10-08</b></li>
    <li><a href="#">��߷�:�ѳ�ը���º��౸���ߴ���׷����</a><b>10-09</b></li>
    <li><a href="#">���������������� ����ȫ��������Ⱦ</a><b>10-06</b></li>
    <li><a href="#">"����ר��"����������Ѱ�����±��̾�</a><b>10-05</b></li>
    <li><a href="#">����Ѳ���飺�����һ���ּල����λ</a><b>10-04</b></li>
    <li><a href="#">��!����û�ĺóɻ�����(ͼ)</a><b>10-03</b></li>
    </ul>   
    
    </div>
    
    
    <div class="inforight">
    <div class="listtitle"><a href="#" class="more1">���</a>���ù���</div>
    
    <ul class="tooli">
    <li><span><img src="images/d01.png" /></span><p><a href="#">��Ϣ����</a></p></li>
    <li><span><img src="images/d02.png" /></span><p><a href="#">�༭</a></p></li>
    <li><span><img src="images/d03.png" /></span><p><a href="#">���±�</a></p></li>
    <li><span><img src="images/d04.png" /></span><p><a href="#">��������</a></p></li>
    <li><span><img src="images/d05.png" /></span><p><a href="#">ͼƬ����</a></p></li>
    <li><span><img src="images/d06.png" /></span><p><a href="#">����</a></p></li>
    <li><span><img src="images/d07.png" /></span><p><a href="#">������</a></p></li>    
    </ul>
    
    </div>
    
    
    </div>
    
    
    </div>
    <!--mainleft end-->
    
    
    <div class="mainright">
    
    
    <div class="dflist">
    <div class="listtitle"><a href="#" class="more1">����</a>������Ϣ</div>    
    <ul class="newlist">
    <li><a href="#">�Ϻ���ó��������ʽ���Ƴ���</a></li>
    <li><a href="#">ϰ��ƽ���ö��������� �״γ�ϯAPEC���</a></li>
    <li><a href="#">��߷�:�ѳ�ը���º��౸���ߴ���׷����</a></li>
    <li><a href="#">���������������� ����ȫ��������Ⱦ</a></li>
    <li><a href="#">"����ר��"����������Ѱ�����±��̾�</a></li>
    <li><a href="#">����Ѳ���飺�����һ���ּල����λ</a></li>
    <li><a href="#">��!����û�ĺóɻ�����(ͼ)</a></li>
    <li><a href="#">���Żƽ��ܼ��ɻ�����Ա�����⳵Υ����Ϊ</a></li>
    <li><a href="#">��ۻ����ֳ�������֧����������������</a></li> 
    </ul>        
    </div>
    
    
    <div class="dflist1">
    <div class="listtitle"><a href="#" class="more1">����</a>��Ϣͳ��</div>    
    <ul class="newlist">
    <li><i>��Ա����</a></i>2535462</li>
    <li><i>�ĵ�����</a></i>5546</li>
    <li><i>��ͨ���£�</a></i>2315</li>
    <li><i>�����</a></i>1585</li>
    <li><i>��������</a></i>5342</li>    
    </ul>        
    </div>
    
    

    
    
    </div>
    <!--mainright end-->
    
    
    </div>



</body>
<script type="text/javascript">
	setWidth();
	$(window).resize(function(){
		setWidth();	
	});
	function setWidth(){
		var width = ($('.leftinfos').width()-12)/2;
		$('.infoleft,.inforight').width(width);
	}
</script>
</html>
