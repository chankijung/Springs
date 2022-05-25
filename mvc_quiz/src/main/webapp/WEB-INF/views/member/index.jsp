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

<form action="login" method="get">
	id &nbsp&nbsp<input type="text" name="id"><br>
	pwd<input type="password" nae="pwd"><br>
	<input type="button" value="로그인">
</form>
<h1><a href="join">회원가입</a></h1>
<h1><a href="views">모든 회원 목록</a></h1>

</body>
</html>