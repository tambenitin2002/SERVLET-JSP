package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//Extends Generic 

@WebServlet("/sample")
public class Sample_Servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		System.out.println("This is Servlet Class...");
		System.out.println("Type of Servlet Class is GenericServlet.... ");
		
	}
	
	

}
