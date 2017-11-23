<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h2>Send message -jms 2.0</h2>
<br>
<form action="ReciveMessage" method="get">
<br> 
<label>Message</label>
<br>
<input type="text" placeholder="enter mail massage" name="userMessage">
<br>
<label>User name</label>
<br>
<input type="text" placeholder="enter user name" name="userName">
<br>
<input type="submit" value="submit">
</form>
</body>
</html>