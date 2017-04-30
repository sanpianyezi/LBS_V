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

<style type="text/css">
        .imagesdiv
        {
            position: relative;
            width:160px;
            height:90px;
        }
        .imagesinput
        {
            opacity:0;
            filter:alpha(opacity=0);
            height: 95px;
            width: 100px;
            position: absolute;
            top: 0;
            left: 0;
            z-index: 9;
        }
    </style>
    
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
					//$("#marriedType").removeAttr("disabled"); //去除disabled
					//$("#gynecopathyOther").removeAttr("disabled"); 
					//$("#familyMedicalHistoryOther").removeAttr("disabled"); 
					loading('正在提交，请稍等...');
					$(form).ajaxSubmit(function(data){
				    	closeTip();
				    	if(data.success){
				    		$.jBox.prompt(data.message, '提示', 'success', { closed: function () {
				    				//$('#btnSubmit', window.parent.document).click();
				    				//window.parent.window.jBox.close();
				    				location.reload([true]);
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
			
			
			$("#inputForm1").validate({
				submitHandler:function(form){
					$('#btnSubmit1').attr({"disabled":"disabled"});
					//$("#marriedType").removeAttr("disabled"); //去除disabled
					//$("#gynecopathyOther").removeAttr("disabled"); 
					//$("#familyMedicalHistoryOther").removeAttr("disabled"); 
					loading('正在提交，请稍等...');
					$(form).ajaxSubmit(function(data){
				    	closeTip();
				    	if(data.success){
				    		$.jBox.prompt('上传成功！', '提示', 'success', { closed: function () {
				    				//$('#btnSubmit1', window.parent.document).click();
				    				//window.parent.window.jBox.close();
				    				location.reload([true]);
								} 
				    		});
				    	}else{
				    		alertx(data.message);
				    		$("#btnSubmit1").removeAttr("disabled");
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
			
			$("#inputForm2").validate({
				submitHandler:function(form){
					$('#btnSubmit2').attr({"disabled":"disabled"});
					//$("#marriedType").removeAttr("disabled"); //去除disabled
					//$("#gynecopathyOther").removeAttr("disabled"); 
					//$("#familyMedicalHistoryOther").removeAttr("disabled"); 
					loading('正在提交，请稍等...');
					$(form).ajaxSubmit(function(data){
				    	closeTip();
				    	if(data.success){
				    		$.jBox.prompt('上传成功！', '提示', 'success', { closed: function () {
				    				//$('#btnSubmit2', window.parent.document).click();
				    				//window.parent.window.jBox.close();
				    				location.reload([true]);
								} 
				    		});
				    	}else{
				    		alertx(data.message);
				    		$("#btnSubmit2").removeAttr("disabled");
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
		
		$(function(){
	       $("#sitePhoto").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#fileimage1").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      $("#sitePhoto1").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#fileimage2").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      $("#sitePhoto2").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#fileimage3").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      $("#sitePhoto3").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#fileimage4").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      
	      
	      
	      
	      
	      
	       $("#images1Photo").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#file1image1").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      $("#images1Photo1").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#file1image2").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      $("#images1Photo2").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#file1image3").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      $("#images1Photo3").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#file1image4").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      
	      
	      
	      $("#images2Photo").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#file2image1").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      $("#images2Photo1").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#file2image2").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      $("#images2Photo2").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#file2image3").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      $("#images2Photo3").change(function(e){
	             var file = e.target.files||e.dataTransfer.files;
	             if(file){
	                
	                var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        $("#file2image4").attr("src","<%=request.getContextPath() %>/images/22.png");
	            }
	      });
	      
	      
	      
	      
	      
	      
   })
		
		
		
		
		
		function delImages(temp){
			var obj = temp.split("|");
			var siteId = obj[0];
			var imagesPath = obj[1];
			var postion = obj[2];
	
			$.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/manger/delImages",
                async: false, //是否异步
                data:{siteId:siteId,imagesPath:imagesPath,postion:postion},
                //dataType:"JSON",
                success: function (result) {
                	
                	if("000" == result.code){
                		alert(result.message);
                		location.reload([true]);            
						//跳转
                	}else{
                		alert("删除失败");
                	}
                	
                },
                error: function (result) {
                    alert("网络超时");
                }
            });
            
		}
		
		
		function delImages1(temp){
			var obj = temp.split("|");
			var imagesId = obj[0];
			var imagesPath = obj[1];
			var postion = obj[2];
	
			$.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/manger/delImages1",
                async: false, //是否异步
                data:{imagesId:imagesId,imagesPath:imagesPath,postion:postion},
                //dataType:"JSON",
                success: function (result) {
                	
                	if("000" == result.code){
                		alert(result.message);
                		location.reload([true]);            
						//跳转
                	}else{
                		alert("删除失败");
                	}
                	
                },
                error: function (result) {
                    alert("网络超时");
                }
            });
            
		}
		
		
				
	</script>

</head>
<body>
<div class="form-actions">
	<h4 color="green">站点采集图:</h4>
	</div>
	<form id="inputForm" class="form-horizontal" action="<%=request.getContextPath() %>/manger/uploadImages" method="post" enctype="multipart/form-data" >


		<script type="text/javascript">top.$.jBox.closeTip();</script>
		<input id="siteId" name="siteId" class="input-xlarge " type="hidden" value="${siteImagesVo.siteId}" maxlength="100">
		<input id="siteImages" name="siteImages" class="input-xlarge " type="hidden" value="${siteImagesVo.siteImages}" maxlength="100">
		<table>
			<tr>
				<td>
					<div class="imagesdiv"  >
       					<input class = "imagesinput"id="sitePhoto" name="sitePhoto" class="input-xlarge " type="file" accept="image/jpeg ,image/png"  style="width:100%;height:100%" >
       					<img id = "fileimage1" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.siteImages,",")[0]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
				<td>
					<div class="imagesdiv"  >
       				<input class = "imagesinput"id="sitePhoto1" name="sitePhoto1" class="input-xlarge " type="file" accept="image/jpeg ,image/png"  style="width:100%;height:100%" >
       				<img id = "fileimage2" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.siteImages,",")[1]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
				<td>
					<div class="imagesdiv"  >
       					<input class = "imagesinput"id="sitePhoto2" name="sitePhoto2" class="input-xlarge " type="file" accept="image/jpeg ,image/png"  style="width:100%;height:100%" >
       					<img id = "fileimage3" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.siteImages,",")[2]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
				<td>
					<div class="imagesdiv"  >
       					<input class = "imagesinput"id="sitePhoto3" name="sitePhoto3" class="input-xlarge " type="file" accept="image/jpeg ,image/png"  style="width:100%;height:100%" >
       					<img id = "fileimage4" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.siteImages,",")[3]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
			
			</tr>
			<tr>
				<td  align="center">
					图片一<c:if test='${fn:split(siteImagesVo.siteImages,",")[0]!=null && fn:split(siteImagesVo.siteImages,",")[0] !=""}'><a href="javascript:delImages('${siteImagesVo.siteId}|${siteImagesVo.siteImages}|1')">删除1</a></c:if>
				</td>
				<td  align="center">
					图片二<c:if test='${fn:split(siteImagesVo.siteImages,",")[1]!=null}'><a href="javascript:delImages('${siteImagesVo.siteId}|${siteImagesVo.siteImages}|2')">删除2</a></c:if>
				</td>
				<td  align="center">
					图片三<c:if test='${fn:split(siteImagesVo.siteImages,",")[2]!=null}'><a href="javascript:delImages('${siteImagesVo.siteId}|${siteImagesVo.siteImages}|3')">删除3</a></c:if>
				</td>
				<td  align="center">
					图片四<c:if test='${fn:split(siteImagesVo.siteImages,",")[3]!=null}'><a href="javascript:delImages('${siteImagesVo.siteId}|${siteImagesVo.siteImages}|4')">删除4</a></c:if>
				</td>
			</tr>
			
			<tr>
				<td colspan="4" align="center">
					<div class="control-group">
						<label class="control-label">&nbsp;</label>
						<div class="controls">
							<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存">&nbsp;
						</div>
					</div>
				</td>
			</tr>
		
		
		</table>
		
		 
		
	</form>
	<div class="form-actions">
	<h4 color="green">站点CAD图:</h4>
	</div>
	<form id="inputForm1" class="form-horizontal" action="<%=request.getContextPath() %>/manger/uploadImages1" method="post" enctype="multipart/form-data" novalidate="novalidate">


			<script type="text/javascript">top.$.jBox.closeTip();</script>
		
		
		
				<input id="siteId" name="siteId" class="input-xlarge " type="hidden" value="${siteImagesVo.siteId}" maxlength="100">
				<input id="images1Path" name="images1Path" class="input-xlarge " type="hidden" value="${siteImagesVo.images1Path}" maxlength="100">
		
				<input id="images1Id" name="images1Id" class="input-xlarge " type="hidden" value="${siteImagesVo.images1Id}" maxlength="100">
		
		
		
		<table>
			<tr>
				<td>
					<div class="imagesdiv"  >
       					<input class = "imagesinput"id="images1Photo" name="images1Photo" class="input-xlarge " type="file" accept="image/jpeg ,image/png" style="width:100%;height:100%"  >
    					<img id = "file1image1" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.images1Path,",")[0]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
				<td>
					<div class="imagesdiv"  >
       				<input class = "imagesinput"id="images1Photo1" name="images1Photo1" class="input-xlarge " type="file" accept="image/jpeg ,image/png" style="width:100%;height:100%"  >
    					<img id = "file1image2" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.images1Path,",")[1]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
				<td>
					<div class="imagesdiv"  >
       					<input class = "imagesinput"id="images1Photo2" name="images1Photo2" class="input-xlarge " type="file" accept="image/jpeg ,image/png" style="width:100%;height:100%"  >
    					<img id = "file1image3" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.images1Path,",")[2]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
				<td>
					<div class="imagesdiv"  >
       					<input class = "imagesinput"id="images1Photo3" name="images1Photo3" class="input-xlarge " type="file" accept="image/jpeg ,image/png" style="width:100%;height:100%"  >
    					<img id = "file1image4" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.images1Path,",")[3]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
			
			</tr>
			<tr>
				<td  align="center">
					图片一<c:if test='${fn:split(siteImagesVo.images1Path,",")[0]!=null && fn:split(siteImagesVo.images1Path,",")[0] !=""}'><a href="javascript:delImages1('${siteImagesVo.images1Id}|${siteImagesVo.images1Path}|1')">删除1</a></c:if>
				</td>
				<td  align="center">
					图片二<c:if test='${fn:split(siteImagesVo.images1Path,",")[1]!=null}'><a href="javascript:delImages1('${siteImagesVo.images1Id}|${siteImagesVo.images1Path}|2')">删除2</a></c:if>
				</td>
				<td  align="center">
					图片三<c:if test='${fn:split(siteImagesVo.images1Path,",")[2]!=null}'><a href="javascript:delImages1('${siteImagesVo.images1Id}|${siteImagesVo.images1Path}|3')">删除3</a></c:if>
				</td>
				<td  align="center">
					图片四<c:if test='${fn:split(siteImagesVo.images1Path,",")[3]!=null}'><a href="javascript:delImages1('${siteImagesVo.images1Id}|${siteImagesVo.images1Path}|4')">删除4</a></c:if>
				</td>
			</tr>
			
			<tr>
				<td colspan="4" align="center">
					<div class="control-group">
						<label class="control-label">&nbsp;</label>
						<div class="controls">
							<input id="btnSubmit1" class="btn btn-primary" type="submit" value="保 存">&nbsp;
						</div>
					</div>
				</td>
			</tr>
		</table>
		<%-- <div class="control-group">
			<label class="control-label">站点CAD图：</label>
			<div class="controls">
				<img src='<%=request.getContextPath() %>/images/upload/${siteImagesVo.images1Path}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" width='100' height='100'/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传CAD图片：</label>
			<div class="controls">
				<input id="images1Photo" name="images1Photo" class="input-xlarge " type="file" accept="image/jpeg ,image/png" value="" >
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">&nbsp;</label>
			<div class="controls">
				<input id="btnSubmit1" class="btn btn-primary" type="submit" value="保 存">&nbsp;
			</div>
		</div> --%>
	
	</form>
	<div class="form-actions">
	<h4 color="green">站点平面图:</h4>
	</div>
	<form id="inputForm2" class="form-horizontal" action="<%=request.getContextPath() %>/manger/uploadImages2" method="post" enctype="multipart/form-data" novalidate="novalidate">


<script type="text/javascript">top.$.jBox.closeTip();</script>
		
		
		
				<input id="siteId" name="siteId" class="input-xlarge " type="hidden" value="${siteImagesVo.siteId}" maxlength="100">
				<input id="images2Path" name="images2Path" class="input-xlarge " type="hidden" value="${siteImagesVo.images2Path}" maxlength="100">
		
				<input id="images2Id" name="images2Id" class="input-xlarge " type="hidden" value="${siteImagesVo.images2Id}" maxlength="100">
		
		<table>
			<tr>
				<td>
					<div class="imagesdiv"  >
       					<input class = "imagesinput"id="images2Photo" name="images2Photo" class="input-xlarge " type="file" accept="image/jpeg ,image/png" style="width:100%;height:100%"  >
    					<img id = "file2image1" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.images2Path,",")[0]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
				<td>
					<div class="imagesdiv"  >
       				<input class = "imagesinput"id="images2Photo1" name="images2Photo1" class="input-xlarge " type="file" accept="image/jpeg ,image/png" style="width:100%;height:100%"  >
    					<img id = "file2image2" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.images2Path,",")[1]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
				<td>
					<div class="imagesdiv"  >
       					<input class = "imagesinput"id="images2Photo2" name="images2Photo2" class="input-xlarge " type="file" accept="image/jpeg ,image/png" style="width:100%;height:100%"  >
    					<img id = "file2image3" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.images2Path,",")[2]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
				<td>
					<div class="imagesdiv"  >
       					<input class = "imagesinput"id="images2Photo3" name="images2Photo3" class="input-xlarge " type="file" accept="image/jpeg ,image/png" style="width:100%;height:100%"  >
    					<img id = "file2image4" src='<%=request.getContextPath() %>/images/upload/${fn:split(siteImagesVo.images2Path,",")[3]}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" style="width:160px;height:90px;"/>
    				</div>
				</td>
			
			</tr>
			<tr>
				<td  align="center">
					图片一<c:if test='${fn:split(siteImagesVo.images2Path,",")[0]!=null && fn:split(siteImagesVo.images2Path,",")[0] !=""}'><a href="javascript:delImages1('${siteImagesVo.images2Id}|${siteImagesVo.images2Path}|1')">删除1</a></c:if>
				</td>
				<td  align="center">
					图片二<c:if test='${fn:split(siteImagesVo.images2Path,",")[1]!=null}'><a href="javascript:delImages1('${siteImagesVo.images2Id}|${siteImagesVo.images2Path}|2')">删除2</a></c:if>
				</td>
				<td  align="center">
					图片三<c:if test='${fn:split(siteImagesVo.images2Path,",")[2]!=null}'><a href="javascript:delImages1('${siteImagesVo.images2Id}|${siteImagesVo.images2Path}|3')">删除3</a></c:if>
				</td>
				<td  align="center">
					图片四<c:if test='${fn:split(siteImagesVo.images2Path,",")[3]!=null}'><a href="javascript:delImages1('${siteImagesVo.images2Id}|${siteImagesVo.images2Path}|4')">删除4</a></c:if>
				</td>
			</tr>
			
			<tr>
				<td colspan="4" align="center">
					<div class="control-group">
						<label class="control-label">&nbsp;</label>
						<div class="controls">
							<input id="btnSubmit2" class="btn btn-primary" type="submit" value="保 存">&nbsp;
						</div>
					</div>
				</td>
			</tr>
		</table>
		
		<%-- <div class="control-group">
			<label class="control-label">站点平面图：</label>
			<div class="controls">
				<img src='<%=request.getContextPath() %>/images/upload/${siteImagesVo.images2Path}' onerror="javascript:this.src='<%=request.getContextPath() %>/images/11.png';" width='100' height='100'/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传平面图片：</label>
			<div class="controls">
				<input id="images2Photo" name="images2Photo" class="input-xlarge " type="file" accept="image/jpeg ,image/png" value="">
			</div>
		</div>
		
	<div class="control-group">
			<label class="control-label">&nbsp;</label>
			<div class="controls">
				<input id="btnSubmit2" class="btn btn-primary" type="submit" value="保 存">&nbsp;
			</div>
		</div> --%>
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