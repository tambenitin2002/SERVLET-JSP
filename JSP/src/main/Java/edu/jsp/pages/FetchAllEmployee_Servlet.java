//package edu.jsp.pages;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/getallemployees")					
//public class FetchAllEmployee_Servlet extends HttpServlet {
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		EmployeeDao dao=new EmployeeDao();
//		try {
//			 List<Employee> employees=dao.getAllEmployee();
//			 HttpSession session= req.getSession()	;
//			 session.setAttribute("listOfEmployee",employees);
//			 RequestDispatcher dispatcher=req.getRequestDispatcher("DisplayAllEmployee.jsp");
//			 dispatcher.forward(req, resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//  
//}

package edu.jsp.pages;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/getallemployees")
public class FetchAllEmployee_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao dao = new EmployeeDao();
        try {
            List<Employee> employees = dao.getAllEmployee();
            HttpSession session = req.getSession();
            session.setAttribute("listOfEmployees", employees);
            RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayAllEmployee.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
