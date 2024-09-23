<%@page import="modal.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student student = new Student();
		student = (Student) request.getAttribute("student");
	
		out.println("First Name: " + student.getFirstName() + "<br>" + "Last Name: " + student.getLastName() + "<br>"
				+ "Email: " + student.getEmail() + "<br>" + "Phone: " + student.getMobileNumber() + "<br>");
	%>

</body>
</html>