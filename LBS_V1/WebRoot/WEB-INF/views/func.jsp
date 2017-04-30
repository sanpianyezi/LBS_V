<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后端服务已启动</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div style="widtd:100%;height:100px;background:blue;"><h2 style="line-height:100px;text-align:center;color:#FFFFFF;">LBS后端服务接口</h2></div>
   <font><br>1.登录接口</font>
   <hr color="green">
   <a href="javascript:ToLogin();">用户登录</a><br>
   <font>输入参数：userName passWord 必填</font>
   <br><br>
   <font><br>2.添加站点接口</font>
   <hr color="green">
   <a href="javascript:ToAddSite();">添加站点</a><br>
   <font>输入参数：siteListJson:[{"siteName":"siteName" , "siteType":siteType",....,"imagePath":"imagePath"},{"siteName":"siteName" , "siteType":siteType",....,"imagePath":"imagePath"}"]
     必填</font>
   
   
   
   
   
   
  
   
   <script type="text/javascript">
   
   	function ToLogin(){
   		window.location.href="<%=basePath%>loginout";
   	}
   	
   	function ToAddSite(){
   		window.location.href="<%=basePath%>ToAddSite";
   	}
   
   </script>
  </body>
</html>
