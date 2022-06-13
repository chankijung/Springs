<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="dto" items="${list }">
	아이디 : ${dto.id }<br>
	이름: ${dto.name }<br>
	파일이름 : ${dto.imgName }<br>
	
	<img src="download?file=${dto.imgName }" width="100px" height="100px">
	<hr>
	<a href="download?file=${dto.imgName }">
		${dto.imgName }
	</a>
	<hr>

</c:forEach>
	<a href="form">다시 업로드</a>
	
	
썸네일
</body>
</html>