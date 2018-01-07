<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h1>Result page</h1>
<br>
<%!String message; %>
<%message=(String)request.getAttribute("message"); %>
<%if (message!=null){ %>
<%=message %>
<%} %>
<br>
<a href="index.jsp">return to main page</a>
<br>
<a href="search.jsp">return to search page</a>
<br>
<a href="phone.jsp">return to add phone page</a>
</body>
</html>