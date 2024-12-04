package edu.jsp.data_transfer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/test1")
public class Test1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println("<h1 style='color:blue'>THIS TEST1 CLASS OUTPUT</h1>");
		
		/*
		 * Transfer data - during servlet chaining to another servlet
		 * class or JSP file , can't transfer to HTML file
		 * call setAttribute()
		 * 1st argument - identifire
		 * 2nd argument - data
		 * Data gets upcast to object class 
		 */
		
		req.setAttribute("mobile", 964628874l);
		writer.println("<h2 style='color:green'>The data transfer successful</h2>");
		
		
		//Test1 servlet should 
		
		RequestDispatcher dispatcher =req.getRequestDispatcher("test2");
		dispatcher.include(req, res);
	}

}
