package com.ten.ser.sc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ten.dao.DaoQuery;
import com.ten.user.QueryResult;
import com.ten.user.Teacher;

public class serQuerySc extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public serQuerySc() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
/************************************************************/
		if(session.getAttribute("teacher")==null){
			response.sendRedirect("../Login.jsp");
		}else{
			Teacher tea = (Teacher) session.getAttribute("teacher");
/*************************************************************/
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			try{
				request.setCharacterEncoding("utf-8");
				String queryKey = request.getParameter("queryKey");//查询关键字
				int type = 20;//查询类型，默认为20,不是1-6就好
				if(request.getParameter("type")!=null){
					type = Integer.parseInt(request.getParameter("type"));
				}
				DaoQuery query = new DaoQuery();
				List<QueryResult> list = new ArrayList<QueryResult>();
				switch(type){
				case 1:
					list = query.selectSno(Integer.parseInt(queryKey));break;//学号
				case 2:
					list = query.selectSname(queryKey);break;//姓名
				case 3:
					list = query.selectSclass(queryKey);break;//班级
				case 4:
					list = query.selectCname(queryKey);System.out.println("cname"+queryKey);break;//课程名
				case 5:
					list = query.selectCno(Integer.parseInt(queryKey));break;//课程号
				case 6:
					list = query.selectRoom(queryKey);break;//上课教室
				case 20:
					out.println("<center>请输入查询关键字，并选择查询类型</center>");break;
				default:
					out.println("<center>错误，请重试！！</center>");break;
				}
				request.setAttribute("queryResult", list);
				request.getRequestDispatcher("/tea/Query.jsp?type="+type+"&key="+queryKey+"").forward(request, response);
			}catch(Exception e){response.sendRedirect("/Ten/tea/Query.jsp");e.printStackTrace();}
			out.println("  </BODY>");
			out.println("</HTML>");
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
