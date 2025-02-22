package edu.jsp.servletChaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test")
public class Test_Servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		
        writer.println("<h1>This is Test</h2>");
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("text.html");
		dispatcher.include(req, res);
		
	}

}
