package edu.jsp.httpsopratons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {
    
    public int addBook(BookInfo book) {
        int rowsInserted = 0;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/j2ee?user=root&password=Vidya@7620";
        
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url);
            
            String query = "INSERT INTO book (id, bname, type, pages, price, aname) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            
            // Set parameters
            pstmt.setInt(1, book.getId());
            pstmt.setString(2, book.getBname());
            pstmt.setString(3, book.getType());
            pstmt.setInt(4, book.getPages());
            pstmt.setDouble(5, book.getPrice());
            pstmt.setString(6, book.getAname());
            
            // Execute the insert statement
            rowsInserted = pstmt.executeUpdate();
            
            // Clean up
            pstmt.close();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return rowsInserted;
    }
}
