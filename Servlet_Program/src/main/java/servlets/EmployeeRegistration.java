package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@WebServlet("/empRegister")
public class EmployeeRegistration extends GenericServlet {

	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Employee employee=new Employee(); 
		
		res.setContentType("text/HTML");
		String id=req.getParameter("id");
		int finalId=Integer.parseInt(id);
		
		String name=req.getParameter("name");
		
		String salary=req.getParameter("salary");
		double finalSalary=Double.parseDouble(salary);
		String designation=req.getParameter("designation");
		PrintWriter writer=res.getWriter();
		employee.setId(finalId);
		employee. setName(name);
		employee.setSalary(finalSalary);
		employee.setDesignation(designation);
		
		
		
		writer.println("Id = "+employee.getId()+"<br>");
		writer.println("Name = " +employee.getName()+"<br>");
		writer.println("Salary = " +employee.getSalary()+"<br>");
		writer.println("Designation = "+employee.getDesignation()+"<br>");
		
	}
}
