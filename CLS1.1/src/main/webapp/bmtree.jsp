<%@ page language="java" contentType="text/html; charset=gbk"    pageEncoding="gbk"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>tree</title>
<style type="text/css" l></style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/tree.js"></script>
<link href="css/tree.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

(function($){
    $.fn.extend({
    accordion: function(options) {
		var defaults = {
			accordion: 'true',
			speed: 300,
			closedSign: '[+]',
			openedSign: '[-]'
		};
		var opts = $.extend(defaults, options);
 		var $this = $(this);
 		$this.find("li").each(function() {
 			if($(this).find("ul").size() != 0){
 				$(this).find("a:first").append("<span>"+ opts.closedSign +"</span>");
 				if($(this).find("a:first").attr('href') == "#"){
 		  			$(this).find("a:first").click(function(){return false;});
 		  		}
 			}
 		});
 		$this.find("li.active").each(function() {
 			$(this).parents("ul").slideDown(opts.speed);
 			$(this).parents("ul").parent("li").find("span:first").html(opts.openedSign);
 		});
  		$this.find("li a").click(function() {
  			if($(this).parent().find("ul").size() != 0){
  				if(opts.accordion){
  					if(!$(this).parent().find("ul").is(':visible')){
  						parents = $(this).parent().parents("ul");
  						visible = $this.find("ul:visible");
  						visible.each(function(visibleIndex){
  							var close = true;
  							parents.each(function(parentIndex){
  								if(parents[parentIndex] == visible[visibleIndex]){
  									close = false;
  									return false;
  								}
  							});
  							if(close){
  								if($(this).parent().find("ul") != visible[visibleIndex]){
  									$(visible[visibleIndex]).slideUp(opts.speed, function(){
  										$(this).parent("li").find("span:first").html(opts.closedSign);
  									});
  									
  								}
  							}
  						});
  					}
  				}
  				if($(this).parent().find("ul:first").is(":visible")){
  					$(this).parent().find("ul:first").slideUp(opts.speed, function(){
  						$(this).parent("li").find("span:first").delay(opts.speed).html(opts.closedSign);
  					});
  				}else{
  					$(this).parent().find("ul:first").slideDown(opts.speed, function(){
  						$(this).parent("li").find("span:first").delay(opts.speed).html(opts.openedSign);
  					});
  				}
  			}
  		});
    }
});
})(jQuery);
</script>
<script language="JavaScript">
 /* $(document).ready(function() {
	 initTree();
});  */
</script>
<body onload="initTree()">
<ul class="topnav">
	<li><a href="#" target="scriptbreaker">集团</a></li>
	<li><a href="#">分公司1</a>
		<ul>
			 <li class="active"><a href="#">部门1</a></li>
			 <li><a href="#">部门2</a></li>
			 <li><a href="#">公司3</a>
				<ul>
					<li><a href="#">部门1</a></li>
					<li><a href="#">部门2</a></li>
					<li><a href="#">部门3</a></li>
					 <li><a href="#">公司4</a>
					 <ul>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;部门1</a></li>
						<li><a href="#"><b>&nbsp;&nbsp;&nbsp;&nbsp;部门2</b></a></li>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;部门3</a></li>
					   <li><a href="http://www.baidu.com" target='_blank'>&nbsp;&nbsp;&nbsp;&nbsp;部门4</a>
				   </ul>
				</ul>
			</li>
			 <li><a href="#">部门3</a></li>
		</ul>
	</li>
	<li><a href="#">分公司2</a>
		<ul>
			 <li><a href="#">部门1</a></li>
			 <li><a href="#">部门2</a></li>
			 <li><a href="#">部门3</a></li>
			 <li><a href="#">公司1</a>
				<ul>
					<li><a href="#">部门1</a></li>
					<li><a href="#">部门2</a></li>
					<li><a href="#">部门3</a></li>
					<li><a href="#">部门4</a></li>
				</ul>
			</li>
			 <li><a href="#">部门4</a></li>
		</ul>
	</li>
	<li><a href="#">分公司3</a></li>
	<li><a href="#">分公司4</a></li>
</ul>
</body>
</html>