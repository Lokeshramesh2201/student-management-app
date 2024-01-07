<%@page import="dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addStudent.jsp">
<input type="submit" value="AddStudent">
</form>

<%String message = (String)request.getAttribute("message"); %>
<% if(message != null) { %>
<p color="green"> <%= message %></p>
<%} %>
<%List<Student> AllStudents = (List)request.getAttribute("AllStudents"); %>
<table border="1">
<tr>
<th>RollNo</th>
<th>Name</th>
<th>Std</th>
<th>Address</th>
<th>Contact</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<% for(Student s : AllStudents) {%>
<tr>
<td><%= s.getStudentRollNo()%></td>
<td><%= s.getStudentName()%></td>
<td><%= s.getStudentStd()%></td>
<td><%= s.getStudentAddress()%></td>
<td><%= s.getStudentContact()%></td>
<td><a href="edit.jsp?rollNo=<%= s.getStudentRollNo()%>">Edit</a></td>
<td><a href="Delete?rollNo=<%= s.getStudentRollNo()%>">Edit</a></td>
</tr>
<%} %>
</table>
<form action="Logout" method="post">
<input type="submit" value="LogOut">
</form>
</body>
</html>