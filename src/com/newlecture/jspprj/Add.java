package com.newlecture.jspprj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class Add extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int x = 0;
		int y = 0;
		
		if(request.getMethod().equals("POST"))
		{
			String _x = request.getParameter("x");
			String _y = request.getParameter("y");
			
			if(_x != null && !_x.equals(""))
				x = Integer.parseInt(_x);
			
			if(_y != null && !_y.equals(""))
				y = Integer.parseInt(_y);
		}
		
		int sum = x + y;		
		
		String _save = request.getParameter("save");		
		
		if(_save != null)
		{			
			String _sum = request.getParameter("sum");
			
			//_save = new String(_save.getBytes("ISO-8859-1"), "UTF-8");
			System.out.println(_save);
			
			if(_save.equals("¾Û"))
			{
				ServletContext application = request.getServletContext();
				application.setAttribute("sum", _sum);
				System.out.println("saved in app");
			}
			else if(_save.equals("session"))
			{
				HttpSession session = request.getSession();
				session.setAttribute("sum", _sum);
				System.out.println("saved in session");
			}
			else if(_save.equals("cookie"))
			{
				Cookie cookie = new Cookie("sum", _sum);
				cookie.setMaxAge(24*60*60); //24½Ã°£
				response.addCookie(cookie);
				
				System.out.println("saved in cookie");
			}
			
		}
		
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("		<ul>");
		out.write("			<li><label for=\"x\">X :</label><input name=\"x\" /></li>");
		out.write("			<li><label for=\"y\">Y :</label><input name=\"y\" /></li>");
		out.write("			<li><label for=\"sum\">Sum :</label><input name=\"sum\" value=\""+sum+"\" /></li>");
		out.write("		</ul>");
		out.write("		<p>");
		out.write("			<input type=\"submit\" name=\"add\" value=\"µ¡¼À\" />");
		out.write("			<input type=\"submit\" name=\"save\" value=\"¾Û\" />");
		out.write("			<input type=\"submit\" name=\"save\" value=\"session\" />");
		out.write("			<input type=\"submit\" name=\"save\" value=\"cookie\" />");
		out.write("		</p>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
	}
	
	/*@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int x = 0;
		int y = 0;		
		
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
				
		if(_x != null && !_x.equals(""))
			x = Integer.parseInt(_x);
		
		if(_y != null && !_y.equals(""))
			y = Integer.parseInt(_y);
		
		int sum = x + y;
		
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("		<ul>");
		out.write("			<li><label for=\"x\">X :</label><input name=\"x\" /></li>");
		out.write("			<li><label for=\"y\">Y :</label><input name=\"y\" /></li>");
		out.write("			<li><label for=\"y\">Sum :</label><input value=\""+sum+"\" /></li>");
		out.write("		</ul>");
		out.write("		<p>");
		out.write("			<input type=\"submit\" value=\"µ¡¼À\" />");
		out.write("		</p>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");

	}*/
}





