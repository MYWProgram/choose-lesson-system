package com.ten.ser.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ten.dao.DaoSc;
import com.ten.user.SC;

public class serUpdateClass extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public serUpdateClass() {
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
/**************************************************************/
		HttpSession session = request.getSession();
		if(session.getAttribute("teacher")==null){
			response.sendRedirect("../Login.jsp");
		}else{
/**************************************************************/
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			try{
				int sno = Integer.parseInt(request.getParameter("sno"));
				int cno = Integer.parseInt(request.getParameter("cno"));
				
				DaoSc update = new DaoSc();	
				SC sc = update.selectone(sno,cno);
				if(sc!=null){
					request.setAttribute("room", sc);
					request.getRequestDispatcher("/tea/updateRoom.jsp?type="+request.getParameter("type")+"&key="+request.getParameter("key")+"").forward(request, response);
				}else{
					out.println("<h2>≤È—Ø ß∞‹£¨«Î…‘∫Û÷ÿ ‘</h2>");
					response.setHeader("refresh",  "2;url=serQuerySc");
				}
			}catch(Exception e){e.printStackTrace();}
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
