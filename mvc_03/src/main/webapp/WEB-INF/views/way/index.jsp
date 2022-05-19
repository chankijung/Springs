<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${pageContext.request.contextPath }
<h1>기본 페이지</h1>

<%= request.getAttribute("way") %>
<a href="login1">로그인 페이지</a>
<a href="${pageContext.request.contextPath }/logout1">로그아웃 페이지</a>
</body>
</html>