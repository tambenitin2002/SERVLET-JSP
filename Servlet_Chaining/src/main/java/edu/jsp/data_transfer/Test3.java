package edu.jsp.data_transfer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test3")
public class Test3  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter writer=res.getWriter();
		
		//Access data which is tranferred by test1
		//downcasting
		
		List<String> subjects =(List) req.getAttribute("listofsubject");
		writer.println("<h1>"+subjects+"</h1>");
		
	}

}
