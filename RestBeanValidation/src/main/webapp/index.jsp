<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Rest Validation</h1>
<form action="api/Person" method="post">
<label>Person name</label>
<br>
<input type="text" placeholder="enter person name" name="name">
<br>
<label>Person age</label>
<br>
<input type="text" placeholder="enter person age" name="age">
<br>
<input type="submit" value="submit">
</form>
</body>
</html>