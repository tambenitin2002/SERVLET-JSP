package edu.jsp.emailverify;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verifypassservlet")
public class VerifyPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        String passwordFromDb = (String) session.getAttribute("pwdFromDb");

        if (password.equals(passwordFromDb)) {
            String ename = (String) session.getAttribute("empName");
            PrintWriter writer = resp.getWriter();
            writer.println("WELCOME " + ename + "!!!");
        } else {
            resp.sendRedirect("Email.html");
        }
    }
}
