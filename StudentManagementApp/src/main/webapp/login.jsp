<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Login" method="post">
<label>Email</label>
<input type="text" name="inp1"><br>
<label>Password</label>
<input type="password" name="inp2"><br>
<input type="submit" value="Login">
</form>
<%String message = (String)request.getAttribute("message"); %>
<% if(message != null) { %>
<p color="green"> <%= message %></p>
<%} %>
</body>
</html>