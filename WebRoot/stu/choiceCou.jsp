<%@ page language="java" import="java.util.*,com.ten.dao.*,com.ten.user.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-正在选课</title>
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
<div class="top">
	<div class="title"><p> 学生选课信息管理系统 </p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src=img/touxiang.png></div>
		<div class="main_left_class01"><a href="stu/choiceCou.jsp">学生选课</a></div>
		<div class="main_left_class02"><a href="stu/showCou.jsp">课程查询</a></div>
		<div class="main_left_class03"><a href="stu/stuInfo.jsp">学籍信息</a></div>
		<div class="main_left_class100">
		<input class="reset" type="button" value="注销" onClick="window.location.href=('/Ten/servlet/serDoLogout')">
		</div>
	</div>
		<%
		Student stu = null;
    	if(session.getAttribute("student")==null){
    		response.sendRedirect("/Ten/Login.jsp");
    	}else{
    		stu = (Student)session.getAttribute("student");
    	}%>
	<div class="main_right">
		<div class="info">
			<p>亲爱的<%= stu.getSname() %>同学，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
			<form action="servlet/serInsertSc" method="post">
			<%Course cou = null;
  				DaoCou selectcou = new DaoCou();
  				Iterator<Course> list = selectcou.selectCou(); 
  			%>
				<table>
  					<tr><td></td></tr>
  					<tr>
  						<td>课程编号</td><td>课程名称</td><td>课程学分</td><td>选课</td>
  						
  					</tr>
  					<% 
  						while(list.hasNext()){
  						cou = list.next();
  						%>
  					<tr>
  					<td><%= cou.getCNo() %></td>
  					<td><%= cou.getCname() %></td>
  					<td><%= cou.getCcredit() %></td>
  					<td><input type="checkbox" name="choiceCou" value="<%= cou.getCNo()%>" /> </td>
  					</tr>
		  			<%
  					}
     			%>
     			<tr><td></td></tr><tr><td></td><td></td>
  					<td><input class="sure" type="submit" value="确定"></td>
					<td><input class="cancle" type="reset" value="取消"></td>
  				</table>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
