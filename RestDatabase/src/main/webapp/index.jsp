<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>Welcome to Rest</h1>
<form action="ServletAddPerson" method="post">
<label>Person name</label>
<br>
<input type="text" placeholder="name" name="name">
<br>
<label>Person age</label>
<br>
<input type="text" placeholder="age" name="age">
<br>
<label>Phone number</label>
<br>
<input type="text" placeholder="Phone number" name="number">
<br>
<input type="submit" value="submit">
</form>
</body>
</html>