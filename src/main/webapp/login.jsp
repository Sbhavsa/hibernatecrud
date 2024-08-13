<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<% String msg = (String)request.getAttribute("msg"); %>
<%if(msg!=null){ %>

<% out.print(msg); %>
<%} %>
<%
	String msg1 = (String) request.getAttribute("msg1");
	%>
	<%
	if (msg1 != null) {
	%>
	<%
	out.print(msg1);
	%>
	<%
	}
	%>
<form action="usercontroller" method="post">
<table>
    <tr><td>email: </td><td><input type="email" name="email"></td></tr>
         <tr><td>password : </td><td><input type="password" name="password"></td></tr>
         <tr><td><input type="submit" name="action" value="login"></td></tr>
         



</table>
</form>
</body>
</html>