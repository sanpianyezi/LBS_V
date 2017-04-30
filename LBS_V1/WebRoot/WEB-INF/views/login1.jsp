<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
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
  <div style="width:100%;height:50px;background:blue;"><h2 style="line-height:50px;text-align:center;color:#FFFFFF;">登录接口</h2></div>
   <br>
    	<div align="center"><label>用户名：</label><input id= "userName" type="text"></div>
     	<div align="center"><label>密码：</label><input id= "passWord" type="password" ></div>
     <div align="center"><button style="line-height:25px;color:#006dba" onclick="login()">登录</button></div>
     
    <hr color="green">
     <font> 测试账户为：test 111111<br>
     
     
     调用参数： data:{"userJson":"{"userName":"userName" , "passWord":passWord"}"}
     <br>
     接口名称：<%=request.getContextPath()%>/login
      <br>
   返回结果：result <br>
          code        message <br>
          011		  用户名不存在 <br>
          021			密码错误 <br>
          031			用户名密码不匹配 <br>
          000			登陆成功  userInfo <br>  
          
          ajax:<br>
         <p> $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/login",
                async: false, //是否异步
                data:{userJson:userJson},
                dataType:"JSON",
                success: function (result) {
                	if("011" == result.code){
                		alert(result.message);
                		return false;
                	}
                	if("021" == result.code){
                		alert(result.message);
                		return false;
                	}
                	if("031" == result.code){
                		alert(result.message);
                		return false;
                	}
                	if("000" == result.code){
                		alert(result.message);
                		alert(result.userInfo);
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
   
   	function login(){
   		
		var userName = document.getElementById("userName").value;
		
		
		var passWord = document.getElementById("passWord").value;
		if(userName =="" || passWord ==""){
		alert("请输入用户名或者密码！");
		return false;
		}
		var user = new Object();
		user.userName = userName;
		user.passWord = passWord;
		var userJson  = JSON.stringify(user)
		$.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/login",
                async: false, //是否异步
                data:{userJson:userJson},
                dataType:"JSON",
                success: function (result) {
                	if("011" == result.code){
                		alert(result.message);
                		return false;
                	}
                	if("021" == result.code){
                		alert(result.message);
                		return false;
                	}
                	if("031" == result.code){
                		alert(result.message);
                		return false;
                	}
                	if("000" == result.code){
                		alert(result.message);
                		alert(result.userInfo);
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
