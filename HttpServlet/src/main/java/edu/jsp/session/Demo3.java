 package edu.jsp.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/demo3")
public class Demo3 extends HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  int numbers[]=(int [])req.getAttribute("numberArr");
		HttpSession session =req.getSession();
		int [] sessionNumbers=(int [] )session.getAttribute("numberArr");
		
		PrintWriter writer = resp.getWriter()	;
		writer.println("Requasted data= "+Arrays.toString(numbers));
		writer.println("Session data = "+Arrays.toString(sessionNumbers));
		
}
}
