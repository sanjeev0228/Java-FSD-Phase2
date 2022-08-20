<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
String user= request.getParameter("txtName");
pageContext.setAttribute("username",user,PageContext.SESSION_SCOPE);



%>


<a href="Second.jsp">CLICK</a>

</body>
</html>