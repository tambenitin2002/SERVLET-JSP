package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/rf")
public class Register extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
    {
        String name = req.getParameter("username");
        String email = req.getParameter("mail");
        String password = req.getParameter("password");
        String temp = req.getParameter("mobile");
        long mobile = 0; // Default value if mobile is missing or invalid

        // Check if 'temp' is not null and contains only digits
        if (temp != null && temp.matches("\\d+")) {
            try {
                mobile = Long.parseLong(temp);
            } catch (NumberFormatException e) {
                PrintWriter writer = res.getWriter();
                writer.println("Invalid mobile number format.");
                return;
            }
        } else {
            PrintWriter writer = res.getWriter();
            writer.println("Invalid mobile number.");
            return;
        }

        String gender = req.getParameter("gender");
        String[] skills = req.getParameterValues("skill");
        String city = req.getParameter("city");
        String temp1 = req.getParameter("doj");
        Date date = null; // Initialize to null to avoid issues

        if (temp1 != null && !temp1.isEmpty()) {
            try {
                date = Date.valueOf(temp1);
            } catch (IllegalArgumentException e) {
                PrintWriter writer = res.getWriter();
                writer.println("Invalid date format.");
                return;
            }
        }

        String address = req.getParameter("address");

        PrintWriter writer = res.getWriter();
        writer.println("Name = " + name);
        writer.println("Email= " + email);
        writer.println("Password = " + password);
        writer.println("Mobile= " + mobile);
        writer.println("Gender= " + gender);
        writer.println("Skills = " + Arrays.toString(skills));
        writer.println("City = " + city);
        writer.println("Date of Joining = " + date);
        writer.println("Address = " + address);
    }
}
