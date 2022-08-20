<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("txtuname");
application.setAttribute("username", name);
out.println("hello"+name);

%>
<a href="Dashboard.jsp">Dashboard</a>
</body>
</html>