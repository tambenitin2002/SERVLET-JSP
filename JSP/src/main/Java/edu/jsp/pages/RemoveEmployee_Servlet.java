//package edu.jsp.pages;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/remove")
//public class RemoveEmployee_Servlet extends HttpServlet  {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		
//		int id = Integer.parseInt(req.getParameter("id"));
//		EmployeeDao dao = new EmployeeDao();
//		
//		try {
//		    int record = dao.removeEmployeeById(id);
//		    HttpSession session = req.getSession();
//		    if(record != 0) {
//		    	session.setAttribute("message", "DATA REMOVED SUCCESSFULLY!!!");
//		    }else {
//		    	session.setAttribute("message", "INVALID EMPLOYEE ID...");
//		    }
//		    RequestDispatcher dispatcher=req.getRequestDispatcher("getallemployees");
//		    dispatcher.forward(req, resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}


package edu.jsp.pages;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/remove")
public class RemoveEmployee_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao dao = new EmployeeDao();
        try {
            int result = dao.removeEmployeeById(Integer.parseInt(req.getParameter("id")));
            HttpSession session = req.getSession();
            if (result > 0) {
                session.setAttribute("message", "Employee deleted successfully.");
            } else {
                session.setAttribute("message", "Error in deleting employee.");
            }
            resp.sendRedirect("getallemployees");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
