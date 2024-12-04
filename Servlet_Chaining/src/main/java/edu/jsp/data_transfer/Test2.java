package edu.jsp.data_transfer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test2")
public class Test2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter writer=res.getWriter();
		
		//Access data which is tranferred by test1
		//downcasting
		
		long mobile=(Long) req.getAttribute("mobile");
		writer.println("<h1> Mobile: "+mobile+"</h1>");
		
		List<String> subjects=new ArrayList<String>();
		subjects.add("JDBC");
		subjects.add("servlet");
		subjects.add("hibernate");
		
		req.setAttribute("listofsubject", subjects);
		
		RequestDispatcher dispatcher =req.getRequestDispatcher("test3");
		dispatcher.include(req, res);
	}

}
