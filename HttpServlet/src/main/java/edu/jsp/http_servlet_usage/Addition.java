package edu.jsp.http_servlet_usage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Addition extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//feach data from URL parameter / input box
		int num1=Integer.parseInt(req.getParameter("n1"));
		int num2=Integer.parseInt(req.getParameter("n2"));
		int add=num1+num2;
		
		resp.sendRedirect("https://www.facebook.com");
		
		PrintWriter writer=resp.getWriter();
		writer.println("<h1> Addition : "+add+"</h1>");
//		super.doPost(req, resp);  -405 error
	}
}
