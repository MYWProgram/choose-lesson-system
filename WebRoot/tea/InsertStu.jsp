<%@ page language="java" import="java.util.*,com.ten.user.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-添加学生</title>
    <link href="style_1.css" type="text/css" rel="stylesheet"/>
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
    <%
	  	Teacher tea = null;
	  	if(session.getAttribute("teacher")==null){
	  		response.sendRedirect("/Ten/Login.jsp");
	  	}else{
	  		tea = (Teacher)session.getAttribute("teacher");}
	   %>
<div class="top">
	<div class="title"><p> 学生选课信息管理系统</p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src=img/touxiang.png></div>
			<div class="main_left_class01"><a href="tea/selectCou.jsp">选课管理</a></div>
			<div class="main_left_class02"><a href="tea/selectStu.jsp">学生信息</a></div>
			<div class="main_left_class03"><a href="Query.jsp">信息查询</a></div>
			<div class="main_left_class100">
		<input class="reset" type="button" value="注销" onClick="window.location.href=('/Ten/servlet/serDoLogout')">
		</div>
	</div>
	<div class="main_right">
		<div class="info">
			<p>亲爱的<%= tea.getTname() %>老师，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
			<div class="form_1">
				<form action="servlet/serInsertStu" method="post">
				 
				<table>
				
  					<tr><td></td></tr>
  					<tr><td>学生姓名</td> <td><input  class="text" type="text" name="Sname"/></td></tr>
  					<tr><td>学生密码</td> <td><input  class="text" type="text" name="Spassword"/></td></tr>
  					<tr><td>学生班级</td> <td><input  class="text" type="text" name="Sclass"/></td></tr>
  					<tr><td>学生性别</td> <td><input  class="text" type="text" name="Ssex"/></td></tr>
  					<tr><td></td><td><input class="btn" type="submit" value="添加"/>  </td></tr>
 
  					
  				</table>
  				</form>
  				</div>
  				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
