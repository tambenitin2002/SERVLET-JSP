//package edu.jsp.pages;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.mysql.cj.protocol.Resultset;
//
//public class EmployeeDao {
//	
//	private static Connection connection;
//	private static PreparedStatement pstmt;
//	
//	{
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=Vidya@7620");
//		} catch (Exception e) {
//			
//		}
//	}
//	public List<Employee> getAllEmployee() throws SQLException{
//		 String query="SELECT * FROM employees";
//		 pstmt =connection.prepareStatement(query);
//		 ResultSet rs=pstmt.executeQuery();
//		 if(rs.isBeforeFirst()) {
//			 List<Employee> employees=new ArrayList<Employee>();
//			 while(rs.next()) {
//				 Employee emp=new  Employee();
//				 emp.setEmpId(rs.getInt("eid"));
//				 emp.setEmail(rs.getString("ename"));
//				 emp.setSalary(rs.getDouble("salary"));
//				 emp.setEmail(rs.getString("email"));
//				 emp.setMobile(rs.getLong("mobile"));
//				 
//				 employees.add(emp);
//			 }
//			 return employees;
//		 }
//		 return null;
//	}
//	public int removeEmployeeById(int id) throws SQLException {
//		String query="DELETE FROM employees where EId = ?";
//		pstmt = connection.prepareStatement(query);
//		pstmt.setInt(1, id);
//		int record = pstmt.executeUpdate();
//		return record;
//		
//	}
//	
//	public Employee findEmployeeById(int id) throws SQLException{
//		String query="SELECT * FROM employees WHERE eid=?";
//		pstmt=connection.prepareStatement(query);
//	    pstmt.setInt(1, id);
//	    ResultSet rs=pstmt.executeQuery();	
//	    if(rs.next()) {
//	    	Employee emp=new Employee();
//	    	emp.setEmail(rs.getString("ename"));
//	    	emp.setEmpId(rs.getInt("eid"));
//	    	emp.setSalary(rs.getDouble("salary"));
//	    	emp.setMobile(rs.getLong("mobile"));
//	    	 emp.setEmail(rs.getString("email"));
//	    	 return emp;
//	    }
//	    return null;
//	}
// 
//	 
//}
//


package edu.jsp.pages;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static Connection connection;
    private static PreparedStatement pstmt;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=Vidya@7620");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployee() throws SQLException {
        String query = "SELECT * FROM employees";
        pstmt = connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        List<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmpId(rs.getInt("eid"));
            emp.setEname(rs.getString("ename"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setEmail(rs.getString("email"));
            emp.setMobile(rs.getLong("mobile"));
            employees.add(emp);
        }
        return employees;
    }

    public Employee findEmployeeById(int id) throws SQLException {
        String query = "SELECT * FROM employees WHERE eid = ?";
        pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Employee emp = new Employee();
            emp.setEmpId(rs.getInt("eid"));
            emp.setEname(rs.getString("ename"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setEmail(rs.getString("email"));
            emp.setMobile(rs.getLong("mobile"));
            return emp;
        }
        return null;
    }

    public int removeEmployeeById(int id) throws SQLException {
        String query = "DELETE FROM employees WHERE eid = ?";
        pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }

    public int updateEmployee(Employee emp) throws SQLException {
        String query = "UPDATE employees SET ename=?, salary=?, email=?, mobile=? WHERE eid=?";
        pstmt = connection.prepareStatement(query);
        pstmt.setString(1, emp.getEname());
        pstmt.setDouble(2, emp.getSalary());
        pstmt.setString(3, emp.getEmail());
        pstmt.setLong(4, emp.getMobile());
        pstmt.setInt(5, emp.getEmpId());
        return pstmt.executeUpdate();
    }
}
