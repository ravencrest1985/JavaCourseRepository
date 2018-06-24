<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello User</h1>
<br>
<form action="TaskServlet" method="post">
<label>name</label>
<br>
<input type="text" name="name" placeholder="enter name">
<br> 
<label>description</label>
<br>
<input type="text" name="description" placeholder="enter description"> 
<br>
<input type="submit" value="Submit">
</form>
</body>
</html>