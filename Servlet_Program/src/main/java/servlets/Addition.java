package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/add")
public class Addition extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String num1=req.getParameter("num1");
		int fnum1=Integer.parseInt(num1);
		String num2=req.getParameter("num2");
		int fnum2=Integer.parseInt(num2);
		
		int resl=fnum1+fnum2;
		
		PrintWriter writer=res.getWriter();
		writer.println("num1 = " +num1);
		writer.println("num2 = " +num1);
		writer.println("resl = " +resl);	
	}
	
}
