<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加站点页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.0.js"></script> 
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.0.min.js"></script> 
  </head>
  
  <body>
  <div style="width:100%;height:50px;background:blue;"><h2 style="line-height:50px;text-align:center;color:#FFFFFF;">添加站点接口</h2></div>
   <br>
    	<div align="center"><label>站点名称：</label><input id= "siteName" type="text"></div><br>
     	<div align="center"><label>站点类型：</label><input id= "siteType" type="text" ></div><br>
     	<div align="center"><label>站点地址：</label><input id= "siteAddr" type="text"></div><br>
     	<div align="center"><label>站点简称：</label><input id= "shortName" type="text" ></div><br>
     	
     	<div align="center"><label>电压等级：</label><input id= "voltageGrade" type="text"></div><br>
     	<div align="center"><label>地区特称：</label><input id= "regionFeatures" type="text" ></div><br>
     	<div align="center"><label>站点经度：</label><input id= "longitude" type="text"></div><br>
     	<div align="center"><label>站点纬度：</label><input id= "latitude" type="text" ></div><br>
     	
     	<div align="center"><label>创建时间：</label><input id= "creatTime" type="text"></div><br>
     	<div align="center"><label>图片地址：</label><input id= "imagePath" type="text" ></div><br>
     <div align="center"><button style="line-height:25px;color:#006dba" onclick="addSite()">添加</button></div>
     
    <hr color="green">
     <font> 测试账户为：test 111111<br>
     
     
     调用参数： siteListJson:[{"siteName":"siteName" , "siteType":siteType",....,"imagePath":"imagePath"},{"siteName":"siteName" , "siteType":siteType",....,"imagePath":"imagePath"}"]
     <br>
     接口名称：<%=request.getContextPath()%>/addSite
      <br>
   返回结果：result <br>
          code        message <br>
          011		 添加失败 <br>
          000			添加成功  <br>  
          
          ajax:<br>
         <p> $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/addSite",
                async: false, //是否异步
                data:{siteListJson:siteListJson},
                dataType:"JSON",
                success: function (result) {
                	if("011" == result.code){
                		alert(result.message);
                		return false;
                	}
                	if("000" == result.code){
                		alert(result.message);
						//跳转
                	}
                	
                },
                error: function (result) {
                    alert("网络超时");
                }
            });
       </p>
     </font>
     
     <script type="text/javascript">
   
   	function addSite(){
   		
		var siteName = document.getElementById("siteName").value;
		var siteType = document.getElementById("siteType").value;
		
		var	siteAddr = document.getElementById("siteAddr").value;
		var	shortName = document.getElementById("shortName").value;
		var	voltageGrade = document.getElementById("voltageGrade").value;
		var	regionFeatures = document.getElementById("regionFeatures").value;
		
		var	longitude = document.getElementById("longitude").value;
		var	latitude = document.getElementById("latitude").value;
		var	creatTime = document.getElementById("creatTime").value;
		var	imagePath = document.getElementById("imagePath").value;
		
		var site = new Object();
		site.siteName = siteName;
		site.siteType = siteType;
		
		site.siteAddr = siteAddr;
		site.shortName = shortName;
		site.voltageGrade = voltageGrade;
		site.regionFeatures = regionFeatures;
		
		site.longitudePoint = longitude;
		site.latitudePoint = latitude;
		site.createTime = creatTime;
		site.imagePath = imagePath;
		
		var siteList = new Array();
		siteList[0] =site;
		siteList[1] =site;
		
		
		
		
		var siteListJson  = JSON.stringify(siteList)
		alert(siteListJson);
		$.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/addSite",
                async: false, //是否异步
                data:{siteListJson:siteListJson},
                dataType:"JSON",
                success: function (result) {
                	if("011" == result.code){
                		alert(result.message);
                		return false;
                	}
                	if("000" == result.code){
                		alert(result.message);
						//跳转
                	}
                	
                },
                error: function (result) {
                    alert("网络超时");
                }
            });
		
   	}
   
   </script>
  </body>
</html>
