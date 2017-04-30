<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title>索骏电力后台管理平台</title><!--  - Powered By JeeSite -->
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" /><meta name="author" content="http://jeesite.com/"/>
<meta name="renderer" content="webkit"><meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10" />
<meta http-equiv="Expires" content="0"><meta http-equiv="Cache-Control" content="no-cache"><meta http-equiv="Cache-Control" content="no-store">
<!--  
<script src="/ayy/static/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
<link href="/ayy/static/bootstrap/2.3.1/css_cerulean/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="/ayy/static/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<link href="/ayy/static/bootstrap/2.3.1/awesome/font-awesome.min.css" type="text/css" rel="stylesheet" />
<link href="/ayy/static/jquery-select2/3.5.4/select2.css" rel="stylesheet" />
<script src="/ayy/static/jquery-select2/3.5.4/select2.js" type="text/javascript"></script>
<link href="/ayy/static/jquery-validation/1.11.0/jquery.validate.min.css" type="text/css" rel="stylesheet" />
<script src="/ayy/static/jquery-validation/1.11.0/jquery.validate.min.js" type="text/javascript"></script>
<link href="/ayy/static/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css" rel="stylesheet" />
<script src="/ayy/static/jquery-jbox/2.3/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script src="/ayy/static/jquery-jbox/2.3/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script src="/ayy/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="/ayy/static/common/mustache.min.js" type="text/javascript"></script>
<link href="/ayy/static/bootstrap-table/bootstrap-table.css" rel="stylesheet"/>
<script src="/ayy/static/bootstrap-table/bootstrap-table.js" type="text/javascript"></script>
<script src="/ayy/static/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<link href="/ayy/static/common/jeesite.min.css" type="text/css" rel="stylesheet" />
<script src="/ayy/static/common/jeesite.js" type="text/javascript"></script>
<script src="/ayy/static/jquery/jquery-form.js" type="text/javascript"></script>
<script type="text/javascript">var ctx = '/ayy/a', ctxStatic='/ayy/static';</script>
<script>var _hmt=_hmt||[];(function(){var hm=document.createElement("script");hm.src="//hm.baidu.com/hm.js?82116c626a8d504a5c0675073362ef6f";var s=document.getElementsByTagName("script")[0];s.parentNode.insertBefore(hm,s);})();</script>
-->	
<script src="<%=request.getContextPath() %>/static/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/static/bootstrap/2.3.1/css_cerulean/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/static/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/static/bootstrap/2.3.1/awesome/font-awesome.min.css" type="text/css" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/static/jquery-select2/3.5.4/select2.css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/static/jquery-select2/3.5.4/select2.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/static/jquery-validation/1.11.0/jquery.validate.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/static/jquery-validation/1.11.0/jquery.validate.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/static/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/static/jquery-jbox/2.3/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/jquery-jbox/2.3/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/common/mustache.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/static/bootstrap-table/bootstrap-table.css" rel="stylesheet"/>
<script src="<%=request.getContextPath() %>/static/bootstrap-table/bootstrap-table.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<link href="<%=request.getContextPath() %>/static/common/jeesite.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/static/common/jeesite.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/jquery/jquery-form.js" type="text/javascript"></script>

	
	<meta name="decorator" content="blank"/>
	<link rel="Stylesheet" href="<%=request.getContextPath() %>/static/jerichotab/css/jquery.jerichotab.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/jerichotab/js/jquery.jerichotab.js"></script>
	<style type="text/css">
		#main {padding:0;margin:0;} #main .container-fluid{padding:0 4px 0 6px;}
		#header {margin:0 0 8px;position:static;} #header li {font-size:14px;_font-size:12px;}
		#header .brand {font-family:Helvetica, Georgia, Arial, sans-serif, 黑体;font-size:26px;padding-left:33px;}
		#footer {margin:8px 0 0 0;padding:3px 0 0 0;font-size:11px;text-align:center;border-top:2px solid #0663A2;}
		#footer, #footer a {color:#999;} #left{overflow-x:hidden;overflow-y:auto;} #left .collapse{position:static;}
		#userControl>li>a{/*color:#fff;*/text-shadow:none;} #userControl>li>a:hover, #user #userControl>li.open>a{background:transparent;}
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
		$("#mainFrame").show();
			//  初始化页签
			$.fn.initJerichoTab({
                renderTo: '#right', uniqueId: 'jerichotab',
                contentCss: { 'height': $('#right').height() - tabTitleHeight },
                tabs: [], loadOnce: true, tabWidth: 110, titleHeight: tabTitleHeight
            });//
            
            window.open("<%=request.getContextPath() %>/manger/SiteManager","mainFrame");
			// 绑定菜单单击事件
				// 大小宽度调整
				wSizeWidth();
				return false;
			});
			// 初始化点击第一个一级菜单
			$("#menu a.menu:first span").click();
			//  下拉菜单以选项卡方式打开
			$("#userInfo .dropdown-menu a").mouseup(function(){
				return addTab($(this), true);
			});// 
			// 鼠标移动到边界自动弹出左侧菜单
			$("#openClose").mouseover(function(){
				if($(this).hasClass("open")){
					$(this).click();
				}
			});
			// 获取通知数目  
			//function getNotifyNum(){
			//	$.get("/ayy/a/oa/oaNotify/self/count?updateSession=0&t="+new Date().getTime(),function(data){
			//		var num = parseFloat(data);
			//		if (num > 0){
			//			$("#notifyNum,#notifyNum2").show().html("("+num+")");
			//		}else{
			//			$("#notifyNum,#notifyNum2").hide()
			//		}
			//	});
			//}
			//getNotifyNum(); //
			//setInterval(getNotifyNum, 60000); //
		//  添加一个页签
		function addTab($this, refresh){
			$(".jericho_tab").show();
			$("#mainFrame").hide();
			$.fn.jerichoTab.addTab({
                tabFirer: $this,
                title: $this.text(),
                closeable: true,
                data: {
                    dataType: 'iframe',
                    dataLink: $this.attr('href')
                }
            }).loadData(refresh);
			return false;
		}// 
	</script>

</head>
<body>
	
	<div id="main">
		<div id="header" class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="brand"><span id="productName">索骏电力后台管理平台</span></div>
				<ul id="userControl" class="nav pull-right">
					
					<li id="themeSwitch" class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" title="主题切换"><i class="icon-th-large"></i></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="location='/ayy/theme/default?url='+location.href">默认主题</a></li><li><a href="#" onclick="location='/ayy/theme/cerulean?url='+location.href">天蓝主题</a></li><li><a href="#" onclick="location='/ayy/theme/readable?url='+location.href">橙色主题</a></li><li><a href="#" onclick="location='/ayy/theme/united?url='+location.href">红色主题</a></li><li><a href="#" onclick="location='/ayy/theme/flat?url='+location.href">Flat主题</a></li>
							<li><a href="javascript:cookie('tabmode','0');location=location.href">关闭页签模式</a></li>
						</ul>
						<!--[if lte IE 6]><script type="text/javascript">$('#themeSwitch').hide();</script><![endif]-->
					</li>
					<li id="userInfo" class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" title="个人信息">您好, ${userInfo.realName}&nbsp;<span id="notifyNum" class="label label-info hide"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/ayy/a/sys/user/info" target="mainFrame"><i class="icon-user"></i>&nbsp; 个人信息</a></li>
							<li><a href="/ayy/a/sys/user/modifyPwd" target="mainFrame"><i class="icon-lock"></i>&nbsp;  修改密码</a></li>
							
						</ul>
					</li>
					<li><a href="<%=request.getContextPath() %>/admin/loginout" title="退出登录">退出</a></li>
					<li>&nbsp;</li>
				</ul>
				
				<div class="nav-collapse">
					<ul id="menu" class="nav" style="*white-space:nowrap;float:none;">
						
							<c:forEach  var="topMenu" items="${menuList}" >
								<li class="menu  ">
										<a class="menu" href="javascript:"  data-id=${topMenu.funcId}><span>${topMenu.funcName}</span></a>
								</li>
							</c:forEach>
							<!--  
								<li class="menu  active">
										<a class="menu" href="javascript:" data-href="/ayy/a/sys/menu/tree?parentId=a31e6110e57d434685cdb45d5f987002" data-id="a31e6110e57d434685cdb45d5f987002"><span>用户管理</span></a>
								</li>
								<li class="menu ">
										<a class="menu" href="javascript:" data-href="/ayy/a/sys/menu/tree?parentId=718655bcbe814eba952e716136605456" data-id="718655bcbe814eba952e716136605456"><span>系统管理</span></a>
								</li>
							-->
					</ul>
				</div><!--/.nav-collapse -->
			</div>
	    </div>
	    <div class="container-fluid">
			<div id="content" class="row-fluid">
				<div id="left">
							<div class="accordion" id="menu-a31e6110e57d434685cdb45d5f987002">
		<div class="accordion-group">
		
		<c:forEach  var="menu" items="${menuList}" >
		
				<div class="accordion-heading ">
		    	<a class="accordion-toggle " data-toggle="collapse" data-parent="#menu-${ menu.funcId}" data-href="#collapse-${ menu.funcId}" href="#collapse-${ menu.funcId}" title=""><i class="icon-chevron-down"></i>&nbsp;${menu.funcName }</a>
		    </div>
		    <div id="collapse-${ menu.funcId}" class="accordion-body collapse in">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						
						<c:forEach  var="childMenu" items="${menu.funcInfoList}" >
						<li><a data-href=".menu3-${ childMenu.funcId}" href="<%=basePath%>${childMenu.funcDesc}" target="mainFrame" ><i class="icon-circle-arrow-right"></i>&nbsp;${childMenu.funcName }</a>
							<ul class="nav nav-list hide" style="margin:0;padding-right:0;">
							</ul></li>
						</c:forEach>	
							
					</ul>
				</div>
		    </div>
		
		
		</c:forEach>
		<!--
		    <div class="accordion-heading">
		    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#menu-a31e6110e57d434685cdb45d5f987002" data-href="#collapse-38359df71e57412f9d09df34aaa0130a" href="#collapse-38359df71e57412f9d09df34aaa0130a" title=""><i class="icon-chevron-down"></i>&nbsp;后端用户管理</a>
		    </div>
		    <div id="collapse-38359df71e57412f9d09df34aaa0130a" class="accordion-body collapse in">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li><a data-href=".menu3-48b19bddb0854519ad88ce709300f234" href="/ayy/a/app/appUser" target="mainFrame" ><i class="icon-circle-arrow-right"></i>&nbsp;APP用户管理</a>
							<ul class="nav nav-list hide" style="margin:0;padding-right:0;">
							</ul></li>
						<li><a data-href=".menu3-aeb1a2b10cab411582f5927c494a27df" href="/ayy/a/app/appUserMessage" target="mainFrame" ><i class="icon-circle-arrow-right"></i>&nbsp;用户信息管理</a>
							<ul class="nav nav-list hide" style="margin:0;padding-right:0;">
							</ul></li></ul>
				</div>
		    </div>
		    
		    
		    
		    <div class="accordion-heading">
		    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#menu-a31e6110e57d434685cdb45d5f987003" data-href="#collapse-38359df71e57412f9d09df34aaa0130a1" href="#collapse-38359df71e57412f9d09df34aaa0130a1" title=""><i class="icon-chevron-down"></i>&nbsp;前端用户管理</a>
		    </div>
		    <div id="collapse-38359df71e57412f9d09df34aaa0130a1" class="accordion-body collapse in">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li><a data-href=".menu3-48b19bddb0854519ad88ce709300f234" href="/ayy/a/app/appUser" target="mainFrame" ><i class="icon-circle-arrow-right"></i>&nbsp;APP用户管理</a>
							<ul class="nav nav-list hide" style="margin:0;padding-right:0;">
							</ul></li>
						<li><a data-href=".menu3-aeb1a2b10cab411582f5927c494a27df" href="/ayy/a/app/appUserMessage" target="mainFrame" ><i class="icon-circle-arrow-right"></i>&nbsp;用户信息管理</a>
							<ul class="nav nav-list hide" style="margin:0;padding-right:0;">
							</ul></li></ul>
				</div>
		    </div>
		    
		     <div class="accordion-heading">
		    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#menu-a31e6110e57d434685cdb45d5f987004" data-href="#collapse-38359df71e57412f9d09df34aaa0130a2" href="#collapse-38359df71e57412f9d09df34aaa0130a2" title=""><i class="icon-chevron-down"></i>&nbsp;站点管理</a>
		    </div>
		    <div id="collapse-38359df71e57412f9d09df34aaa0130a2" class="accordion-body collapse in">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li><a data-href=".menu3-48b19bddb0854519ad88ce709300f234" href="/ayy/a/app/appUser" target="mainFrame" ><i class="icon-circle-arrow-right"></i>&nbsp;APP用户管理</a>
							<ul class="nav nav-list hide" style="margin:0;padding-right:0;">
							</ul></li>
						<li><a data-href=".menu3-aeb1a2b10cab411582f5927c494a27df" href="/ayy/a/app/appUserMessage" target="mainFrame" ><i class="icon-circle-arrow-right"></i>&nbsp;用户信息管理</a>
							<ul class="nav nav-list hide" style="margin:0;padding-right:0;">
							</ul></li></ul>
				</div>
		    </div>
		    -->
		    
		</div>
	</div>
				</div>
				<div id="openClose" class="close">&nbsp;</div>
				<div id="right">
					<iframe id="mainFrame" name="mainFrame" src="" style="overflow:visible;" scrolling="yes" frameborder="no" width="100%" height="650">
						
	
					<!-- <form id="searchForm" class="breadcrumb form-search" action="/ayy/a/app/appUser/" method="post">
						<ul class="ul-form">
							<li><label>帐号：</label>
									<input id="account" name="account" class="input-medium" type="text" value="" maxlength="64">
								</li>
							<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="button" value="查询"><input id="btnReset" class="btn btn-primary" type="button" value="重置"></li>
							<li class="clearfix"></li>
						</ul>
					</form>
					<div class="fixed-table-body"><div class="fixed-table-loading" style="top: 41px; display: none;">正在努力地加载数据中，请稍候……</div><table id="contentTable" data-height="450" data-toggle="table" data-flat="true" data-url="/ayy/a/app/appUser/jsonList" data-side-pagination="server" data-query-params-type="" data-pagination="true" data-query-params="queryParams" data-click-to-select="true" class="table table-hover" style="margin-top: -40px;">
						<thead><tr><th class="bs-checkbox " style="width: 36px; " data-field="0" tabindex="0"><div class="th-inner "><input name="btSelectAll" type="checkbox"></div><div class="fht-cell"></div></th><th style="" data-field="account" tabindex="0"><div class="th-inner sortable both">帐号</div><div class="fht-cell"></div></th><th style="" data-field="createDate" tabindex="0"><div class="th-inner sortable both">创建时间</div><div class="fht-cell"></div></th><th style="" data-field="updateDate" tabindex="0"><div class="th-inner sortable both">最新登录时间</div><div class="fht-cell"></div></th></tr></thead>
		
						<tbody><tr data-index="0"><td class="bs-checkbox"><input data-index="0" name="btSelectItem" type="checkbox"></td><td style="">13011372360</td><td style="">2016-12-10 15:43:39</td><td style="">2017-01-11 23:38:28</td></tr><tr data-index="1"><td class="bs-checkbox"><input data-index="1" name="btSelectItem" type="checkbox"></td><td style="">18621154766</td><td style="">2016-11-14 16:23:35</td><td style="">2017-01-11 22:46:24</td></tr><tr data-index="2"><td class="bs-checkbox"><input data-index="2" name="btSelectItem" type="checkbox"></td><td style="">18721250875</td><td style="">2016-11-21 21:28:26</td><td style="">2017-01-11 22:34:40</td></tr><tr data-index="3"><td class="bs-checkbox"><input data-index="3" name="btSelectItem" type="checkbox"></td><td style="">18616200903</td><td style="">2016-11-20 22:29:55</td><td style="">2017-01-11 22:19:23</td></tr><tr data-index="4"><td class="bs-checkbox"><input data-index="4" name="btSelectItem" type="checkbox"></td><td style="">18516261522</td><td style="">2016-12-10 00:53:22</td><td style="">2017-01-11 11:03:46</td></tr><tr data-index="5"><td class="bs-checkbox"><input data-index="5" name="btSelectItem" type="checkbox"></td><td style="">18616715753</td><td style="">2016-12-13 14:17:00</td><td style="">2017-01-06 09:44:58</td></tr><tr data-index="6"><td class="bs-checkbox"><input data-index="6" name="btSelectItem" type="checkbox"></td><td style="">18623883346</td><td style="">2016-11-21 10:00:26</td><td style="">2017-01-03 21:31:16</td></tr><tr data-index="7"><td class="bs-checkbox"><input data-index="7" name="btSelectItem" type="checkbox"></td><td style="">13818667928</td><td style="">2016-12-29 00:20:12</td><td style="">2016-12-29 00:20:12</td></tr><tr data-index="8"><td class="bs-checkbox"><input data-index="8" name="btSelectItem" type="checkbox"></td><td style="">15517086696</td><td style="">2016-12-10 14:44:43</td><td style="">2016-12-21 13:59:31</td></tr></tbody></table></div>
					 -->
					</iframe>
				</div>
			</div>
		    <div id="footer" class="row-fluid">
	            Copyright &copy; 2012-2016 索骏电力后台管理平台 - Powered By <a href="http://www.hongjunit.com" target="_blank">鸿钧科技</a> V1.2.6
			</div>
		</div>
	</div>
	<script type="text/javascript"> 
		var leftWidth = 160; // 左侧窗口大小
		var tabTitleHeight = 33; // 页签的高度
		var htmlObj = $("html"), mainObj = $("#main");
		var headerObj = $("#header"), footerObj = $("#footer");
		var frameObj = $("#left, #openClose, #right, #right iframe");
		function wSize(){
			var minHeight = 500, minWidth = 980;
			var strs = getWindowSize().toString().split(",");
			htmlObj.css({"overflow-x":strs[1] < minWidth ? "auto" : "hidden", "overflow-y":strs[0] < minHeight ? "auto" : "hidden"});
			mainObj.css("width",strs[1] < minWidth ? minWidth - 10 : "auto");
			frameObj.height((strs[0] < minHeight ? minHeight : strs[0]) - headerObj.height() - footerObj.height() - (strs[1] < minWidth ? 42 : 28));
			$("#openClose").height($("#openClose").height() - 5);//  
			$(".jericho_tab iframe").height($("#right").height() - tabTitleHeight); // 
			wSizeWidth();
		}
		function wSizeWidth(){
			if (!$("#openClose").is(":hidden")){
				var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
				$("#right").width($("#content").width()- leftWidth - $("#openClose").width() -5);
			}else{
				$("#right").width("100%");
			}
		}//  
		function openCloseClickCallBack(b){
			$.fn.jerichoTab.resize();
		} // 
	</script>
<script src="<%=request.getContextPath() %>/static/common/wsize.min.js" type="text/javascript"></script>

</body>
</html>