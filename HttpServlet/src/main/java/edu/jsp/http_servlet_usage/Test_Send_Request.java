package edu.jsp.http_servlet_usage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class Test_Send_Request extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter writer=resp.getWriter();
    	writer.println("This is Test class...");
    	
    	//Test_send_Redirect class should communicate with Add.html
    	//Servlet Chaining 
    	//Controls shift to requested file
    	//Provides final response to the user.
    	//Can't tranfer data
    	//Communicate with internal  & external resourses
    	resp.sendRedirect("Add.html");
    }
}
