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
<h1>회원가입 페이지</h1>
	<form action="reg" method="post">
		<input type="text" value="id" ><br>
		<input type="password" value="pwd" ><br>
		<input type="text" value="name" ><br>
		<input type="submit" value="가입">
	
	</form>

</body>
</html>