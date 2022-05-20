<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<table>
		<tr>
			<td>id</td> <td>password</td> <td>name</td>
		<tr>
		<c:forEach var"dto" items="${list }">
		<tr>
			<td>${dto.id }</td>
			<td>${dto.pwd }</td>
			<td>${dto.name}</td>
		
		</c:forEach>
		<tr>
			<td colspan="3"><a href="index">인덱스 이동</a></td>
		</tr>
	</table>

</body>
</html>