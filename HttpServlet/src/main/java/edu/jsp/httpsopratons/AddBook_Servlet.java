package edu.jsp.httpsopratons;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addbook")
public class AddBook_Servlet extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter writer=response.getWriter();
        // Retrieve form data
        int id = Integer.parseInt(request.getParameter("id"));
        String bookname = request.getParameter("bookname");
        String type = request.getParameter("select"); // 'select' should be 'select' in HTML
        int noofpage = Integer.parseInt(request.getParameter("noofpage"));
        double bookprice = Double.parseDouble(request.getParameter("bookprice"));
        String authname = request.getParameter("authname");
        
        // Create BookInfo object
        BookInfo book = new BookInfo();
        book.setId(id);
        book.setBname(bookname);
        book.setType(type);
        book.setPages(noofpage);
        book.setPrice(bookprice);
        book.setAname(authname);
        
        // Call DAO to add book to database
        BookDao bookDao = new BookDao();
        int rowsAffected = bookDao.addBook(book);
        
        // Redirect or forward based on success
        if(rowsAffected>0) {
        	
        	writer.println("<h1 style='color:green'>One Record Updated!</h1> ");
        }else {
        	writer.println("<h1 style='color:red'>Something wrong went!</h1> ");
        }
    }
}
