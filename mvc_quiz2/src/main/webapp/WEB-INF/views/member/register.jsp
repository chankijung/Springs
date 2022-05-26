<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../default/header.jsp" %>
	<div class="wrap">
		<form action="register" method="post">
			<input type="text" name="id"><br>
			<input type="text" name="pw"><br>
			<input type="text" name="addr"><br>
			<input type="submit" value="회원가입"><br>
		</form>
	</div>
</body>
</html>