<%-- 
 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="edu.jsp.product.Product"%>
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
  <h1>This is a demo file</h1>

  <%
   String [] subjects = {"JAVA","SQL","HTML","CSS"};
  
  %>

  <h1><%= Arrays.toString(subjects) %></h1>
  
  
</body>
</html>

--%>