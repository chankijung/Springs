<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="contextPath"
	value="${pageContext.request.contextPath }"/>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../default/header.jsp" %>
	
	<div class="wrap" style="text-align : right">
	<form action="${contextPath }/member/logChk" method="post">
		<input type="text" name="id" placeholder="input id"><br>
		<input type="password" name="pwd" placeholder="input pwd"><br>
		<input type="submit" value="로그인">
		<a href="#">회원가입</a>
	</form>
	</div>
	
	<%@ include file="../default/footer.jsp" %>
</body>
</html>