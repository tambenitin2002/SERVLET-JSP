package edu.jsp.http_servlet_usage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login_Servlet  extends HttpServlet {
	
          @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	String email=req.getParameter("email");
        	String password=req.getParameter("password");
        	
        	System.out.println("Email = "+ email);
        	System.out.println("Password= "+ password);
        	
        	
//        	RequestDispatcher dispatcher=req.getRequestDispatcher("Welcome.html");
//        	dispatcher.forward(req, resp);
        	
        	resp.sendRedirect("Welcome.html");
        }
}
