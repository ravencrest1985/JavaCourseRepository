<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add phone number</title>
</head>
<body>
<form action="AddPhoneServlet" method="post" >
<label>Enter phone number</label>
<br>
<input type="text" placeholder="phone number" name="phone">
<br>
<label>user id</label>
<br>
<input type="text" placeholder="user id" name="id">
<br>
<input type="submit" value="submit">
</form>
<br>
<a href="index.jsp">Return to main page</a>
<br>
<a href="search.jsp">Return to search page</a>
</body>
</html>