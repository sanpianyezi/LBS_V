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
	<title>用户站点配置</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" /><meta name="author" content="http://jeesite.com/"/>
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
			
			
			$("#selectBangding").click(function(){
				var selected = getIdSelections();
				var userId = document.getElementById("userId").value;
				if (selected.length!=0){
					confirmx("确认要批量绑定选定记录吗？",function () {
					    	$table.bootstrapTable('showLoading');
					    	$.ajax({
							    type: 'POST',
							    data: "siteIds="+selected+"&userId="+userId,
							    url: '<%=request.getContextPath() %>/front/selectBangding',
							    dataType: 'json',
							    success: function(data){
							    	if(data.success){
							    		successx("批量绑定成功!");
							    		//$table.bootstrapTable('remove', {field:'id',values:selected});
							    		$("#btnSubmit").click();
							    	}else{
					    				alertx("绑定失败！");
						    		}
						    	}
							});
					});
				}else{
					alertx('请选择需要绑定的记录');
				}
			});
			
			$("#selectJiebang").click(function(){
				var selected = getIdSelections();
				var userId = document.getElementById("userId").value;
				if (selected.length!=0){
					confirmx("确认要批量解绑选定记录吗？",function () {
					    	$table.bootstrapTable('showLoading');
					    	$.ajax({
							    type: 'POST',
							    data: "siteIds="+selected+"&userId="+userId,
							    url: '<%=request.getContextPath() %>/front/selectJiebang',
							    dataType: 'json',
							    success: function(data){
							    	if(data.success){
							    		successx("批量解绑成功!");
							    		//$table.bootstrapTable('remove', {field:'id',values:selected});
							    		$("#btnSubmit").click();
							    	}else{
					    				alertx("解绑失败！");
						    		}
						    	}
							});
					});
				}else{
					alertx('请选择需要解绑的记录');
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
			
			
			
			$("#btnBangding").click(function(){
				var siteCode = document.getElementById("siteCode").value;
				var siteName = document.getElementById("siteName").value;
				var siteType = document.getElementById("siteType").value;
				var siteAddr = document.getElementById("siteAddr").value;
				var updateUserName = document.getElementById("updateUserName").value;
				var belongArea = document.getElementById("belongArea").value;
				var userId = document.getElementById("userId").value;
				confirmx("确认要按查询条件批量绑定吗？",function () {
					$table.bootstrapTable('showLoading');
					$.ajax({
								    type: 'POST',
								    data: {siteCode:siteCode,siteName:siteName,siteType:siteType,siteAddr:siteAddr,updateUserName:updateUserName,belongArea:belongArea,userId:userId},
								    url: '<%=request.getContextPath() %>/front/btnBangding',
								    dataType: 'json',
								    success: function(data){
								    	if(data.code=="success"){
								    		successx("按查询条件批量绑定成功");
								    		//$table.bootstrapTable('remove', {field:'id',values:selected});
								    		$("#btnSubmit").click();
								    	}else{
						    				alertx("按查询条件批量绑定失败！");
							    		}
							    	}
								});
				});
			});
			
			
			
			
			$("#btnJiebang").click(function(){
				var siteCode = document.getElementById("siteCode").value;
				var siteName = document.getElementById("siteName").value;
				var siteType = document.getElementById("siteType").value;
				var siteAddr = document.getElementById("siteAddr").value;
				var updateUserName = document.getElementById("updateUserName").value;
				var belongArea = document.getElementById("belongArea").value;
				var userId = document.getElementById("userId").value;
				confirmx("确认要按查询条件批量解绑吗？",function () {
					$table.bootstrapTable('showLoading');
					$.ajax({
								    type: 'POST',
								    data: {siteCode:siteCode,siteName:siteName,siteType:siteType,siteAddr:siteAddr,updateUserName:updateUserName,belongArea:belongArea,userId:userId},
								    url: '<%=request.getContextPath() %>/front/btnJiebang',
								    dataType: 'json',
								    success: function(data){
								    	if(data.code=="success"){
								    		successx("按查询条件批量解绑成功");
								    		//$table.bootstrapTable('remove', {field:'id',values:selected});
								    		$("#btnSubmit").click();
								    	}else{
						    				alertx("按查询条件批量解绑失败！");
							    		}
							    	}
								});
				});
			});
			
			
		});
		function queryParams(params) {
			$.each($('#searchForm').serializeArray(),function(i,item){
				params[item.name] = item.value;
			})
		    return params;
		}
		
		
		
		
		function newsImageformatter(value,row,index){
			if (null == value || "" == value) {
				return "<img src='<%=request.getContextPath() %>/images/11.png' width='100' height='50'/>";
			}
			return "<img id='T"+row.id+"' onclick='closeT("+row.id+")' style='display:none'   src='<%=request.getContextPath() %>/images/upload/"+value.split(",")[0]+"' width='100' height='100'/><img id='TT"+row.id+"' onclick='closeTT("+row.id+")'  src='<%=request.getContextPath() %>/images/1.png' width='100' height='50'/>";
		}
		
		
		function closeT(id){
			var imageId1 = "T"+id;
			var imageId2 = "TT"+id;
			document.getElementById(imageId1).style.display="none";
			document.getElementById(imageId2).style.display="";
		}
		function closeTT(id){
			var imageId1 = "T"+id;
			var imageId2 = "TT"+id;
			document.getElementById(imageId1).style.display="";
			document.getElementById(imageId2).style.display="none";
		}
		
		
		
		
		
		
		function newsOperatorformatter(value,row,index){
		
				var obj = value.split("|");
				var userId = obj[0];
				var siteId = obj[1];
				var state = obj[2];
			if ('N'== state) {
				return "<a href=\"javascript:jiebang('"+userId+"','"+siteId+"')\">解绑站点</a>";
			}else if('C'== state){
				return "<a href=\"javascript:bangding('"+userId+"','"+siteId+"')\">绑定站点</a>";
			
			}
			return null;
		}
		
		
		function jiebang(userId , siteId){
			$.ajax({
							    type: 'POST',
							    data: {userId:userId,siteId:siteId},
							    url: '<%=request.getContextPath() %>/front/jiebang',
							    dataType: 'json',
							    success: function(data){
							    	if(data.code=="success"){
							    		successx("解绑成功");
							    		//$table.bootstrapTable('remove', {field:'id',values:selected});
							    		$("#btnSubmit").click();
							    	}else{
					    				alertx("解绑失败！");
						    		}
						    	}
							});
		
		}
		
		
		function bangding(userId , siteId){
			$.ajax({
							    type: 'POST',
							    data: {userId:userId,siteId:siteId},
							    url: '<%=request.getContextPath() %>/front/bangding',
							    dataType: 'json',
							    success: function(data){
							    	if(data.code=="success"){
							    		successx("绑定成功");
							    		//$table.bootstrapTable('remove', {field:'id',values:selected});
							    		$("#btnSubmit").click();
							    	}else{
					    				alertx("绑定失败！");
						    		}
						    	}
							});
		
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
				<li name="&nbsp;后端站点配置" class="jericho_tabs tab_selected" style="width: 110px; opacity: 1; background-color: rgb(255, 255, 255);" id="jerichotab_0" datatype="iframe" datalink="/ayy/a/app/appUser">
					<div class="tab_left" style="width:105px">
						<div class="tab_text" title="&nbsp;APP用户管理" style="width:90px;color:#54b4eb">&nbsp;站点管理配置</div>  
						<div class="tab_close">
							<a href="javascript:" title="关闭">&nbsp;</a>
						</div>
					</div>
					<div class="tab_right">&nbsp;</div>
				</li>
				</ul>
			</div>
	</div>
	<!--  -->
	<div class="btn-toolbar" role="toolbar">
		<div class="btn-group" role="group">
		  	 <button id="selectBangding" type="button" class="btn btn-primary">多选批量绑定</button>&nbsp;
		  	<button id="selectJiebang" type="button" class="btn btn-success">多选批量解绑</button>&nbsp;
			 
		</div>
	</div>
	
	
	<form id="searchForm" class="breadcrumb form-search" action="/ayy/a/app/appUser/" method="post">
		<ul class="ul-form">
			<li><label>是否绑定：</label>
				<select id="bdflag" name="bdflag" class="input-medium">
					<option value="ALL" selected="selected">全部</option>
					<option value="1" >已绑定</option>
					<option value="0" >未绑定</option>
				</select>
			</li>
			<li><label>运行编号：</label>
				<input id="siteCode" name="siteCode" class="input-medium" type="text" value="" maxlength="64"/>
			</li>
			<li><label>站点名称：</label>
				<input id="siteName" name="siteName" class="input-medium" type="text" value="" maxlength="64"/>
			</li>
			<li><label>站点类型：</label>
				<input id="siteType" name="siteType" class="input-medium" type="text" value="" maxlength="64"/>
			</li>
			<li><label>站点地址：</label>
				<input id="siteAddr" name="siteAddr" class="input-medium" type="text" value="" maxlength="64"/>
			</li>
			<li><label>上传用户：</label>
				<input id="updateUserName" name="updateUserName" class="input-medium" type="text" value="" maxlength="64"/>
			</li>
			<li><label>所属区域：</label>
			<input id="belongArea" name="belongArea" class="input-medium" type="text"  list="belongAreaList"  maxlength="64"/>
				<datalist id="belongAreaList">
				<c:forEach var="area" items="${belongAreaList}">
			 		<option value="${area}">${area}</option>
			 	</c:forEach>
			</datalist>
			<!-- 
			<input id="belongArea" name="belongArea" class="input-medium" type="text" value="" maxlength="64"/>
			 
			<select id = "belongArea" name="belongArea" class="input-medium">
			 	<option value="">请选择</option>
			 	<option value="黄浦区">黄浦区</option>
			 	<option value="卢湾区">卢湾区</option>
			 	<option value="徐汇区">徐汇区</option>
			 	<option value="长宁区">长宁区</option>
			 	<option value="静安区">静安区</option>
			 	<option value="普陀区">普陀区</option>
			 	<option value="闸北区">闸北区</option>
			 	<option value="虹口区">虹口区</option>
			 	<option value="杨浦区">杨浦区</option>
			 	<option value="闵行区">闵行区</option>
			 	<option value="宝山区">宝山区</option>
			 	<option value="嘉定区">嘉定区</option>
			 	<option value="浦东新区">浦东新区</option>
			 	<option value="金山区">金山区</option>
			 	<option value="松江区">松江区</option>
			 	<option value="青浦区">青浦区</option>
			 	<option value="南汇区">南汇区</option>
			 	<option value="奉贤区">奉贤区</option>
			 	<option value="崇明县">崇明县</option>
			 </select>
			 -->
			 </li>
			<input id="userId" name="userId" class="input-medium" type="hidden" value="${userId }" maxlength="64"/>
			
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="button" value="查询"/><input id="btnReset" class="btn btn-primary" type="button" value="重置"/><input id="btnBangding" class="btn btn-primary" type="button" value="按条件批量绑定"/>  <input id="btnJiebang" class="btn btn-primary" type="button" value="按条件批量解绑"/></li>
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
		data-url="<%=request.getContextPath() %>/front/UserSiteSitejsonList"
		data-side-pagination="server"
		data-query-params-type=""
		data-pagination="true"
		data-query-params="queryParams"
		data-click-to-select="true">
		<thead>
			<tr>
				<th data-checkbox="true"></th>
				<th data-field="id" data-visible="false">id</th>
				<th data-field="operator" data-sortable="true" data-formatter="newsOperatorformatter" >操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th data-field="belongArea" data-sortable="true"> 所属区域</th>
				<th data-field="siteCode" data-sortable="true"  >运行编号</th>
				<th data-field="siteType" data-sortable="true">站点类型</th>
				<th data-field="imagePath" data-sortable="true" data-formatter="newsImageformatter">站点图片
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th data-field="siteName" data-sortable="true">&nbsp;&nbsp;&nbsp;变电站名称&nbsp;&nbsp;&nbsp;</th>
				<th data-field="serviceGroup" data-sortable="true">维护班组</th>
				<th data-field="voltageGrade" data-sortable="true">电压等级</th>
				<th data-field="workTime" data-sortable="true">投运日期</th>
				<th data-field="isIntelligent" data-sortable="true">是否智能变电站</th>
				<th data-field="isHub" data-sortable="true">是否枢纽</th>
				<th data-field="siteLevel" data-sortable="true">变电站重要级别</th>
				<th data-field="dutyType" data-sortable="true">值班方式</th>
				<th data-field="agentService" data-sortable="true">是否代维</th>
				<th data-field="cablingType" data-sortable="true">布置方式</th>
				<th data-field="contaminationLevel" data-sortable="true">污秽等级</th>
				<th data-field="siteAddr" data-sortable="true"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;站&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th data-field="areaCovered" data-sortable="true">占地面积(m2)</th>
				<th data-field="buildingArea" data-sortable="true">建筑面积(m2)</th>
				<th data-field="regionFeatures" data-sortable="true">地区特征</th>
				<th data-field="contactTel" data-sortable="true">联系电话</th>
				
				<th data-field="shortName" data-sortable="true">&nbsp;&nbsp;&nbsp;变电站简称&nbsp;&nbsp;&nbsp;</th>
				<th data-field="equipmentOwner" data-sortable="true">设备主人</th>
				<th data-field="remark" data-sortable="true">备注</th>
				<th data-field="totalCapacity" data-sortable="true"> 配变总容量(kVA)</th>
				<th data-field="equipmentNum" data-sortable="true">配变台数</th>
				<th data-field="importantDegree" data-sortable="true">重要程度</th>
				<th data-field="isUnderground" data-sortable="true">是否地下站</th>
				<th data-field="isIndependent" data-sortable="true"> 是否独立建筑物</th>
				                      
				<th data-field="preventionType" data-sortable="true"> 防误方式</th>
				<th data-field="hasRingNetwork" data-sortable="true"> 是否具有环网</th>
				<th data-field="compensateCapacity" data-sortable="true"> 无功补偿容量(kVar)</th>
				<th data-field="equipmentCode" data-sortable="true"> 设备类型编码</th>
				<th data-field="state" data-sortable="true"> 状态</th>
				<th data-field="longitudePoint" data-sortable="true"> 经度</th>
				<th data-field="latitudePoint" data-sortable="true"> 纬度</th>
				
				<th data-field="createTime" data-sortable="true">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 创建时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th data-field="updateTime" data-sortable="true"> 上传者</th>
				                           
				
				
			</tr>
		</thead>
		<!-- 
		<tbody>
		<c:forEach var="userInfo" items="${userList}">
			<tr>
				<td data-checkbox="true"></td>
				<td data-field="id" data-visible="false">${userInfo.id}</td>
				<td data-field="userName" data-sortable="true">${userInfo.userName}</td>
				<td data-field="parentId" data-sortable="true">${userInfo.parentId}</td>
				<td data-field="telNo" data-sortable="true">${userInfo.telNo}</td>
			</tr>
			</c:forEach>
		</tbody>
		 -->
	</table>

</body>
</html>
