package edu.jsp.forword_method;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet1")
public class Servlet1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter writer=res.getWriter();
		writer.println("<h1>Addition Form</h1>");
		
		req.setAttribute("array", new int[] {10,20,30});
		
		//In Final output, it won't include response of current servlet
		
		RequestDispatcher despater=req.getRequestDispatcher("servlet2");
		despater.forward(req, res);
		
		writer.println("<h1> This is servlet1 </h1>");
	}

}
