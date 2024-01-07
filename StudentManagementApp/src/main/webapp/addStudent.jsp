<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AddStudent" method="post">
	<label>RollNo</label>
	<input type="text" name="inp1"><br>
	<label>Name</label>
	<input type="text" name="inp2"><br>
	<label>Std</label>
	<input type="text" name="inp3"><br>
	<label>Address</label>
	<input type="text" name="inp4"><br>
	<label>Contact</label>
	<input type="text" name="inp5"><br>
	<input type="submit" value="Add">
</form>
<%String message = (String)request.getAttribute("message"); %>
<% if(message != null) { %>
<p color="green"> <%= message %></p>
<%} %>
</body>
</html>