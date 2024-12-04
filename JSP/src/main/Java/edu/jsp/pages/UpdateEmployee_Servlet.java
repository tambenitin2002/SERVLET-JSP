package edu.jsp.pages;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/updateEmployee")
public class UpdateEmployee_Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao dao = new EmployeeDao();
        Employee emp = new Employee();
        emp.setEmpId(Integer.parseInt(req.getParameter("id")));
        emp.setEname(req.getParameter("name"));
        emp.setEmail(req.getParameter("email"));
        emp.setMobile(Long.parseLong(req.getParameter("mobile")));
        emp.setSalary(Double.parseDouble(req.getParameter("salary")));

        try {
            int result = dao.updateEmployee(emp);
            HttpSession session = req.getSession();
            if (result > 0) {
                session.setAttribute("message", "Employee updated successfully.");
            } else {
                session.setAttribute("message", "Error in updating employee.");
            }
            resp.sendRedirect("getallemployees");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
