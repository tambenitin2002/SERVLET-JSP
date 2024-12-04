<%-- 
<%@page import="edu.jsp.pages.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Employee emp=(Employee) request.getAttribute("empObject");
%>
 <center>
 <form>
 <h1>Employee Data</h1>
 <label>Employee Id: </label>
 <input type="number" name="id" placeholder="Employee Id" value=<%=emp.getEmpId() %>>
 <label>Employee Name: </label>
 <input type="text" name="name" placeholder="Employee Name" value=<%=emp.getEname() %> >
 <label>Employee Email: </label>
 <input type="text" name="email" placeholder="Employee Email"  value=<%=emp.getEmail() %>>
 <label>Employee Mobile: </label>
 <input type="number" name="mobile" placeholder="Employee Mobile" value=<%=emp.getMobile() %> >
 <label>Employee Salary: </label>
 <input type="text" name="salary" placeholder="Employee Salary" value=<%=emp.getSalary() %>>
 <input type="submit" value="submit">
 </form>
 </center>
</body>
</html>

--%>

<%@page import="edu.jsp.pages.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
</head>
<body>
<%
Employee emp = (Employee) request.getAttribute("empObject");
%>
<center>
    <form action="updateEmployee" method="post">
        <h1>Update Employee</h1>
        <label>Employee Id: </label>
        <input type="number" name="id" value="<%= emp.getEmpId() %>" readonly><br>
        <label>Name: </label>
        <input type="text" name="name" value="<%= emp.getEname() %>"><br>
        <label>Email: </label>
        <input type="text" name="email" value="<%= emp.getEmail() %>"><br>
        <label>Mobile: </label>
        <input type="number" name="mobile" value="<%= emp.getMobile() %>"><br>
        <label>Salary: </label>
        <input type="text" name="salary" value="<%= emp.getSalary() %>"><br>
        <input type="submit" value="Update">
    </form>
</center>
</body>
</html>

