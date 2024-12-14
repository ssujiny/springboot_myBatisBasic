<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myView</title>
</head>
<body>
<%
	out.println("Model(Sub) : Hello World");
%>
<br />
${ObjectTest}

<br />

${lists}

<br />
<br />
<c:forEach var="mylist" items="${lists}">
	${mylist} <br />
</c:forEach>

<br />
<br />
당신의 이름은 ${name}입니다.

</body>
</html>