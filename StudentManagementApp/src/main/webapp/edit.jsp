<%@page import="dao.StudentJdbc"%>
<%@page import="dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% StudentJdbc sj = new StudentJdbc(); %>
<% int rollNo = Integer.parseInt(request.getParameter("rollNo")); %>
<% Student s = sj.retriveStudentByRollNo(rollNo); %>
<form action="EditStudent" method="post">
	<label>RollNo</label>
	<input type="text" name="inp1" value="<%= s.getStudentRollNo() %>"><br>
	<label>Name</label>
	<input type="text" name="inp2" value="<%= s.getStudentName() %>"><br>
	<label>Std</label>
	<input type="text" name="inp3" value="<%= s.getStudentStd() %>"><br>
	<label>Address</label>
	<input type="text" name="inp4" value="<%= s.getStudentAddress()%>"><br>
	<label>Contact</label>
	<input type="text" name="inp5" value="<%= s.getStudentContact()%>"><br>
	<input type="submit" value="Edit">
</form>
<%String message = (String)request.getAttribute("message"); %>
<% if(message != null) { %>
<p color="green"> <%= message %></p>
<%} %>
</body>
</html>