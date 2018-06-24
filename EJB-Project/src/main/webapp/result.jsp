<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="entity.Task" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Result page</h1>
<br>
<%List<Task>lista=(List<Task>)request.getAttribute("list"); %>
<%if(lista!=null && !lista.isEmpty()){ %>
<%for(Task tmp:lista){%>
<%=tmp.getName() %>
<%=tmp.getDescription()%>
<%}%>
<%} %>
</body>
</html>