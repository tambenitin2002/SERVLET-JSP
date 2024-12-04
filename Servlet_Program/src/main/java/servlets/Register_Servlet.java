package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//send request by searching URL on Browser
//sending request by using HTML file -HyperLink
@WebServlet("/register")
public class Register_Servlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("This is Registration Servlet...");
		System.out.println("Processing Registration Request...");
		System.out.println("Registration Succesful");
		
	}
	
	

}
