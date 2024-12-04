<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>This is first jsp file</h1>
  <%-- Expresion (<% %>) to write code --%>
 <%
 String [] subject={"java","sql"};%>
 <%-- Expresion (<%= %>) to print output --%>
<h1><%=Arrays.toString(subject) %></h1>
</body>
</html>