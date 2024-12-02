<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userList</title>
</head>
<body>
	<%
		out.println("MyBatis : Hello World");
	%>
	
	<br />
	
	<c:forEach var="dto" items="${users}">
		${dto.id} / ${dto.name} <br />
	</c:forEach>
</body>
</html>