package edu.jsp.verify;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verifyEmail")
public class EmailVerification extends HttpServlet {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/j2ee?user=root&password=Vidya@7620";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        if (isValidEmail(email)) {
            try (Connection conn = DriverManager.getConnection(url)) {
                String sql = "SELECT email FROM users WHERE email = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, email);
                    ResultSet rs = pstmt.executeQuery();
                    
                    if (rs.next()) {
                        // Email found
                        out.println("<h3>Email is valid. Redirecting to home page...</h3>");
                        // Redirect to home page
                        response.sendRedirect("verify.html");
                    } else {
                        // Email not found
                        out.println("<h3>Email is invalid. Please try again.</h3>");
                    }
                }
            } catch (Exception e) {
                out.println("<h3>Error occurred while connecting to the database.</h3>");
                e.printStackTrace();
            }
        } else {
            out.println("<h3>Invalid email format. Please enter a valid email.</h3>");
        }
        
        out.close();
    }

    // Method to validate email format
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,4}$");
    }
}
