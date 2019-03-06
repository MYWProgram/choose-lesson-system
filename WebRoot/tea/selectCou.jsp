<%@ page language="java" import="java.util.*,com.ten.user.*,com.ten.dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-课程信息</title>
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
	<div class="title"><p> 学生选课信息管理系统</p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src=img/touxiang.png></div>
			<div class="main_left_class01"><a href="tea/selectCou.jsp">选课管理</a></div>
			<div class="main_left_class02"><a href="tea/selectStu.jsp">学生信息</a></div>
			<div class="main_left_class03"><a href="tea/Query.jsp">信息查询</a></div>
			<div class="main_left_class100">
		<input class="reset" type="button" value="注销" onClick="window.location.href=('/Ten/servlet/serDoLogout')">
		</div>
	</div>
					<%
	  	Teacher tea = null;
	  	if(session.getAttribute("teacher")==null){
	  		response.sendRedirect("/Ten/Login.jsp");
	  	}else{
	  		tea = (Teacher)session.getAttribute("teacher");
	   %>
	<div class="main_right">
		<div class="info">
			<p>亲爱的<%= tea.getTname() %>老师，下午好</p>
		</div>
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<%
    		DaoCou select = new DaoCou();
			Iterator<Course> list = select.selectCou(); %>
			<div class="form">
				<table>
  					<tr><td></td></tr>
  					<tr>
  						<td>课程编号</td><td>课程名称</td><td>课程学分</td><td>修改课程</td><td>删除课程</td>
  						<td><input class="btn" type="button" value="添加课程" onclick="window.location.href=('/Ten/tea/InsertCou.jsp')"/></td>
  						
  					</tr>
			  		<%
			   			while(list.hasNext()){
						Course cou = list.next();
			   		%>
  					<tr>
  					<td><%= cou.getCNo() %></td>
  					<td><%= cou.getCname() %></td>
  					<td><%= cou.getCcredit() %></td>
  					<td><input  class="btn" type="button" value="修改课程" onClick="window.location.href=('/Ten/tea/updateCou.jsp?id=<%= cou.getCNo() %>')"></td>
  					<td><input  class="btn" type="button" value="删除课程" onClick="window.location.href=('/Ten/servlet/serDeleteCou?id=<%= cou.getCNo() %>')"></td>
  					</tr>
		  				<%
		   			}
		   		}
		    %>
  				</table>
				
			</div>
		</div>
	</div>
</div>
</body>
</html>
