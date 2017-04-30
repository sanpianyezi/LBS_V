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
	<title>app用户管理 - Powered By JeeSite</title>
	
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="author" content="http://jeesite.com/"/>
<meta name="renderer" content="webkit"><meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10" />
<meta http-equiv="Expires" content="0"><meta http-equiv="Cache-Control" content="no-cache"><meta http-equiv="Cache-Control" content="no-store">
<script src="<%=request.getContextPath() %>/static/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/static/bootstrap/2.3.1/css_cerulean/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/static/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/static/bootstrap/2.3.1/awesome/font-awesome.min.css" type="text/css" rel="stylesheet" />
<!--[if lte IE 7]><link href="<%=request.getContextPath() %>/static/bootstrap/2.3.1/awesome/font-awesome-ie7.min.css" type="text/css" rel="stylesheet" /><![endif]-->
<!--[if lte IE 6]><link href="<%=request.getContextPath() %>/static/bootstrap/bsie/css/bootstrap-ie6.min.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/static/bootstrap/bsie/js/bootstrap-ie.min.js" type="text/javascript"></script><![endif]-->
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
<script type="text/javascript">var ctx = '<%=request.getContextPath() %>/a', ctxStatic='<%=request.getContextPath() %>/static';</script>		
	<!-- Baidu tongji analytics --><script>var _hmt=_hmt||[];(function(){var hm=document.createElement("script");hm.src="//hm.baidu.com/hm.js?82116c626a8d504a5c0675073362ef6f";var s=document.getElementsByTagName("script")[0];s.parentNode.insertBefore(hm,s);})();</script>
	
	
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			var $table = $('#contentTable');
			$("#create").click(function(){
				$.jBox.open("iframe:<%=request.getContextPath() %>/front/ToAddFrontUser", "新增", 800, 500, { buttons: { '关闭': true} });
			});
			$("#update").click(function(){
				var selected = getIdSelections();
	            if (selected.length!=0){
	            	if(selected.length!=1){
	            		alertx('一次不能编辑多条记录');
	            	}else{
	            		$.jBox.open("iframe:<%=request.getContextPath() %>/front/ToUpdateFrontUser?id="+selected[0], "编辑", 800, 500, { buttons: { '关闭': true} });
	            	}
					
				}else{
					alertx('请选择需要编辑的记录');
				}
			});
			$("#delete").click(function(){
				var selected = getIdSelections();
				if (selected.length!=0){
					confirmx("确认要删除该记录吗？",function () {
					    	$table.bootstrapTable('showLoading');
					    	$.ajax({
							    type: 'POST',
							    data: "userIds="+selected,
							    url: '<%=request.getContextPath() %>/front/deleteFrontUser',
							    dataType: 'json',
							    success: function(data){
							    	if(data.success){
							    		successx("删除成功!");
							    		//$table.bootstrapTable('remove', {field:'id',values:selected});
							    		$("#btnSubmit").click();
							    	}else{
					    				alertx("删除失败！");
						    		}
						    	}
							});
					});
				}else{
					alertx('请选择需要删除的记录');
				}
			});
			
			
			$("#imagesModify").click(function(){
				var selected = getIdSelections();
	            if (selected.length!=0){
	            if(selected.length>1){
	            	alertx('不可一次编辑多条记录');
	            	return false;
	            }
					$.jBox.open("iframe:<%=request.getContextPath() %>/front/ToUpdateUserImages?id="+selected[0], "站点图片管理", 800, 500, { buttons: { '关闭': true} });
				}else{
					alertx('请选择需要编辑的记录');
				}
			});
			
			
			
			$("#initPwd").click(function(){
				var selected = getIdSelections();
				if (selected.length!=0){
					confirmx("确认要初始化该密码吗？",function () {
					    	$table.bootstrapTable('showLoading');
					    	$.ajax({
							    type: 'POST',
							    data: "ids="+selected,
							    url: '/ayy/a/app/appUser/initpwd',
							    dataType: 'json',
							    success: function(data){
							    	if(data.success){
							    		successx(data.message);
							    		//$table.bootstrapTable('remove', {field:'id',values:selected});
							    		$("#btnSubmit").click();
							    	}else{
					    				alertx("初始化失败！");
						    		}
						    	}
							});
					});
				}else{
					alertx('请选择需要初始化的记录');
				}
			});
			
			$("#btnReset").click(function(){
				$("input[class^='input-medium']").attr("value","");
				$("select").val("");
				$("select").change();
			});
			$("#btnSubmit").click(function () {
			    $table.bootstrapTable('removeAll');
				$table.bootstrapTable('refresh');
			});
			function getIdSelections() {
		        return $.map($table.bootstrapTable('getSelections'), function (row) {
		            return row.id
		        });
		    };
		    window.onload = function() { 
				$table.bootstrapTable('resetView');//防止jbox页面打开，table显示不正常
			};
		});
		function queryParams(params) {
			$.each($('#searchForm').serializeArray(),function(i,item){
				params[item.name] = item.value;
			})
		    return params;
		}
		
		function newsPoersformatter(value,row,index){
			if("01" == value){
				return "采集员";
			}else if("00" == value){
				return "普通用户";
			}else if("02" == value){
				return "管理员";
			}else{
				return "未知";
			}
			
		}
		
		function newsStateformatter(value,row,index){
			if("C" == value){
				return "关闭";
			}else if("N" == value){
				return "正常";
			}else{
				return "未知";
			}
		}
		
		
		function newsParentIdformatter(value,row,index){
			//return "guanlu";
			//var result;
			//if (null == value || "" == value) {
			//	result = "未知";
			//}else{
				$.ajax({
				    type: 'POST',
				    data: {parentId:value},
				    url: '<%=request.getContextPath() %>/front/ParentIdformatter',
				    async:false,
				   // dataType: 'json',
				    success: function(data){
				    	if(data.code=="success"){
				    		//alert(data.userName);
				    		return "guanlu";
				    		
				    	}else{
				    		//result = "未知";
			    		}
			    	}
				});
				
			//}
			//return result;
			
		}
		
		
		function newsOperatorformatter(value,row,index){
		var obj = value.split("|");
			var userId = obj[0];
			var powers = obj[1];
			if("00" == powers){
				return "<a href=\"javascript:peizhi('"+value+"')\">配置站点</a>";
			}else{
				
				return "";
			}
			
		
		
		}
		
		function peizhi(temp){
			var obj = temp.split("|");
			var userId = obj[0];
			var powers = obj[1];
			if("00" == powers){
			window.open("<%=request.getContextPath() %>/front/SetSiteForUser?userId="+userId);
			//	$.jBox.open("iframe:<%=request.getContextPath() %>/front/SetSiteForUser?userId="+userId, "配置用户对应站点", 850, 550, { buttons: { '关闭': true} });
			}else{
				alert("只有普通用户可以配置！");
				return false;
			}
		}
		
		function newsImageformatter(value,row,index){
			if (null == value || "" == value) {
				return "<img src='<%=request.getContextPath() %>/images/11.png' width='100' height='100'/>";
			}
			return "<img src='<%=request.getContextPath() %>/images/upload/"+value+"' width='100' height='100'/>";
		}
	</script>
<style>
.jericho_tab {
    width: 100%;
}

.tab_pages {
    width: 100%;
    float: left;
    clear: both;
    background: url(../images/tabline.gif) left bottom repeat-x;
}

.tabs {
    height: 26px;
    overflow: hidden;
    display: block;
    position: relative;
    float: left;
}

.tab_selected {
    cursor: pointer;
}

tab_left {
    background: url(../images/jerichotab.gif) no-repeat left -48px;
}
</style>
</head>
<body>
<div id="jerichotab" class="jericho_tab">
	<div class="tab_pages">
		<div class="tabs" style="width: 789px;">
			<ul style="width: 1430px; left: 0px;">
				<li name="&nbsp;前端用户配置" class="jericho_tabs tab_selected" style="width: 110px; opacity: 1; background-color: rgb(255, 255, 255);" id="jerichotab_0" datatype="iframe" datalink="/ayy/a/app/appUser">
					<div class="tab_left" style="width:105px">
						<div class="tab_text" title="&nbsp;APP用户管理" style="width:90px;color:#54b4eb">&nbsp;前端用户配置</div>  
						<div class="tab_close">
							<a href="javascript:" title="关闭">&nbsp;</a>
						</div>
					</div>
					<div class="tab_right">&nbsp;</div>
				</li>
				</ul>
			</div>
	</div>
	
	<div class="btn-toolbar" role="toolbar">
		<div class="btn-group" role="group">
		  	 <button id="create" type="button" class="btn btn-primary">新增</button>&nbsp;
		  	<button id="update" type="button" class="btn btn-success">编辑</button>&nbsp;
		  	 <button id="delete" type="button" class="btn btn-danger">删除</button> &nbsp;
		  	 <button id="imagesModify" type="button" class="btn btn-primary">图片管理</button> &nbsp;
		</div>
	</div>
	
	<form id="searchForm" class="breadcrumb form-search" action="/ayy/a/app/appUser/" method="post">
		<ul class="ul-form">
			<li><label>用户名：</label>
				<input id="userName" name="userName" class="input-medium" type="text" value="" maxlength="64"/>
			</li>
			<li><label>真实姓名：</label>
				<input id="realName" name="realName" class="input-medium" type="text" value="" maxlength="64"/>
			</li>
			<li><label>手机号：</label>
				<input id="telNo" name="telNo" class="input-medium" type="text" value="" maxlength="64"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="button" value="查询"/><input id="btnReset" class="btn btn-primary" type="button" value="重置"/></li>
			<li class="clearfix"></li>
		</ul>
	</form>
</div>
<script type="text/javascript">top.$.jBox.closeTip();</script>

	<table 
		id="contentTable" 
		data-height="450"
		data-toggle="table"
		data-flat="true"
		data-url="<%=request.getContextPath() %>/front/FrontjsonList"
		data-side-pagination="server"
		data-query-params-type=""
		data-pagination="true"
		data-query-params="queryParams"
		data-click-to-select="true">
		<thead>
			<tr>
				<th data-checkbox="true"></th>
				<th data-field="id" data-visible="false">id</th>
				<th data-field="userName" data-sortable="true">用户名</th>
				<th data-field="passWord" data-sortable="true">密码</th>
				<th data-field="realName" data-sortable="true">真实姓名</th>
				<th data-field="imagePath" data-sortable="true" data-formatter="newsImageformatter" >用户头像</th>
				<th data-field="telNo" data-sortable="true">手机号</th>
				<th data-field="powers" data-sortable="true" data-formatter="newsPoersformatter" >类别</th>
				<th data-field="state" data-sortable="true" data-formatter="newsStateformatter"  >状态</th>
				<th data-field="regTime" data-sortable="true">注册时间</th>
				<th data-field="logNtime" data-sortable="true">最后登录时间</th>
				<th data-field="email" data-sortable="true">邮箱</th>
				<th data-field="rsvd1" data-sortable="true"    >组别</th>
				<th data-field="rsvd2" data-sortable="true" data-formatter="newsOperatorformatter"   >操作</th>
			</tr>
		</thead>
	</table>

	<script type="text/javascript">//<!-- 无框架时，左上角显示菜单图标按钮。
		if(!(self.frameElement && self.frameElement.tagName=="IFRAME")){
			$("body").prepend("<i id=\"btnMenu\" class=\"icon-th-list\" style=\"cursor:pointer;float:right;margin:10px;\"></i><div id=\"menuContent\"></div>");
			$("#btnMenu").click(function(){
				top.$.jBox('get:/ayy/a/sys/menu/treeselect;JSESSIONID=18b23410a80b4158bb737ded9d52f64f', {title:'选择菜单', buttons:{'关闭':true}, width:300, height: 350, top:10});
				//if ($("#menuContent").html()==""){$.get("/ayy/a/sys/menu/treeselect", function(data){$("#menuContent").html(data);});}else{$("#menuContent").toggle(100);}
			});
		}//-->
	</script>
</body>
</html>
