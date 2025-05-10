<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chart</title>
</head>
<body>

	<h1>CHART 데이터</h1>
	<table width="500" celpadding="0" cellspacing="0" border="1">
		<tr>
			<td>날짜</td>
			<td>이름</td>
			<td>비율</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.useDate}</td>
			<td>${dto.type} - ${dto.color} ${dto.num} </td>
			<td>${dto.ratio}</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>