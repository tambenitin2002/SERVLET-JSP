package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/print")
public class Print_OutPut_On_Browser extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//ServletResponse interface -javax.servlet package
		//getWriter() to print output on browser - return object of
		//PrintWriter class - java.io package
 		PrintWriter print=res.getWriter();
		print.println("<h1>THIS IS SERVLET CLASS OUTPUT ON BROWSER</h1>");
		
	}
	
	

}
