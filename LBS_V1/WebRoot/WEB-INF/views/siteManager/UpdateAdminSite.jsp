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
	<title>用户详细信息管理 - Powered By JeeSite</title>
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
	<link href="<%=request.getContextPath() %>/static/fileinput/css/fileinput.css" media="all" type="text/css" rel="stylesheet" />
	<script src="<%=request.getContextPath() %>/static/fileinput/js/fileinput.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath() %>/static/fileinput/js/fileinput_locale_zh.js" type="text/javascript"></script>
	<script type="text/javascript">
	
	function loadCheck() {
		
		var marriageStatus = $('#marriageStatus').val();
        if (null != marriageStatus && "" != marriageStatus && "2" == marriageStatus) {//已婚
        	$('#marriedType').attr("disabled",false);
        }
        
		/* var gynecopathyListArrChk = $("input[name='gynecopathyList']:checked");
    	var gynecopathyListIndex = 0;
        $(gynecopathyListArrChk).each(function(){
           	if (this.value == "20") {
           		gynecopathyListIndex = 1;
           	}
       });
        if (gynecopathyListIndex == 1) {//妇科疾病-其他
       		$('#gynecopathyOther').attr("disabled",false);
       	}
        
        var familyMedicalHistoryListArrChk = $("input[name='familyMedicalHistoryList']:checked");
    	var familyMedicalHistoryListIndex = 0;
        $(familyMedicalHistoryListArrChk).each(function(){
           	if (this.value == "26") {
           		familyMedicalHistoryListIndex = 1;
           	}
       });
        if (familyMedicalHistoryListIndex == 1) {//家族病史-其他
       		$('#familyMedicalHistoryOther').attr("disabled",false);
       	} */
	}
		$(document).ready(function() {
			//$("#name").focus();
			loadCheck();
			$("#inputForm").validate({
				submitHandler:function(form){
					$('#btnSubmit').attr({"disabled":"disabled"});
					$("#marriedType").removeAttr("disabled"); //去除disabled
					$("#gynecopathyOther").removeAttr("disabled"); 
					$("#familyMedicalHistoryOther").removeAttr("disabled"); 
					loading('正在提交，请稍等...');
					$(form).ajaxSubmit(function(data){
				    	closeTip();
				    	if(data.success){
				    		$.jBox.prompt('保存成功！', '提示', 'success', { closed: function () {
				    				$('#btnSubmit', window.parent.document).click();
				    				window.parent.window.jBox.close();
								} 
				    		});
				    	}else{
				    		alertx(data.message);
				    		$("#btnSubmit").removeAttr("disabled");
				    	}
				    }); 
			    },
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			$("#btnCancel").click(function(){
				window.parent.window.jBox.close();
			});
			$("#_newsImage").fileinput({
				showUpload: false,
				showCaption: false,
				browseClass: "btn btn-primary btn-lg",
				'allowedFileExtensions' : ['jpg', 'png'],
		        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
			});
		});
		
		$(function(){
            $('#marriageStatus').change(function(e){
            	var marriageStatus = $('#marriageStatus').val();
                if (null != marriageStatus && "" != marriageStatus && "2" == marriageStatus) {//已婚
                	$('#marriedType').attr("disabled",false);
                } else {
                	//$('#marriedType').empty();
                	///$("#marriedType").get(0).selectedIndex=0;
                	$("#marriedType").val("");
                	$("#s2id_marriedType").find(".select2-chosen").html("");
                	$('#marriedType').attr("disabled",true);
                }
            })
        });
		
		/* $(function(){
            $("[name='gynecopathyList']").change(function(e){
            	var arrChk = $("input[name='gynecopathyList']:checked");
            	var index = 0;
                $(arrChk).each(function(){
                   	if (this.value == "20") {
                   		index = 1;
                   	}
               });
                if (index == 1) {//妇科疾病-其他
               		$('#gynecopathyOther').attr("disabled",false);
               	} else {
                   	$("#gynecopathyOther").val("");
                   	$('#gynecopathyOther').attr("disabled",true);
               }
            })
        });
		
		$(function(){
            $("[name='familyMedicalHistoryList']").change(function(e){
            	var arrChk = $("input[name='familyMedicalHistoryList']:checked");
            	var index = 0;
                $(arrChk).each(function(){
                   	if (this.value == "26") {
                   		index = 1;
                   	}
               });
                if (index == 1) {//家族病史-其他
               		$('#familyMedicalHistoryOther').attr("disabled",false);
               	} else {
                   	$("#familyMedicalHistoryOther").val("");
                   	$('#familyMedicalHistoryOther').attr("disabled",true);
               }
            })
        }); */
		
	</script>

</head>
<body>
	
	<form id="inputForm" class="form-horizontal" action="<%=request.getContextPath() %>/manger/SaveAdminSite" method="post" enctype="multipart/form-data" novalidate="novalidate">
		<input id="id" name="id" class="input-xlarge " type="hidden" value=${siteInfo.id} maxlength="100">














<script type="text/javascript">top.$.jBox.closeTip();</script>
		
		
		<div class="control-group">
			<label class="control-label">运行编号：</label>
			<div class="controls">
				<input id="siteCode" name="siteCode" class="input-xlarge " type="text" value="${siteInfo.siteCode}" maxlength="100" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">站点类别：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
				<select id="siteType" name="siteType" class="input-xlarge " tabindex="-1" title="" >
					<option value=""></option>
					<option value="开关站"  <c:if test="${siteInfo.siteType =='开关站'}">selected</c:if>   >开关站</option>
					<option value="配电室" <c:if test="${siteInfo.siteType =='配电室'}">selected</c:if>  >配电室</option>
					<option value="变电站" <c:if test="${siteInfo.siteType =='变电站'}">selected</c:if> >变电站</option>
				</select>
			</div>
		</div>
		</div>
		<div class="control-group">
			<label class="control-label">变电站名称：</label>
			<div class="controls">
				<input id="siteName" name="siteName" class="input-xlarge " type="text" value="${siteInfo.siteName}" maxlength="100">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">维护班组：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
				<select id="serviceGroup" name="serviceGroup" class="input-xlarge " tabindex="-1" title="" >
					<option value=""></option>
					<option value="变电中心一站" <c:if test="${siteInfo.serviceGroup == '变电中心一站'}">selected</c:if> >变电中心一站</option>
					<option value="配电运维组" <c:if test="${siteInfo.serviceGroup == '配电运维组'}">selected</c:if> >配电运维组</option>
				</select>
			</div>
		</div>
		</div>
		<div class="control-group">
			<label class="control-label">电压等级：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
				<select id="voltageGrade" name="voltageGrade" class="input-xlarge " tabindex="-1" title="" >
						<option value=""></option>
						<option value="10KV" <c:if test="${siteInfo.voltageGrade == '10KV'}">selected</c:if>  >10KV</option>
						<option value="35KV" <c:if test="${siteInfo.voltageGrade == '35KV'}">selected</c:if> >35KV</option>
						<option value="110KV" <c:if test="${siteInfo.voltageGrade == '110KV'}">selected</c:if> >110KV</option>
					</select>
			</div>
		</div>
		</div>
		<div class="control-group">
			<label class="control-label">投运日期：</label>
			<div class="controls">
				<input id="workTime" name="workTime" class="input-xlarge " type="date" value="${siteInfo.workTime}" maxlength="128">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否智能变电站：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="isIntelligent" name="isIntelligent" class="input-xlarge " tabindex="-1" title="" >
						
						<option value="" ></option>
						<option value="是" <c:if test="${siteInfo.isIntelligent == '是'}">selected</c:if> >是</option>
						<option value="否" <c:if test="${siteInfo.isIntelligent == '否'}">selected</c:if> >否</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否枢纽：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="isHub" name="isHub" class="input-xlarge " tabindex="-1" title="" >
						
						<option value=""  ></option>
						<option value="是" <c:if test="${siteInfo.isHub == '是'}">selected</c:if> >是</option>
						<option value="否" <c:if test="${siteInfo.isHub == '否'}">selected</c:if> >否</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">变电站重要级别：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="siteLevel" name="siteLevel" class="input-xlarge " tabindex="-1" title="" >
						
						<option value=""  ></option>
						<option value="二类变电站" <c:if test="${siteInfo.siteLevel == '二类变电站'}">selected</c:if> >二类变电站</option>
						<option value="三类变电站" <c:if test="${siteInfo.siteLevel == '三类变电站'}">selected</c:if> >三类变电站</option>
						<option value="四类变电站" <c:if test="${siteInfo.siteLevel == '四类变电站'}">selected</c:if> >四类变电站</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">值班方式：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="dutyType" name="dutyType" class="input-xlarge " tabindex="-1" title="" >
						
						<option value=""  ></option>
						<option value="无人值班"  <c:if test="${siteInfo.dutyType == '无人值班'}">selected</c:if> >无人值班</option>
						<option value="有人值班"  <c:if test="${siteInfo.dutyType == '有人值班'}">selected</c:if> >有人值班</option>
						
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否代维：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="agentService" name="agentService" class="input-xlarge " tabindex="-1" title="" >
						<option value=""></option>
						<option value="" ></option>
						<option value="是" <c:if test="${siteInfo.agentService == '是'}">selected</c:if> >是</option>
						<option value="否" <c:if test="${siteInfo.agentService == '否'}">selected</c:if> >否</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">布置方式：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="cablingType" name="cablingType" class="input-xlarge " tabindex="-1" title="" >
						
						<option value=""  ></option>
						<option value="常规"  <c:if test="${siteInfo.cablingType == '常规'}">selected</c:if> >常规</option>
						<option value="地下" <c:if test="${siteInfo.cablingType == '地下'}">selected</c:if> >地下</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">污秽等级：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="contaminationLevel" name="contaminationLevel" class="input-xlarge " tabindex="-1" title="" >
						
						<option value=""  ></option>
						<option value="c级" <c:if test="${siteInfo.contaminationLevel == 'c级'}">selected</c:if> >c级</option>
						<option value="e级" <c:if test="${siteInfo.contaminationLevel == 'e级'}">selected</c:if> >e级</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">站址：</label>
			<div class="controls">
				<input id="siteAddr" name="siteAddr" class="input-xlarge " type="text"  maxlength="100" value="${siteInfo.siteAddr}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">占地面积(m2)：</label>
			<div class="controls">
				<input id="areaCovered" name="areaCovered" class="input-xlarge " type="text"  maxlength="100" value="${siteInfo.areaCovered}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建筑面积(m2)：</label>
			<div class="controls">
				<input id="buildingArea" name="buildingArea" class="input-xlarge " type="text"  maxlength="100" value="${siteInfo.buildingArea}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地区特征：</label>
			<div class="controls">
				<input id="regionFeatures" name="regionFeatures" class="input-xlarge " type="text"  maxlength="100" value="${siteInfo.regionFeatures}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系电话：</label>
			<div class="controls">
				<input id="contactTel" name="contactTel" class="input-xlarge " type="text"  maxlength="100"  value="${siteInfo.contactTel}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">变电站简称：</label>
			<div class="controls">
				<input id="shortName" name="shortName" class="input-xlarge " type="text"  maxlength="100"  value="${siteInfo.shortName}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">设备主人：</label>
			<div class="controls">
				<input id="equipmentOwner" name="equipmentOwner" class="input-xlarge " type="text"  maxlength="100" value="${siteInfo.equipmentOwner}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<input id="remark" name="remark" class="input-xlarge " type="text"  maxlength="100" value="${siteInfo.remark}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">配变总容量(kVA)：</label>
			<div class="controls">
				<input id="totalCapacity" name="totalCapacity" class="input-xlarge " type="text"  maxlength="100" value="${siteInfo.totalCapacity}"  >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">配变台数：</label>
			<div class="controls">
				<input id="equipmentNum" name="equipmentNum" class="input-xlarge " type="text"  maxlength="100" value="${siteInfo.equipmentNum}"  >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">重要程度：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="importantDegree" name="importantDegree" class="input-xlarge " tabindex="-1" title="" >
						<option value=""></option>
						
						<option value="一般" <c:if test="${siteInfo.importantDegree == '一般'}">selected</c:if>  >一般</option>
						<option value="重要" <c:if test="${siteInfo.importantDegree == '重要'}">selected</c:if> >重要</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否地下站：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="isUnderground" name="isUnderground" class="input-xlarge " tabindex="-1" title="" >
						<option value=""></option>
						<option value="" selected="selected" ></option>
						<option value="是" <c:if test="${siteInfo.isUnderground == '是'}">selected</c:if> >是</option>
						<option value="否" <c:if test="${siteInfo.isUnderground == '否'}">selected</c:if> >否</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否独立建筑物：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="isIndependent" name="isIndependent" class="input-xlarge " tabindex="-1" title="" >
						<option value=""></option>
						<option value="" selected="selected" ></option>
						<option value="是" <c:if test="${siteInfo.isIndependent == '是'}">selected</c:if> >是</option>
						<option value="否" <c:if test="${siteInfo.isIndependent == '否'}">selected</c:if> >否</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">防误方式：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="preventionType" name="preventionType" class="input-xlarge " tabindex="-1" title="" >
						<option value=""></option>
						
						<option value="2"  <c:if test="${siteInfo.preventionType == '2'}">selected</c:if>  >2</option>
						
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否具有环网：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="hasRingNetwork" name="hasRingNetwork" class="input-xlarge " tabindex="-1" title="" >
						<option value=""></option>
						<option value="" selected="selected" ></option>
						<option value="是" <c:if test="${siteInfo.hasRingNetwork == '是'}">selected</c:if> >是</option>
						<option value="否" <c:if test="${siteInfo.hasRingNetwork == '否'}">selected</c:if> >否</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">无功补偿容量(kVar)：</label>
			<div class="controls">
				<input id="compensateCapacity" name="compensateCapacity" class="input-xlarge " type="text"  maxlength="100" value = "${siteInfo.compensateCapacity}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">设备类型编码：</label>
			<div class="controls">
				<input id="equipmentCode" name="equipmentCode" class="input-xlarge " type="text"  maxlength="100" value = "${siteInfo.equipmentCode}" >
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">经度：</label>
			<div class="controls">
				<input id="longitudePoint" name="longitudePoint" class="input-xlarge " type="text"  maxlength="100"  value = "${siteInfo.longitudePoint}" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">纬度：</label>
			<div class="controls">
				<input id="latitudePoint" name="latitudePoint" class="input-xlarge " type="text"  maxlength="100"  value = "${siteInfo.latitudePoint}"  >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属地区：</label>
			<div class="controls">
				<input id="belongArea" name="belongArea" class="input-medium" type="text"  value = "${siteInfo.belongArea}" list="belongAreaList"  maxlength="64"/>
				<datalist id="belongAreaList">
				<c:forEach var="area" items="${belongAreaList}">
			 		<option value="${area}">${area}</option>
			 	</c:forEach>
			</datalist>
			<!-- 
				<input id="belongArea" name="belongArea" class="input-xlarge " type="text"  maxlength="100"  value = "${siteInfo.belongArea}" >
				
				 <select id = "belongArea" name="belongArea" class="input-medium">
				 	<option value="${siteInfo.belongArea}"  >${siteInfo.belongArea}</option>
				 	<option value="黄浦区" <c:if test="${siteInfo.belongArea == '黄浦区'}">selected="selected"</c:if> >黄浦区</option>
				 	<option value="卢湾区" <c:if test="${siteInfo.belongArea == '卢湾区'}">selected="selected"</c:if> >卢湾区</option>
				 	<option value="徐汇区" <c:if test="${siteInfo.belongArea == '徐汇区'}">selected="selected"</c:if> >徐汇区</option>
				 	<option value="长宁区" <c:if test="${siteInfo.belongArea == '长宁区'}">selected="selected"</c:if> >长宁区</option>
				 	<option value="静安区" <c:if test="${siteInfo.belongArea == '静安区'}">selected="selected"</c:if> >静安区</option>
				 	<option value="普陀区" <c:if test="${siteInfo.belongArea == '普陀区'}">selected="selected"</c:if> >普陀区</option>
				 	<option value="闸北区" <c:if test="${siteInfo.belongArea == '闸北区'}">selected="selected"</c:if> >闸北区</option>
				 	<option value="虹口区" <c:if test="${siteInfo.belongArea == '虹口区'}">selected="selected"</c:if> >虹口区</option>
				 	<option value="杨浦区" <c:if test="${siteInfo.belongArea == '杨浦区'}">selected="selected"</c:if> >杨浦区</option>
				 	<option value="闵行区" <c:if test="${siteInfo.belongArea == '闵行区'}">selected="selected"</c:if> >闵行区</option>
				 	<option value="宝山区" <c:if test="${siteInfo.belongArea == '宝山区'}">selected="selected"</c:if> >宝山区</option>
				 	<option value="嘉定区" <c:if test="${siteInfo.belongArea == '嘉定区'}">selected="selected"</c:if> >嘉定区</option>
				 	<option value="浦东新区" <c:if test="${siteInfo.belongArea == '浦东新区'}">selected="selected"</c:if> >浦东新区</option>
				 	<option value="金山区" <c:if test="${siteInfo.belongArea == '金山区'}">selected="selected"</c:if> >金山区</option>
				 	<option value="松江区" <c:if test="${siteInfo.belongArea == '松江区'}">selected="selected"</c:if> >松江区</option>
				 	<option value="青浦区" <c:if test="${siteInfo.belongArea == '青浦区'}">selected="selected"</c:if> >青浦区</option>
				 	<option value="南汇区" <c:if test="${siteInfo.belongArea == '南汇区'}">selected="selected"</c:if> >南汇区</option>
				 	<option value="奉贤区" <c:if test="${siteInfo.belongArea == '奉贤区'}">selected="selected"</c:if> >奉贤区</option>
				 	<option value="崇明县" <c:if test="${siteInfo.belongArea == '崇明县'}">selected="selected"</c:if> >崇明县</option>
				 	
			 	</select>
			 -->
			
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据来源：</label>
			<div class="controls">
				<input id="comeFrom" name="comeFrom" class="input-xlarge " type="text"  maxlength="100"  value = "${siteInfo.comeFrom}"  disabled="disabled">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
				<div class="select2-container input-xlarge" id="s2id_isWantPregnant">
					<select id="state" name="state" class="input-xlarge " tabindex="-1" title="" >
						<option value=""></option>
						<option value="" selected="selected" ></option>
						<option value="N" <c:if test="${siteInfo.state == 'N'}">selected</c:if> >正常</option>
						<option value="C" <c:if test="${siteInfo.state == 'C'}">selected</c:if> >关闭</option>
					</select>
				</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属采集员ID：</label>
			<div class="controls">
				<input id="siteUserId" name="siteUserId" disabled="disabled" class="input-xlarge " type="text"  maxlength="100"  value = "${siteInfo.userId}"  >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建时间：</label>
			<div class="controls">
				<input id="createTime" name="createTime" class="input-xlarge " disabled="disabled" type="text"  maxlength="100"  value = "${siteInfo.createTime}"  >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">最后更新时间：</label>
			<div class="controls">
				<input id="updateTime" name="updateTime" class="input-xlarge " disabled="disabled" type="text"  maxlength="100"  value = "${siteInfo.updateTime}"  >
			</div>
		</div>
		
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存">&nbsp;
			<!--  <input id="btnCancel" class="btn" type="button" value="返 回">-->
		</div>
	</form>
	<script type="text/javascript">//<!-- 无框架时，左上角显示菜单图标按钮。
		if(!(self.frameElement && self.frameElement.tagName=="IFRAME")){
			$("body").prepend("<i id=\"btnMenu\" class=\"icon-th-list\" style=\"cursor:pointer;float:right;margin:10px;\"></i><div id=\"menuContent\"></div>");
			$("#btnMenu").click(function(){
				top.$.jBox('get:<%=request.getContextPath() %>/a/sys/menu/treeselect;JSESSIONID=18b23410a80b4158bb737ded9d52f64f', {title:'选择菜单', buttons:{'关闭':true}, width:300, height: 350, top:10});
				//if ($("#menuContent").html()==""){$.get("<%=request.getContextPath() %>/a/sys/menu/treeselect", function(data){$("#menuContent").html(data);});}else{$("#menuContent").toggle(100);}
			});
		}//-->
	</script>

</body>
</html>