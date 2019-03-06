package com.ten.ser.stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ten.dao.DaoStu;
import com.ten.user.Student;

@SuppressWarnings("serial")
public class serDoUpdateStu extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public serDoUpdateStu() {
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
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY><center>");
		try{
			request.setCharacterEncoding("utf-8");
			Student stu = new Student(Integer.parseInt(request.getParameter("SNo")),request.getParameter("Sname")
					,request.getParameter("Spassword"),request.getParameter("Sclass"),request.getParameter("Ssex"),0);
			DaoStu update = new DaoStu();
			int rs = update.updateStu(stu);
			if(rs!=0){
				out.println("修改成功："+stu.getSNo());
			}else{
				out.println("修改失败"+stu.getSNo());
			}
			response.sendRedirect("/Ten/tea/selectStu.jsp");
		}catch(Exception e){e.printStackTrace();}
		
		out.println("</center></BODY>");
		out.println("</HTML>");
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
