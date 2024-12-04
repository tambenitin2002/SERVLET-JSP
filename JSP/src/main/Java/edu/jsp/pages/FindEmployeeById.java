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
//@WebServlet("/findById")
//public class FindEmployeeById extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      EmployeeDao dao=new EmployeeDao();
//      try {
//		Employee emp=dao.findEmployeeById(Integer.parseInt(req.getParameter("id")));
//		if(emp!=null) {
//			//display update page along with employee information
//			req.setAttribute("empObject", emp);
//			RequestDispatcher  dispatcher=req.getRequestDispatcher("UpdateEmployee.jsp");
//			dispatcher.forward(req, resp);
//		}else {
//			HttpSession session=req.getSession();
//			session.setAttribute("message", "Invalid employee id...");
//			resp.sendRedirect("getallemployees");
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	}
//}


package edu.jsp.pages;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/findById")
public class FindEmployeeById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao dao = new EmployeeDao();
        try {
            Employee emp = dao.findEmployeeById(Integer.parseInt(req.getParameter("id")));
            if (emp != null) {
                req.setAttribute("empObject", emp);
                RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateEmployee.jsp");
                dispatcher.forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("message", "Invalid Employee ID.");
                resp.sendRedirect("getallemployees");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
