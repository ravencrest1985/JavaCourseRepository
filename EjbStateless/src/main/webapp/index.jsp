<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to page</h2> 
<br>
<form action="JobServletAdd" method="post">
<label>Job name</label>
<br>
<input type="text" name="job_name" placeholder="job_name">
<br>
<label>Job desc</label>
<br>
<input type="text" name="job_desc" placeholder="job_desc">
<input type="submit" value="submit">
</form>
</body>
</html>