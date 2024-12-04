package edu.jsp.emailverify;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/vemail")
public class VerifyEmailServlet extends HttpServlet {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/j2ee?user=root&password=Vidya@7620";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url);

            String query = "SELECT fname, email, password FROM user WHERE email=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String passwordFromDb = rs.getString("password");
                String ename = rs.getString("fname");
                HttpSession session = req.getSession();
                session.setAttribute("empName", ename);
                session.setAttribute("pwdFromDb", passwordFromDb);
                resp.sendRedirect("Password.html");
            } else {
                resp.sendRedirect("Verify.html");
            }

            // Remove redundant session code
            // HttpSession session = req.getSession();
            // String em = (String) session.getAttribute("email");

            // Dispatcher configuration not needed here
            // RequestDispatcher despatcher = req.getRequestDispatcher("verifypassservlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
