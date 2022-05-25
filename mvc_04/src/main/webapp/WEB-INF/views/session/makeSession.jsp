<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	makeSession
	
	id : ${id }<br>
	se id: ${sessionScope.id}<br>
	name:${name }<br>
	
	<a href="resultSession">결과확인</a>
	<a href="delSession">삭제</a>
</body>
</html>