<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate</title>
</head>
<body>
<form action="Calculate.jsp">
<input type="text" name="txtNum" >
<input type ="submit">

</form>

<%
String snum=request.getParameter("txtNum");
if(snum!=null){
	int num=Integer.parseInt(snum);
	for(int i=1;i<=5;i++){
		out.println(num*i);
	}
}





%>

</body>
</html>