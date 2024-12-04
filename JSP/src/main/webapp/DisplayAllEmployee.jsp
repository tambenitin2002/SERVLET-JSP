<%-- 
<%@page import="java.awt.geom.Path2D"%>
<%@page import="edu.jsp.pages.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    table,td{
      font-size:25px;
      border-collapse: collapse;
      font-style:bold;
      margin-top:25px;
      padding:20px;
      text-align:center;
      border: 2px solid black;
    }
</style>
</head>
<body>
<center>
  <h1>GET ALL EMPLOYEES DETAILS
  <a href="getallemployees">CLICK HERE</a>
  </h1>
  <%
  List<Employee> employees=(List) session.getAttribute("listOfEmployees");
  if(employees != null){
	
  %>
  
  <table>
  <tr>
   <td>EmpId</td>
   <td>Ename</td>
   <td>Salary</td>
   <td>Email</td>
   <td>Mobile</td>
  </tr>
  <% for(Employee e1 : employees){ %>
  <tr>
   <td><%= e1.getEmpId() %></td>
   <td><%= e1.getEname() %></td>
   <td><%= e1.getSalary() %></td>
   <td><%= e1.getEmail() %></td>
   <td><%= e1.getMobile() %></td>
   <td>
   <a href="remove?id=<%=e1.getEmpId() %>"><button >DELETE</button></a>
  <a href="findById?id=<%=e1.getEmpId() %>"><button>UPDATE</button></a>
   </td>
   
  </tr>
  
  <% } //CLOSE FOR EACH LOOP %>
  
  </table>
  <% };//CLOSE IF BLOCK
  String message = (String) session.getAttribute("message");
  if(message != null){
  %>
  
   <h2 style="color:green"><%= message %></h2>
   <% }; %>
</center>
</body>
</html>

--%>


 <%@page import="edu.jsp.pages.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <style>
        table, td {
            font-size: 25px;
            border-collapse: collapse;
            margin-top: 25px;
            padding: 20px;
            text-align: center;
            border: 2px solid black;
        }
        h1 {
            margin-bottom: 20px;
        }
        button {
            padding: 10px;
        }
    </style>
</head>
<body>
    <center>
        <h1>Employee List</h1>
        <a href="getallemployees">Click Here to View All Employees</a>
        <%
        List<Employee> employees = (List<Employee>) session.getAttribute("listOfEmployees");
        if (employees != null && !employees.isEmpty()) {
        %>
        <table>
            <tr>
                <td>EmpId</td>
                <td>Name</td>
                <td>Salary</td>
                <td>Email</td>
                <td>Mobile</td>
                <td>Actions</td>
            </tr>
            <% for (Employee emp : employees) { %>
            <tr>
                <td><%= emp.getEmpId() %></td>
                <td><%= emp.getEname() %></td>
                <td><%= emp.getSalary() %></td>
                <td><%= emp.getEmail() %></td>
                <td><%= emp.getMobile() %></td>
                <td>
                    <a href="remove?id=<%= emp.getEmpId() %>"><button>Delete</button></a>
                    <a href="findById?id=<%= emp.getEmpId() %>"><button>Update</button></a>
                </td>
            </tr>
            <% } %>
        </table>
        <% } else { %>
        <h3>No employee records found.</h3>
        <% } %>
        <% String message = (String) session.getAttribute("message"); if (message != null) { %>
        <h2 style="color: green;"><%= message %></h2>
        <% session.removeAttribute("message"); } %>
    </center>
</body>
</html>
 
