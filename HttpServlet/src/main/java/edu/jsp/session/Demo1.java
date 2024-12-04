package edu.jsp.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.cache.internal.DisabledCaching;

@WebServlet("/demo1")
public class Demo1 extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	 
    	 int [] arr= {10,20,30,40,50};
    	 //Transfer the data by using requested
    	 req.setAttribute("numberArr", arr);
    	 //Transfer the data by  using session
    	 HttpSession session=req.getSession();
    	 session.setAttribute("numberArr", arr);
    	 
    	 RequestDispatcher despatcher = req.getRequestDispatcher("demo2");
    	 despatcher.forward(req, resp);
    }
}
