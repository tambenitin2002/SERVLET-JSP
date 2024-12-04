package edu.jsp.forword_method;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet2")
public class Servlet2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter writer=res.getWriter();
		writer.println("<h1>Substraction Form</h1>");
		int []arr=(int [])req.getAttribute("array");
		writer.println("<h1>"+Arrays.toString(arr)+"</h1>");
		
	}

}
